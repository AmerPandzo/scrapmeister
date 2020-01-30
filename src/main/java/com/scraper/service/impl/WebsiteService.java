package com.scraper.service.impl;

import com.scraper.mapper.WebsiteMapper;
import com.scraper.model.domain.Website;
import com.scraper.model.request.WebsiteRequest;
import com.scraper.model.response.Response;
import com.scraper.model.response.WebsiteResponse;
import com.scraper.model.response.WebsiteResponseList;
import com.scraper.repository.RuleRepository;
import com.scraper.repository.WebsiteRepository;
import com.scraper.service.IWebsiteService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class WebsiteService implements IWebsiteService {

  private WebsiteRepository websiteRepository;
  private RuleRepository ruleRepository;

  @Autowired
  public WebsiteService(WebsiteRepository websiteRepository, RuleRepository ruleRepository) {
    this.websiteRepository = websiteRepository;
    this.ruleRepository = ruleRepository;
  }

  public WebsiteResponseList findAll() {
    return WebsiteMapper.fromWebsitesToWebsiteResponseList(websiteRepository.findAll());
  }

  public WebsiteResponseList findAllByIds(List<Long> ids) {
    return WebsiteMapper.fromWebsitesToWebsiteResponseList(websiteRepository.findAllById(ids));
  }

  public Response findById(Long id) {
    final Optional<Website> optionalWebsite = websiteRepository.findById(id);
    if (optionalWebsite.isPresent()) {
      final WebsiteResponse websiteResponse = WebsiteMapper.fromWebsiteToWebsiteResponse(optionalWebsite.get());
      websiteResponse.setStatus(HttpStatus.OK);
      websiteResponse.setMessage("Fetched successfully.");
      return websiteResponse;
    } else {
      final WebsiteResponse websiteResponse = new WebsiteResponse();
      websiteResponse.setMessage("Not found.");
      websiteResponse.setStatus(HttpStatus.NOT_FOUND);
      return websiteResponse;
    }
  }

  public void deleteById(Long id) {
    websiteRepository.deleteById(id);
  }

  public Response create(WebsiteRequest websiteRequest) {
    final Website website = WebsiteMapper.fromWebsiteRequestToWebsite(websiteRequest);
    final Optional<Website> maybeParent = websiteRepository.findById(websiteRequest.getParentId());
    if (!maybeParent.isPresent()) {
      website.setParent(null);
    } else {
      website.setParent(maybeParent.get());
    }
    website.getRules().forEach(rule ->
        ruleRepository.save(rule)
    );
    final Website savedWebsite = websiteRepository.save(website);
    final WebsiteResponse websiteResponse = WebsiteMapper.fromWebsiteToWebsiteResponse(savedWebsite);
    return websiteResponse;
  }

  public Website update(Website newWebsite) throws NotFoundException {
    Optional<Website> maybeSite = websiteRepository.findById(newWebsite.getId());
    if (!maybeSite.isPresent()) throw new NotFoundException("Website not found.");
    final Website website = maybeSite.get();
    website.setUrl(newWebsite.getUrl());
    website.setRules(newWebsite.getRules());
    return websiteRepository.save(website);
  }

}