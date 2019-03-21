package com.lemuria.gonoobgo.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class KnowledgeBasePO {
    @Id
    private String id;
    @TextIndexed(weight = 2F)
    @Indexed
    private String title;
    @TextIndexed(weight = 1.5F)
    @Indexed
    private String author;
    private String outline;
    private String[] tags;
    @TextIndexed(weight = 1F)
    private String content;
    @Indexed
    private int views;
}
