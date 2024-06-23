package com.t4e1.minihub.command.history.service;

import com.t4e1.minihub.command.history.dto.HistoryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HistoryServiceImplTests {

    private final HistoryService historyService;

    @Autowired
    public HistoryServiceImplTests(HistoryService historyService) {
        this.historyService = historyService;
    }

    @DisplayName("기록 추가 테스트")
    @Test
    @Transactional
    void addRecordTest() {

        HistoryDTO historyDTO = new HistoryDTO("테스트", "테스트내용",
                new ArrayList<String>(Arrays.asList("tag1", "tag2", "tag3")), "1234");

        Assertions.assertDoesNotThrow(
                () -> {
                    historyService.addRecord(historyDTO);
                }
        );
    }
}