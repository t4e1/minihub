package com.t4e1.minhex.common.converter;

import com.t4e1.minhex.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minhex.adapter.in.history.vo.ReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface VOMapper {

    VOMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(VOMapper.class);

    // History Controller Mapper
    @Mapping(target = "id", ignore = true)
    HistoryDTO historyDTO(ReqVO addData);

//    @Mapping(target = "id", ignore = true)
//    MemoDTO memoDTO(MemoReqVO req);
}
