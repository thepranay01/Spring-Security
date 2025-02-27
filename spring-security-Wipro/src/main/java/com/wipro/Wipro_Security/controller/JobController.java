package com.wipro.Wipro_Security.controller;

import com.wipro.Wipro_Security.model.Jobinfo;
import com.wipro.Wipro_Security.service.AdminService;
import com.wipro.Wipro_Security.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    AdminService adminService;


    @GetMapping("/job/list")
    public List<Jobinfo> listJobs() {
        return adminService.listAllJobs();
    }

    @PostMapping("/apply/{jobId}/{userId}")
    public String applyForJob(@PathVariable Integer jobId, @PathVariable Integer userId) {
        return jobService.applyJob(jobId, userId);
    }

    @DeleteMapping("/withdraw/{jobId}/{userId}")
    public String withdrawApplication(@PathVariable Integer jobId, @PathVariable Integer userId) {
        return jobService.withdrawJob(jobId, userId);
    }
}
