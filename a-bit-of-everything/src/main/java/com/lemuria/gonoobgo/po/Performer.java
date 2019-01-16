package com.lemuria.gonoobgo.po;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Performer {
    @Id
    private String id;

    private String name;

    private int sex;

    private int age;
}
