package com.example;

import java.time.LocalDateTime;

public class SimpleJobScheduler implements JobScheduler {
    private Job job;
    private LocalDateTime startTime = LocalDateTime.now();
    private int timeIntervalInSeconds = 1;
    private int repeatTimes;
    private int counter;
    private boolean isFinished = false;

    @Override
    public JobScheduler forJob(Job job) {
        this.job = job;
        return this;
    }

    @Override
    public JobScheduler startsAt(LocalDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    @Override
    public JobScheduler repeatEverySeconds(int timeIntervalInSeconds) {
        this.timeIntervalInSeconds = timeIntervalInSeconds;
        return this;
    }

    @Override
    public JobScheduler repeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
        return this;
    }

    @Override
    public void listenTo(TimeEvent event) {
        if(startTime.isBefore(event.getTime()) && !isFinished){
            job.setJobTime(event.getTime());
            new JobThread(job).start();

            startTime = startTime.plusSeconds(timeIntervalInSeconds);
            if(repeatTimes > 0){
                counter++;
            }
        }

        isFinished = repeatTimes>0&&counter>=repeatTimes;
    }
}
