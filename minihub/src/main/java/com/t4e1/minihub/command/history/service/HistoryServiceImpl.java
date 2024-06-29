package com.t4e1.minihub.command.history.service;

import com.t4e1.minihub.command.history.aggregate.History;
import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.repository.HistoryDAO;
import com.t4e1.minihub.common.converter.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("HistoryCommandService")
public class HistoryServiceImpl implements HistoryService{

    private final EntityMapper entityMapper;
    private final HistoryDAO historyDAO;

    @Autowired
    public HistoryServiceImpl(EntityMapper entityMapper, HistoryDAO historyDAO) {
        this.entityMapper = entityMapper;
        this.historyDAO = historyDAO;
    }

    @Override
    public HistoryDTO addRecord(HistoryDTO addData) {

        History input = entityMapper.INSTANCE.historyEntity(addData);
        System.out.println("addData = " + addData);
        System.out.println("input = " + input);
        Optional<History> result = historyDAO.findById(1);
        System.out.println("result = " + result);

        historyDAO.save(input);
        System.out.println(" 입력 성공 ");

        return null;
    }
}
