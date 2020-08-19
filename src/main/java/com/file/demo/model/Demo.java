package com.file.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author zxx
 * @Date DATE{TIME}
 * @Version 1.0
 */
@Getter
@Setter
@ToString
public class Demo {

    private String id;

    private String name;

    private Integer age;

    private Date createDate;

    public Demo(String id, String name, Integer age, Date createDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.createDate = createDate;
    }
}
