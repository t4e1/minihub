package com.t4e1.minihub.command.history.aggregate;

import com.t4e1.minihub.config.StringArrayType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name="history")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class History {

    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @ElementCollection
    @Type(value = StringArrayType.class)
    @Column(name = "tags", columnDefinition = "varchar(255)[]")
    private List<String> tags;
    @Column
    private String pwd;
}
