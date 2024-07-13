package com.t4e1.minihub.application.port.history.out;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.query.history.aggregate.SelectCondition;

import java.util.List;

public interface HistoryMybatisRepositoryPort {

    List<HistoryDTO> selectList(SelectCondition selectCondition);

    HistoryDTO selectRecord(int id);
}
