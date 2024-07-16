package com.t4e1.minhex.application.service.history.command;

import com.t4e1.minhex.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minhex.application.port.in.history.command.HistoryCommandUseCase;
import com.t4e1.minhex.application.port.out.history.command.HistoryCommandPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("HistoryCommandService")
public class HistoryService implements HistoryCommandUseCase {

    private final HistoryCommandPort historyCommandPort;

    @Autowired
    public HistoryService(HistoryCommandPort historyCommandPort) {
        this.historyCommandPort = historyCommandPort;
    }

    @Override
    public boolean addRecord(HistoryDTO inputData) {

        historyCommandPort.addRecord(inputData);
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
