package com.t4e1.minihub.command.history.aggregate;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name="history")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class History {

    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @Type(ListArrayType.class)
    @Column(name = "tags", columnDefinition = "varchar[]")
    private List<String> tags;
    @Column
    private String pwd;
}
