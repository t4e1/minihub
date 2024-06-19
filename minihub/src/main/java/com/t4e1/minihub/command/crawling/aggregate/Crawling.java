package com.t4e1.minihub.command.crawling.aggregate;

import com.t4e1.minihub.common.aggregate.YN;
import jakarta.persistence.*;

@Entity
@Table(name="crawling")
public class Crawling {

    @Id
    private int id;
    @Column
    private String url;
    @Column
    @Enumerated(EnumType.STRING)
    private YN isActive;
}
