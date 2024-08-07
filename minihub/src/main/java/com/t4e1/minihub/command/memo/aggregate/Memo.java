package com.t4e1.minihub.command.memo.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
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
