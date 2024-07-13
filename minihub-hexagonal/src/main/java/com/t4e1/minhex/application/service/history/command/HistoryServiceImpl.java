package com.t4e1.minhex.application.service.history.command;

import com.t4e1.minhex.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minhex.application.port.in.history.command.HistoryPort;
import org.springframework.stereotype.Service;

@Service("HistoryCommandService")
public class HistoryServiceImpl implements HistoryPort {

    @Override
    public boolean addRecord(HistoryDTO inputData) {
        return false;
    }

    @Override
    public boolean modifyRecord(HistoryDTO modifyData) {
        return false;
    }

    @Override
    public boolean deleteRecord(int id) {
        return false;
    }
}
