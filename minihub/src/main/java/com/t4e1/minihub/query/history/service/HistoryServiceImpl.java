package com.t4e1.minihub.query.history.service;

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

    @Override
    public List<RecordDTO> getRecordList() {

        List<RecordDTO> result = historyMapper.selectList();

        System.out.println("result = " + result);
        System.out.println("result.get(1).getTags().get(2) = " + result.get(0).getTags().get(2));
        return result;
//        return historyMapper.selectList();
    }
}
