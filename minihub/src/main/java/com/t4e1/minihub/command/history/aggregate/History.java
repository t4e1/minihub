package com.t4e1.minihub.command.history.aggregate;

import com.t4e1.minihub.config.StringListType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name="history")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class History {

    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @ElementCollection
    @Type(value = StringListType.class)
    @Column(name = "tags", columnDefinition = "varchar(255)[]")
    private List<String> tags;
    @Column
    private String pwd;
}
