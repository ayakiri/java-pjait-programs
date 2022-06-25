package com.example;

import java.time.LocalDateTime;

public interface Job {
    void run();
    LocalDateTime getJobTime();
    void setJobTime(LocalDateTime jobTime);
}
