package cn.simpleSystem.springboot_demo.entity;

import lombok.Data;

@Data
public class CourseSelection {
    private int cid;
    private String cname;
    private int tid;
    private String tname;
    private float usual_grade;
    private float final_grade;
}
