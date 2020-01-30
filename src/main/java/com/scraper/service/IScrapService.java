package com.scraper.service;

import com.scraper.model.response.ResponseList;
import javassist.NotFoundException;

import java.io.IOException;

public interface IScrapService {

  ResponseList scrapOneAndSave(Long id) throws IOException, NotFoundException;

  String scrapAndSave() throws IOException;

}
