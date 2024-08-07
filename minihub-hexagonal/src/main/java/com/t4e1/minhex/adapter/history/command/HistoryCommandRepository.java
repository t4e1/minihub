package com.t4e1.minhex.adapter.history.command;

import com.t4e1.minhex.adapter.history.HistoryDTO;
import com.t4e1.minhex.application.port.out.history.command.HistoryCommandPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryCommandRepository implements HistoryCommandPort {

    private final HistoryJpaRepo historyJpaRepo;

    @Autowired
    public HistoryCommandRepository(HistoryJpaRepo historyJpaRepo) {
        this.historyJpaRepo = historyJpaRepo;
    }


    @Override
    public void addRecord(HistoryDTO inputData) {

        HistoryEntity data = inputData.

    }

}
