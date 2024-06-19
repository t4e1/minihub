package com.t4e1.minihub.command.schedule.repository;

import com.t4e1.minihub.command.schedule.aggregate.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDAO extends JpaRepository<Schedule, Integer> {
}
