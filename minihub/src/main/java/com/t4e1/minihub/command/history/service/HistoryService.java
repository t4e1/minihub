package com.t4e1.minihub.command.history.service;

import com.t4e1.minihub.command.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.vo.ReqAddVO;

public interface HistoryService {
    HistoryDTO addRecord(HistoryDTO addData);
}
