package com.khpi.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/dashboard")
public class Dashboard {

    @GetMapping
    public String dashboardPage() {
        return "/dashboard";
    }

    @GetMapping("/info")
    public String infoPage() {
        return "/info";
    }
}
