package com.t4e1.minihub.adapter.out.persistence.history;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.application.port.history.out.HistoryMybatisRepositoryPort;
import com.t4e1.minihub.query.history.aggregate.SelectCondition;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMybatisMapper extends HistoryMybatisRepositoryPort {

    private final

    @Override
    List<HistoryDTO> selectList(SelectCondition selectCondition);

    @Override
    HistoryDTO selectRecord(int id);
}
