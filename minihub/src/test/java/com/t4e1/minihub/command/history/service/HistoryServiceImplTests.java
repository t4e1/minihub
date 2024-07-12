package com.t4e1.minihub.command.history.service;

import com.t4e1.minihub.adapter.in.vo.history.HistoryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

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

        HistoryDTO historyDTO = new HistoryDTO(0,"테스트", "테스트내용",
                new ArrayList<>(Arrays.asList("tag1", "tag2", "tag3")), "1234");

        Assertions.assertDoesNotThrow(
                () -> {
                    historyService.addRecord(historyDTO);
                }
        );
    }

    @DisplayName("기록 변경 테스트")
    @Test
    @Transactional
    void modifyRecordTest() {

        HistoryDTO modifyDTO = new HistoryDTO(1,"테스트", "테스트내용",
                new ArrayList<>(Arrays.asList("tag1", "tag2", "tag3")), "1234");

        Assertions.assertDoesNotThrow(
                () -> {
                    historyService.modifyRecord(modifyDTO);
                }
        );
    }

    @DisplayName("기록 삭제 테스트")
    @Test
    @Transactional
    void deleteRecordTest() {

        Assertions.assertDoesNotThrow(
                () -> {
                    historyService.deleteRecord(1);
                }
        );
    }
}