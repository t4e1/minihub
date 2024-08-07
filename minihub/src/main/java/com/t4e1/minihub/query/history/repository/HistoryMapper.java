package com.t4e1.minihub.query.history.repository;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.query.history.aggregate.SelectCondition;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HistoryMapper {

    List<HistoryDTO> selectList(SelectCondition selectCondition);

    HistoryDTO selectRecord(int id);

}
