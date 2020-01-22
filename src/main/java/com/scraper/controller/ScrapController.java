package com.scraper.controller;

import com.scraper.domain.Feed;
import com.scraper.service.ScrapService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ScrapController {

  @Autowired
  private ScrapService scrapService;

  @GetMapping("/scrap")
  @ResponseBody
  public String scrap() throws IOException {
    System.out.println("Scrap and save.");
    return scrapService.scrapAndSave();
  }

  @GetMapping("/scrap/{id}")
  @ResponseBody
  public List<Feed> scrapOneAndSave(@PathVariable Long id) throws IOException, NotFoundException {
    System.out.println("Scrap and save.");
    return scrapService.scrapOneAndSave(id);
  }

}