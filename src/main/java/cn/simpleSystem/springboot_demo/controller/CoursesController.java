package cn.simpleSystem.springboot_demo.controller;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.entity.Course;
import cn.simpleSystem.springboot_demo.entity.Result;
import cn.simpleSystem.springboot_demo.entity.ResultResponse;
import cn.simpleSystem.springboot_demo.services.CoursesService;
import cn.simpleSystem.springboot_demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesService coursesService;

    @GetMapping({"/",""})
    public Result list(@CookieValue("user") String user, @RequestParam(value = "basic", defaultValue = "false") boolean basic) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(coursesService.list(basic));
    }

    @PostMapping({"", "/"})
    public Result add(@RequestBody Course course, @CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(coursesService.add(course) > 0);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id, @CookieValue("user") String user) {
        System.out.println(id);
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(coursesService.delete(id) > 0);
    }

}
