package com.t4e1.minihub.query.history.service;

import com.t4e1.minihub.common.exception.InfoNotFoundException;
import com.t4e1.minihub.query.history.dto.RecordDTO;
import com.t4e1.minihub.query.history.repository.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HistoryQueryService")
public class HistoryServiceImpl implements HistoryService{


    private final HistoryMapper historyMapper;

    @Autowired
    public HistoryServiceImpl(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }

    //전체 기록 조회(페이징 필요)
    //조회 시 검색 조건 추가 (제목 or 태그)
    @Override
    public List<RecordDTO> getRecordList() {

        List<RecordDTO> result = historyMapper.selectList();
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
