package cn.simpleSystem.springboot_demo.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Teachers {
    private Long tid;
    private String tname;
    private String gender;
    private String age;
    private Long salary;
    private String telephone;
}