package com.t4e1.minihub.command.event.aggregate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="event")
public class Event {

    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String content;
    @Column
    private String path;

}
