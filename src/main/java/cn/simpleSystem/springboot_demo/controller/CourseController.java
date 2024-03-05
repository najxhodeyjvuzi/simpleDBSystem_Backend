package cn.simpleSystem.springboot_demo.controller;


import cn.simpleSystem.springboot_demo.entity.Result;
import cn.simpleSystem.springboot_demo.entity.ResultResponse;
import cn.simpleSystem.springboot_demo.entity.SelectForm;
import cn.simpleSystem.springboot_demo.services.CourseService;
import cn.simpleSystem.springboot_demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("/selection")
    public Result selection(@CookieValue("user") String user){
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult();
    }

    @PutMapping("/update")
    public Result update(@RequestBody SelectForm selectForm, @CookieValue("user") String user)
    {
        if (!Utils.verifyUser(user)){
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(courseService.update(selectForm)>0);
    }

    @GetMapping({"","/"})
    public Result list(@CookieValue("user") String user){
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(courseService.list());
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
