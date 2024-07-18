package com.t4e1.minhex.application.port.out.history.command;

import com.t4e1.minhex.adapter.history.HistoryDTO;

public interface HistoryCommandPort {
    void addRecord(HistoryDTO inputData);
}
