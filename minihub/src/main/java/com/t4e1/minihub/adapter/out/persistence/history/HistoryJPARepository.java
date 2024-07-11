package com.t4e1.minihub.adapter.out.persistence.history;

import com.t4e1.minihub.application.port.history.out.HistoryJPARepositoryPort;
import com.t4e1.minihub.command.history.aggregate.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryJPARepository extends JpaRepository<History, Integer>, HistoryJPARepositoryPort {


}
