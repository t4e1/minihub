package com.t4e1.minihub.query.history.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HistoryServiceImplTests {

    @Autowired
    private HistoryService historyService;

    @DisplayName("개인기록 전체 리스트 조회")
    @Test
    void getRecordList() {

        Assertions.assertDoesNotThrow(
                () -> historyService.getRecordList()
        );
    }
}