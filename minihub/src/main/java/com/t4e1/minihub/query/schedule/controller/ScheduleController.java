package com.t4e1.minihub.query.schedule.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ScheduleQueryController")
@RequestMapping("/schedules")
public class ScheduleController {

    @GetMapping("/contents")
    public ResponseEntity<?> getSchedule() {



        return null;
    }
}
