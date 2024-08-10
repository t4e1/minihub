package com.t4e1.minhex.adapter.converter;

import com.t4e1.minhex.adapter.history.HistoryDTO;
import com.t4e1.minhex.adapter.history.command.HistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    EntityMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EntityMapper.class);

//    History Service Mapper
    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "pwd", target = "pwd")
    HistoryEntity historyEntity(HistoryDTO historyDTO);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "tags", target = "tags")
    @Mapping(source = "pwd", target = "pwd")
    HistoryDTO historyDTO(HistoryEntity history);

//    Memo memoEntity(MemoDTO addData);


    //Event Service Mapper



    //Memo Service Mapper


    //Schedule Service Mapper

}
