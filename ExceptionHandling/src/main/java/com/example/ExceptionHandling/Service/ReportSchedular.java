package com.example.ExceptionHandling.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportSchedular {
    @Scheduled(initialDelay = 1000)
    public void report() {
        System.out.println("Database started");
    }
    @Scheduled(fixedDelay = 5000)
    public void scheduledReport() {
        System.out.println("Database still running");
    }
}
