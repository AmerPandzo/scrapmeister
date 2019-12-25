package com.scraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrapmeisterApplication {

  public static void main(String[] args) {
    SpringApplication.run(ScrapmeisterApplication.class, args);
    System.out.println("running");
  }
}

