package com.scraper.controller;

import com.scraper.service.WebScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ScrapController {

  @Autowired
  private WebScraperService webScraperService;

  @GetMapping("/scrap")
  @ResponseBody
  public void scrap() throws IOException {
    System.out.println("Amer test");
    webScraperService.scrapAndSave();
  }

}