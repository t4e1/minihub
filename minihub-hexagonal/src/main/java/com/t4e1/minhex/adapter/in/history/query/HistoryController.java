package com.t4e1.minhex.adapter.in.history.query;

import com.t4e1.minhex.application.port.in.history.query.HistoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("HistoryQueryController")
@RequestMapping("/history")
public class HistoryController {

    private final HistoryPort historyPort;

    @Autowired
    public HistoryController(HistoryPort historyPort) {
        this.historyPort = historyPort;
    }
}
