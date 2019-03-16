package com.lemuria.gonoobgo.dao;

import com.lemuria.gonoobgo.po.KnowledgeBasePO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KnowledgeBaseDAO extends MongoRepository<KnowledgeBasePO, String> {

}
