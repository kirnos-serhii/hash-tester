package com.khpi.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class Dashboard {

    @GetMapping("/dashboard")
    public String dashboardPage() {
        return "/dashboard";
    }

    @GetMapping("/info")
    public String infoPage() {
        return "/info";
    }
}
