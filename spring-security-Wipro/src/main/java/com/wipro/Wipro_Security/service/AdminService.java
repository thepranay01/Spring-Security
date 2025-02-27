package com.wipro.Wipro_Security.service;

import com.wipro.Wipro_Security.model.Jobinfo;
import com.wipro.Wipro_Security.repository.JobinfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private JobinfoRepository jobinfoRepository;

    public Jobinfo addJob(Jobinfo job) {
        return jobinfoRepository.save(job);
    }

    public List<Jobinfo> listAllJobs() {
        return jobinfoRepository.findAll();
    }

    public void deleteJob(Integer jobId) {
        jobinfoRepository.deleteById(jobId);
    }

    public Jobinfo updateJob(Integer jobId, Jobinfo updatedJob) {
        Optional<Jobinfo> jobOpt = jobinfoRepository.findById(jobId);
        if (jobOpt.isPresent()) {
            Jobinfo job = jobOpt.get();
            job.setTitle(updatedJob.getTitle());
            job.setDescription(updatedJob.getDescription());
            return jobinfoRepository.save(job);
        }
        return null;
    }

    public Jobinfo getJobById(Integer jobId) {
        return jobinfoRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + jobId));
    }

}
