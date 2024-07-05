package com.t4e1.minihub.command.memo.service;

import com.t4e1.minihub.command.memo.dto.MemoDTO;
import com.t4e1.minihub.command.memo.repository.MemoRepository;
import com.t4e1.minihub.common.converter.EntityMapper;
import com.t4e1.minihub.common.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MemoCommandService")
public class MenoServiceImpl implements MemoService{

    private final MemoRepository memoRepository;
    private final EntityMapper entityMapper;

    @Autowired
    public MenoServiceImpl(MemoRepository memoRepository, EntityMapper entityMapper) {
        this.memoRepository = memoRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    @Transactional
    public boolean addNewMemo(MemoDTO addData) {

        try {
            memoRepository.save(entityMapper.memoEntity(addData));
            return true;

        } catch (Exception e) {
            throw new InvalidInputException("Add memo fail" + e.getMessage());
        }
    }
}
