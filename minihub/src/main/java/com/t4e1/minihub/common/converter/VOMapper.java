package com.t4e1.minihub.common.converter;

import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.vo.ReqAddVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VOMapper {

    VOMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(VOMapper.class);

    // History Controller Mapper
    @Mapping(source = "title", target = "")
    HistoryDTO historyDTO(ReqAddVO addData);


}
