package com.example;

import java.time.LocalDateTime;

public class DescribedJob implements Job {
    private String description;
    private LocalDateTime jobTime;

    public DescribedJob(String description) {
        this.description = description;
    }

    @Override
    public void run() {
        System.out.println("Job started at: " + jobTime + ", description: " + description);
    }

    @Override
    public LocalDateTime getJobTime() {
        return jobTime;
    }

    @Override
    public void setJobTime(LocalDateTime jobTime) {
        this.jobTime = jobTime;
    }
}
