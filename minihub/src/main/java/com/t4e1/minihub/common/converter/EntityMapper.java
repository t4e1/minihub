package com.t4e1.minihub.common.converter;

import com.t4e1.minihub.command.history.aggregate.History;
import com.t4e1.minihub.command.history.dto.HistoryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    //History Service Mapper
    History historyEntity();
    HistoryDTO historyDTO();


    //Event Service Mapper



    //Memo Service Mapper


    //Schedule Service Mapper



}
