package com.t4e1.minihub.command.memo.repository;

import com.t4e1.minihub.command.memo.aggregate.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoDAO extends JpaRepository<Memo, Integer> {
}
