package com.t4e1.minihub.command.history.service;

import com.t4e1.minihub.command.history.dto.HistoryDTO;

public interface HistoryService {
    boolean addRecord(HistoryDTO addData);

    boolean modifyRecord(HistoryDTO historyDTO);

    boolean deleteRecord(int id);
}
