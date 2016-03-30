package com.hpe.devops.gitmetrics.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by szulawsk on 2016-03-30.
 */

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to gitmetrics!");

        return "index";
    }
}
