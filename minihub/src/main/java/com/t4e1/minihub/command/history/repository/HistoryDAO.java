package com.t4e1.minihub.command.history.repository;

import com.t4e1.minihub.command.history.aggregate.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryDAO extends JpaRepository<History, Integer> {
}
