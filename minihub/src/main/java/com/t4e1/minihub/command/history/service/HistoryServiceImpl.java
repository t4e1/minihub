package com.t4e1.minihub.command.history.service;

import com.t4e1.minihub.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minihub.command.history.aggregate.History;
import com.t4e1.minihub.command.history.repository.HistoryRepository;
import com.t4e1.minihub.common.converter.EntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("HistoryCommandService")
@Slf4j
public class HistoryServiceImpl implements HistoryService{

    private final EntityMapper entityMapper;
    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(EntityMapper entityMapper, HistoryRepository historyRepository) {
        this.entityMapper = entityMapper;
        this.historyRepository = historyRepository;
    }

    @Override
    @Transactional
    public boolean addRecord(HistoryDTO addData) {

        History input = entityMapper.INSTANCE.historyEntity(addData);

        try {
            historyRepository.save(input);
            return true;
        } catch(Exception e) {

            // 에러 발생 시 'INPUT DATA' 로 로그 검색
            log.error("ERROR - INPUT HISTORY DATA : {}", e.getMessage());
        }

        return false;
    }

    @Override
    @Transactional
    public boolean modifyRecord(HistoryDTO historyDTO) {

        try {
            History oldData = getOldDataByID(historyDTO.getId());
            oldData = entityMapper.historyEntity(historyDTO);
            historyRepository.save(oldData);

            return true;
        } catch(Exception e) {

            log.error("ERROR - MODIFY HISTORY DATA : {}", e.getMessage());
        }

        return false;
    }

    private History getOldDataByID(int id) {

        return historyRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public boolean deleteRecord(int id) {

        try {
            historyRepository.deleteById(id);

            return true;
        } catch(Exception e) {

            log.error("ERROR - DELETE HISTORY DATA : {}", e.getMessage());
        }

        return false;
    }
}


