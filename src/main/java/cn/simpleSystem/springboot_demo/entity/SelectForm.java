package cn.simpleSystem.springboot_demo.entity;
import lombok.Data;
@Data
public class SelectForm {
    private Long sid;
    private Long cid;
    private int tid;
    private Float usual_grade;
    private Float final_grade;
}
