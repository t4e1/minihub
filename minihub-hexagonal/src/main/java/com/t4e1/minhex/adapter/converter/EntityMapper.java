package com.t4e1.minhex.adapter.converter;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    EntityMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(EntityMapper.class);

    //History Service Mapper
//    @Mapping(source = "title", target = "title")
//    @Mapping(source = "content", target = "content")
//    @Mapping(source = "tags", target = "tags")
//    @Mapping(source = "pwd", target = "pwd")
//    History historyEntity(HistoryDTO historyDTO);
//
//    @Mapping(source = "title", target = "title")
//    @Mapping(source = "content", target = "content")
//    @Mapping(source = "tags", target = "tags")
//    @Mapping(source = "pwd", target = "pwd")
//    HistoryDTO historyDTO(History history);
//
//    Memo memoEntity(MemoDTO addData);


    //Event Service Mapper



    //Memo Service Mapper


    //Schedule Service Mapper

}
