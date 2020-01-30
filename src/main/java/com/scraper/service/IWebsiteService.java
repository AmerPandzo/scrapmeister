package com.scraper.service;

import com.scraper.model.domain.Website;
import com.scraper.model.request.WebsiteRequest;
import com.scraper.model.response.Response;
import com.scraper.model.response.ResponseList;
import javassist.NotFoundException;

import java.util.List;

public interface IWebsiteService {

  ResponseList findAll();

  ResponseList findAllByIds(List<Long> ids);

  Response findById(Long id);

  void deleteById(Long id);

  Response create(WebsiteRequest websiteRequest);

  Website update(Website newWebsite) throws NotFoundException;
}
