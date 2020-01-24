package com.scraper.service;

import com.scraper.model.domain.Website;
import com.scraper.model.response.Response;
import javassist.NotFoundException;

import java.util.List;

public interface IWebsiteService {

  List<Website> findAll();

  List<Website> findAllByIds(List<Long> ids);

  Response findById(Long id);

  void deleteById(Long id);

  Website create(Website website);

  Website update(Website newWebsite) throws NotFoundException;
}
