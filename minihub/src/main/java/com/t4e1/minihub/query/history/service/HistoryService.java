package com.t4e1.minihub.query.history.service;

import com.t4e1.minihub.query.history.dto.RecordDTO;
import java.util.List;

public interface HistoryService {
    List<RecordDTO> getRecordList();

    RecordDTO getRecord(int id);
}
