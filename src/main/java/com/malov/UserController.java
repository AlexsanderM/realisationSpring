package com.malov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {

    @GetMapping("/user")
    public String user(@RequestParam(name = "name", required = false, defaultValue = "New User") String name,
                       Map<String, Object> model) {
        model.put("name" , name);
        return "user";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("mainTest" , "Start page TEST");
        return "main";
    }
}
