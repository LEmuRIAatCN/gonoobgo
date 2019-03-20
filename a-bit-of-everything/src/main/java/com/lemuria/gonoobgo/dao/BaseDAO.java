package com.lemuria.gonoobgo.dao;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@Data
public class BaseDAO {
    @Autowired
    private MongoTemplate mongoTemplate;

}
