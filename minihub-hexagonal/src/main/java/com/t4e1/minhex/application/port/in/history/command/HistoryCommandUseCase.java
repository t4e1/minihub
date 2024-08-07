package com.t4e1.minhex.application.port.in.history.command;

import com.t4e1.minhex.adapter.history.HistoryDTO;

public interface HistoryCommandUseCase {

    boolean addRecord(HistoryDTO inputData);

    boolean modifyRecord(HistoryDTO modifyData);

    boolean deleteRecord(int id);
}
