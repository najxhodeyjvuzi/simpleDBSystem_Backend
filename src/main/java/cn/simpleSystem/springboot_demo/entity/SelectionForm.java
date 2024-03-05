package cn.simpleSystem.springboot_demo.entity;

import lombok.Data;

@Data
public class SelectionForm {
    private Long sid;
    private int cid;
    private int tid;
    private int usual_grade;
    private int final_grade;
}
