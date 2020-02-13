package com.scraper.facade;

import com.scraper.mapper.WebsiteMapper;
import com.scraper.model.domain.Rule;
import com.scraper.model.domain.Website;
import com.scraper.model.request.RuleRequest;
import com.scraper.model.response.ResponseList;
import com.scraper.repository.WebsiteRepository;
import com.scraper.service.impl.FeedService;
import com.scraper.service.impl.ScrapService;
import com.scraper.service.impl.WebsiteService;
import javassist.NotFoundException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class WebsiteFacade {

  WebsiteService websiteService;

  ScrapService scrapService;

  FeedService feedService;

  WebsiteRepository websiteRepository;

  @Autowired
  public WebsiteFacade(WebsiteService websiteService,
      FeedService feedService,
      ScrapService scrapService,
      WebsiteRepository websiteRepository) {
    this.websiteService = websiteService;
    this.feedService = feedService;
    this.scrapService = scrapService;
    this.websiteRepository = websiteRepository;
  }

  public String scrap() throws IOException {
    ResponseList websites = websiteService.findAll();
    return scrapService.scrapAndSave(websites.getPlainResponses());
  }

  public String scrapChildren(final Long id) throws IOException {
    ResponseList childrenById = websiteService.findChildrenById(id);
    return scrapService.scrapAndSave(childrenById.getPlainResponses());
  }

  public ResponseList createChildren(Long id, RuleRequest ruleRequest) throws NotFoundException, IOException {
    //id - is id of parent page
    //1. find parent page
    final Optional<Website> maybeParent = websiteRepository.findById(id);
    if (!maybeParent.isPresent()) throw new NotFoundException("Website not found.");
    //2. based on that rule "scrap" that page element
    final Elements elements = scrapService.processWebsiteChildren(maybeParent.get());
    //4. based on that element and fetched rule create children websites
    List<Website> websites = new ArrayList<>();
    Rule rule = WebsiteMapper.fromRuleRequestToRule(ruleRequest);
    for (Element element : elements) {
      // maybe if all rule parameters already exist fetch that one from db
      // idea, because maybe then Set will prevent insert of multiple same rules
      Website website = scrapService.saveWebsiteChildren(element, maybeParent.get(), rule);
      websites.add(website);
    }
    //5. return children websites
    //6. in scrap controller create route to scrap websites by ids - next step
    return WebsiteMapper.fromWebsitesToWebsiteResponseList(websites);
  }
}
