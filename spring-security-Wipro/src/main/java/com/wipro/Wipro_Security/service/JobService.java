package com.wipro.Wipro_Security.service;

import com.wipro.Wipro_Security.model.Jobinfo;
import com.wipro.Wipro_Security.repository.JobinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobinfoRepository jobinfoRepository;

    // Apply for a job
    public String applyJob(Integer jobId, Integer userId) {
        Optional<Jobinfo> jobOptional = jobinfoRepository.findById(jobId);
        if (jobOptional.isPresent()) {
            Jobinfo job = jobOptional.get();
            job.getAppliedUsers().add(userId);
            jobinfoRepository.save(job);
            return "User " + userId + " applied for Job " + jobId;
        }
        return "Job not found!";
    }

    // Withdraw job application
    public String withdrawJob(Integer jobId, Integer userId) {
        Optional<Jobinfo> jobOptional = jobinfoRepository.findById(jobId);
        if (jobOptional.isPresent()) {
            Jobinfo job = jobOptional.get();
            if (job.getAppliedUsers().contains(userId)) {
                job.getAppliedUsers().remove(userId);
                jobinfoRepository.save(job);
                return "User " + userId + " withdrew application from Job " + jobId;
            }
            return "User has not applied for this job!";
        }
        return "Job not found!";
    }
}
