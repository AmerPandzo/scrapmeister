package com.scraper.service;

import com.scraper.model.domain.Feed;
import javassist.NotFoundException;

import java.io.IOException;
import java.util.List;

public interface IScrapService {

  List<Feed> scrapOneAndSave(Long id) throws IOException, NotFoundException;

  String scrapAndSave() throws IOException;

}
