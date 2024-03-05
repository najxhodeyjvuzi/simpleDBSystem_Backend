package cn.simpleSystem.springboot_demo.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Student {
    private Long sid;
    private String name;
    private String gender;
    private String grade;
    private String telephone;
}
