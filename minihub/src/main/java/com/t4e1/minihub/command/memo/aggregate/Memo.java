package com.t4e1.minihub.command.memo.aggregate;

import jakarta.persistence.*;

@Entity
@Table(name="memo")
public class Memo {

    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private int scheduleId;
}
