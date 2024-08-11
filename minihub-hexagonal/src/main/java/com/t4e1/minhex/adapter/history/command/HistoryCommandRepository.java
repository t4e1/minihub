package com.t4e1.minhex.adapter.history.command;

import com.t4e1.minhex.adapter.converter.EntityMapper;
import com.t4e1.minhex.adapter.history.HistoryDTO;
import com.t4e1.minhex.application.port.out.history.command.HistoryCommandPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class HistoryCommandRepository implements HistoryCommandPort {

    private final HistoryJpaRepo historyJpaRepo;
    private final EntityMapper entityMapper;
    @Autowired
    public HistoryCommandRepository(HistoryJpaRepo historyJpaRepo,
                                    EntityMapper entityMapper) {

        this.historyJpaRepo = historyJpaRepo;
        this.entityMapper = entityMapper;

    }

    @Override
    public boolean addRecord(HistoryDTO inputData) {

        HistoryEntity data = entityMapper.historyEntity(inputData);

        try {
            historyJpaRepo.save(data);
            return true;
        } catch(Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }

}
