package com.t4e1.minihub.common.converter;

import com.t4e1.minihub.command.history.aggregate.History;
import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.config.MapStructConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapStructConfig.class)
public interface EntityMapper {

    EntityMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EntityMapper.class);

    //History Service Mapper
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "pwd", target = "pwd")
    History historyEntity(HistoryDTO historyDTO);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "pwd", target = "pwd")
    HistoryDTO historyDTO(History history);


    //Event Service Mapper



    //Memo Service Mapper


    //Schedule Service Mapper



}
