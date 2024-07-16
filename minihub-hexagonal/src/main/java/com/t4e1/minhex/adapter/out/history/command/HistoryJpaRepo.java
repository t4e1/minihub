package com.t4e1.minhex.adapter.out.history.command;

import com.t4e1.minhex.adapter.out.history.command.orm_entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryJpaRepo extends JpaRepository<History, Integer> {

}
