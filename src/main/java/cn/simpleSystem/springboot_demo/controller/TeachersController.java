package cn.simpleSystem.springboot_demo.controller;

import cn.simpleSystem.springboot_demo.entity.*;
import cn.simpleSystem.springboot_demo.services.TeacherService;
import cn.simpleSystem.springboot_demo.utils.Utils;
import cn.simpleSystem.springboot_demo.entity.Result;
import cn.simpleSystem.springboot_demo.entity.ResultResponse;
import cn.simpleSystem.springboot_demo.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeachersController {
    @Autowired
    TeacherService teacherService;

    @GetMapping({"/",""})
    public Result list(@CookieValue("user") String user, @RequestParam(value = "basic", defaultValue = "false") boolean basic) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(teacherService.list(basic));
    }

    @PostMapping({"", "/"})
    public Result add(@RequestBody Teachers teacher, @CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(teacherService.add(teacher) > 0);
    }

    @PutMapping({"", "/"})
    public Result update(@RequestBody Teachers teacher, @CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(teacherService.update(teacher) > 0);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Long id, @CookieValue("user") String user) {
        System.out.println(id);
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getResult(teacherService.delete(id) > 0);
    }

}
