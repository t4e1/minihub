package com.t4e1.minihub.common.converter;

import com.t4e1.minihub.command.history.aggregate.History;
import com.t4e1.minihub.command.history.dto.HistoryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper {

    EntityMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EntityMapper.class);

    //History Service Mapper
    History historyEntity();
    HistoryDTO historyDTO();


    //Event Service Mapper



    //Memo Service Mapper


    //Schedule Service Mapper



}
