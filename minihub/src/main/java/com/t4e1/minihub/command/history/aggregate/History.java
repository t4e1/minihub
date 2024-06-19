package com.t4e1.minihub.command.history.aggregate;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="history")
public class History {

    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @ElementCollection
    @Column(name = "tags", columnDefinition = "varchar(255)[]")
    private List<String> tags;
    @Column
    private String pwd;
}
