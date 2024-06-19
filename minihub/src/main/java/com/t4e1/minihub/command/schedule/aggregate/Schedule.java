package com.t4e1.minihub.command.schedule.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="schedule")
public class Schedule {

    @Id
    private int id;
    @Column
    private LocalDateTime startDate;
    @Column
    private LocalDateTime endDate;

}
