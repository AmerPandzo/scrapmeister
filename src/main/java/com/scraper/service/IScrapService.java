package com.scraper.service;

import com.scraper.model.domain.Website;
import com.scraper.model.response.ResponseList;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface IScrapService {

  ResponseList scrapOneAndSave(Long id) throws IOException, NotFoundException;

  String scrapAndSave(List<Website> websites) throws IOException;

}
