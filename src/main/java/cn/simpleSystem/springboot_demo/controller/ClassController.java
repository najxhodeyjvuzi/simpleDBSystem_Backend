package cn.simpleSystem.springboot_demo.controller;

import cn.simpleSystem.springboot_demo.entity.Result;
import cn.simpleSystem.springboot_demo.entity.ResultResponse;
import cn.simpleSystem.springboot_demo.services.ClassService;
import cn.simpleSystem.springboot_demo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping({"", "/"})
    public Result list(@CookieValue("user") String user) {
        if (!Utils.verifyUser(user)) {
            return ResultResponse.getFailResult();
        }
        return ResultResponse.getSuccessResult(classService.list());
    }
}
