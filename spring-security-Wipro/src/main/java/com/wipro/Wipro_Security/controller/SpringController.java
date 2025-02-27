package com.wipro.Wipro_Security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

    @GetMapping("/home")
    public String hello(){
        return "home";
    }
    @GetMapping("/user/home")
    public String user(){
        return "home_user";
    }
    @GetMapping("/admin/home")
    public String admin(){

        return "home_admin";
    }
    @GetMapping("/login")
    public String handleLogin() {

        return "custom_login";
    }
    @GetMapping("/admin/add-job")
    public String handleAddJob() {

        return "add_job";
    }
    @GetMapping("/admin/list-job")
    public String handleListJob() {

        return "list_job";
    }

    @GetMapping("/admin/update-job/{id}")
    public String handleUpdateJob() {

        return "update_job";
    }

    @GetMapping("/user/job-opening")
    public String handleJobOpening() {

        return "job_opening";
    }
}
