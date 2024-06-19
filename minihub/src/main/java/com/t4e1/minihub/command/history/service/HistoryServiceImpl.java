package com.t4e1.minihub.command.history.service;

import com.t4e1.minihub.command.history.repository.HistoryDAO;
import com.t4e1.minihub.common.converter.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("HistoryCommandService")
public class HistoryServiceImpl implements HistoryService{

    private final EntityMapper EntityMapper;
    private final HistoryDAO historyDAO;

    @Autowired
    public HistoryServiceImpl(EntityMapper EntityMapper, HistoryDAO historyDAO) {
        this.EntityMapper = EntityMapper;
        this.historyDAO = historyDAO;
    }
}
