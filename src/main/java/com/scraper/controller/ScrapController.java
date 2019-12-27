package com.scraper.controller;

import com.scraper.service.WebScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ScrapController {

  @Autowired
  private WebScraperService webScraperService;

  @CrossOrigin(origins = {"http://localhost:4200", "https://scrapmeister-frontend.herokuapp.com"})
  @GetMapping("/scrap")
  @ResponseBody
  public String scrap() throws IOException {
    System.out.println("Amer test");
    return webScraperService.scrapAndSave();
  }

}