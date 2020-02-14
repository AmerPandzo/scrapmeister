package com.scraper.service;

import com.scraper.model.domain.Feed;
import com.scraper.model.request.FeedRequest;
import com.scraper.model.response.PlainFeedResponse;
import com.scraper.model.response.Response;
import com.scraper.model.response.ResponseList;

import java.util.List;
import java.util.Optional;

public interface IFeedService {
  Response save(FeedRequest feedRequest);

  List<Feed> findAll();

  ResponseList<PlainFeedResponse> findAllByWebsiteId(Long websiteId);

  Optional<Feed> findByIdAndWebsiteId(Long id, Long websiteId);

  void deleteByIdAndWebsiteId(Long id, Long websiteId);

  void deleteAllByWebsiteId(Long websiteId);

  void deleteAll();

  ResponseList<PlainFeedResponse> findAllByParentId(final Long parentId);
}
