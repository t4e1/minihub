package com.t4e1.minihub.common.converter;

import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.vo.ReqAddVO;
import org.mapstruct.Mapper;

@Mapper
public interface VOMapper {

    // History Controller Mapper
    HistoryDTO historyDTO(ReqAddVO addData);




}
