package com.lemuria.gonoobgo.dao;

import com.lemuria.gonoobgo.po.TVShowsPO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TVShowsDAO extends MongoRepository<TVShowsPO, String> {
}
