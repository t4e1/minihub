package com.t4e1.minhex.adapter.out.history.command.entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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