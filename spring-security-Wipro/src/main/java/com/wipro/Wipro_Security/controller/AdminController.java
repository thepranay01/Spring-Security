package com.wipro.Wipro_Security.controller;

import com.wipro.Wipro_Security.model.Jobinfo;
import com.wipro.Wipro_Security.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/job")
@CrossOrigin()
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public Jobinfo addJob(@RequestBody Jobinfo job) {
        return adminService.addJob(job);
    }

    @GetMapping("/list")
    public List<Jobinfo> listJobs() {
        return adminService.listAllJobs();
    }

    @GetMapping("/{jobId}")
    public Jobinfo getJobById(@PathVariable("jobId") Integer jobId){
        return adminService.getJobById(jobId);
    }
    
    @DeleteMapping("/{jobId}")
    public String deleteJob(@PathVariable("jobId") Integer jobId){
        adminService.deleteJob(jobId);
        return "Job Deleted successfully";
    }

    @PutMapping("/{jobId}")
    public Jobinfo updateJob(@PathVariable("jobId") Integer jobId, @RequestBody Jobinfo updatedJob) {
        return adminService.updateJob(jobId, updatedJob);
    }
}
