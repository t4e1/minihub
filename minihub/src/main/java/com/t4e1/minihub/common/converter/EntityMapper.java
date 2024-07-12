package com.t4e1.minihub.common.converter;

import com.t4e1.minihub.adapter.in.vo.history.HistoryDTO;
import com.t4e1.minihub.command.history.aggregate.History;
import com.t4e1.minihub.command.memo.aggregate.Memo;
import com.t4e1.minihub.command.memo.dto.MemoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
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

    Memo memoEntity(MemoDTO addData);


    //Event Service Mapper



    //Memo Service Mapper


    //Schedule Service Mapper



}
