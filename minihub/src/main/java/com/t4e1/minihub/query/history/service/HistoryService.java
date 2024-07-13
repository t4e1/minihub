package com.t4e1.minihub.query.history.service;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.common.paging.ScrollPaging;
import java.util.List;

public interface HistoryService {
    List<HistoryDTO> getRecordList(String title, String content, List<String> tag, ScrollPaging paging);

    HistoryDTO getRecord(int id);
}
