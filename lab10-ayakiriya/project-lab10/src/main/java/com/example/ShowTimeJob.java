package com.example;

import java.time.LocalDateTime;

public class ShowTimeJob implements Job{
    private LocalDateTime jobTime;

    public ShowTimeJob(LocalDateTime jobTime){
        this.jobTime = jobTime;
    }

    @Override
    public void run() {
        System.out.println("Job started at: " + jobTime);
    }

    public LocalDateTime getJobTime() {
        return jobTime;
    }

    public void setJobTime(LocalDateTime jobTime) {
        this.jobTime = jobTime;
    }
}
