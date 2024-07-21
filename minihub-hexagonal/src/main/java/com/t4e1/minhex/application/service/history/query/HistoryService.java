package com.t4e1.minhex.application.service.history.query;

import com.t4e1.minhex.application.port.in.history.query.HistoryQueryUseCase;
import com.t4e1.minhex.application.port.out.history.query.HistoryQueryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("HistoryQueryService")
public class HistoryService implements HistoryQueryUseCase {

    private final HistoryQueryPort historyQueryPort;

    @Autowired
    public HistoryService(HistoryQueryPort historyQueryPort) {
        this.historyQueryPort = historyQueryPort;
    }


}
