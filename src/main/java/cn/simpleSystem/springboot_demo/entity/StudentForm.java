package cn.simpleSystem.springboot_demo.entity;

import lombok.Data;

@Data
public class StudentForm {
    private Long sid;
    private String name;
    private String gender;
    private String grade;
    private String telephone;
}
