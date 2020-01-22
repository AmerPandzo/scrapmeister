package com.scraper.service;

import com.scraper.domain.Website;
import com.scraper.repository.WebsiteRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class WebsiteService {

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

  public Optional<Website> findById(Long id) {
    return websiteRepository.findById(id);
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