package com.scraper.service;

import com.scraper.model.domain.Rule;
import javassist.NotFoundException;

import java.util.List;

public interface IRuleService {

  List<Rule> findAll();

  Rule create(Rule rule);

  Rule update(Rule newRule) throws NotFoundException;
}
