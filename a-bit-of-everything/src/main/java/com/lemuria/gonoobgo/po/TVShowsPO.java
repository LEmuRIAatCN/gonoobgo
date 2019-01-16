package com.lemuria.gonoobgo.po;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class TVShowsPO {
    @Id
    private String id;

    private String name;

    private String type;

    private int length;

    private List<Performer> list;
}
