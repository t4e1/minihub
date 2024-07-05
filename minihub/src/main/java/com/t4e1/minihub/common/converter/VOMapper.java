package com.t4e1.minihub.common.converter;

import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.vo.HistoryReqVO;
import com.t4e1.minihub.command.memo.dto.MemoDTO;
import com.t4e1.minihub.command.memo.vo.MemoReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VOMapper {

    VOMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(VOMapper.class);

    // History Controller Mapper
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "pwd", target = "pwd")
    HistoryDTO historyDTO(HistoryReqVO addData);

    MemoDTO memoDTO(MemoReqVO req);
}
