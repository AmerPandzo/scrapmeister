package com.scraper.service.impl;

import com.scraper.model.domain.Website;
import com.scraper.model.response.Response;
import com.scraper.repository.WebsiteRepository;
import com.scraper.service.IWebsiteService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class WebsiteService implements IWebsiteService {

  private WebsiteRepository websiteRepository;

  @Autowired
  public WebsiteService(WebsiteRepository websiteRepository) {
    this.websiteRepository = websiteRepository;
  }

  public List<Website> findAll() {
    return websiteRepository.findAll();
  }

  public List<Website> findAllByIds(List<Long> ids) {
    return websiteRepository.findAllById(ids);
  }

  public Response findById(Long id) {
//    final Optional<Website> optionalWebsite = websiteRepository.findById(id);
//    if(optionalWebsite.isPresent()) {
//      return new WebsiteResponse(HttpStatus.OK, "Website successfully fetched.");
//    } else {
//      return new WebsiteResponse(HttpStatus.NOT_FOUND, "Website not found.");
//    }
    return null;
  }

  public void deleteById(Long id) {
    websiteRepository.deleteById(id);
  }

  public Website create(Website website) {
    return websiteRepository.save(website);
  }

  public Website update(Website newWebsite) throws NotFoundException {
    Optional<Website> maybeSite = websiteRepository.findById(newWebsite.getId());
    if(!maybeSite.isPresent()) throw new NotFoundException("Website not found.");
    final Website website = maybeSite.get();
    website.setUrl(newWebsite.getUrl());
    website.setRules(newWebsite.getRules());
    return websiteRepository.save(website);
  }

}