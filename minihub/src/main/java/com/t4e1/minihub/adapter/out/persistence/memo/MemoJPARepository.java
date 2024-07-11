package com.t4e1.minihub.adapter.out.persistence.memo;

import com.t4e1.minihub.application.port.memo.out.MemoJPARepositoryPort;
import com.t4e1.minihub.command.memo.aggregate.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoJPARepository extends JpaRepository<Memo, Integer>, MemoJPARepositoryPort {


}
