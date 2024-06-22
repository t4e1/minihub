package com.t4e1.minihub.query.history.service;

import com.t4e1.minihub.common.paging.ScrollPaging;
import com.t4e1.minihub.query.history.dto.RecordDTO;
import java.util.List;

public interface HistoryService {
    List<RecordDTO> getRecordList(String title, String content, List<String> tag, ScrollPaging paging);

    RecordDTO getRecord(int id);
}
