package com.example;

import java.time.LocalDateTime;

public interface JobScheduler {
    JobScheduler forJob(Job job);
    JobScheduler startsAt(LocalDateTime startTime);
    JobScheduler repeatEverySeconds(int timeIntervalInSeconds);
    JobScheduler repeatTimes(int repeatTimes);
    void listenTo(TimeEvent event);
}
