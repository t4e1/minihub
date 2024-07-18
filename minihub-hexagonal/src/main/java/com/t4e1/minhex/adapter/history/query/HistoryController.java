package com.t4e1.minhex.adapter.history.query;

import com.t4e1.minhex.application.port.in.history.query.HistoryQueryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("HistoryQueryController")
@RequestMapping("/history")
public class HistoryController {

    private final HistoryQueryUseCase historyQueryUseCase;

    @Autowired
    public HistoryController(HistoryQueryUseCase historyQueryUseCase) {
        this.historyQueryUseCase = historyQueryUseCase;
    }


}
