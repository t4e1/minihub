package com.t4e1.minihub.query.history.service;

import com.t4e1.minihub.common.exception.InfoNotFoundException;
import com.t4e1.minihub.common.paging.ScrollPaging;
import com.t4e1.minihub.query.history.aggregate.SelectCondition;
import com.t4e1.minihub.query.history.dto.RecordDTO;
import com.t4e1.minihub.query.history.repository.HistoryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HistoryQueryService")
@Slf4j
public class HistoryServiceImpl implements HistoryService{


    private final HistoryMapper historyMapper;

    @Autowired
    public HistoryServiceImpl(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }

    //전체 기록 조회( 검색 조건, 페이징 처리 )
    @Override
    public List<RecordDTO> getRecordList(String title, String content, String tag, ScrollPaging paging) {

        SelectCondition selectCondition = new SelectCondition(title, content, tag, paging.getOffset(), paging.getGetNum());
        log.info("검색 조건 검증 로그 : {}", selectCondition);

        List<RecordDTO> result = historyMapper.selectList(selectCondition);
        if(result == null || result.isEmpty())
            throw new InfoNotFoundException("Can't find any records.");

        return result;
    }

    //특정 기록 조회
    @Override
    public RecordDTO getRecord(int id) {

        RecordDTO result = historyMapper.selectRecord(id);
        if(result == null)
            throw new InfoNotFoundException("Can't find "+ id +"record");

        return result;
    }
}
