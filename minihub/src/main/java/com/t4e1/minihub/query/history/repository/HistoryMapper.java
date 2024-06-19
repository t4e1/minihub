package com.t4e1.minihub.query.history.repository;

import com.t4e1.minihub.query.history.dto.RecordDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface HistoryMapper {
    List<RecordDTO> selectList();

}
