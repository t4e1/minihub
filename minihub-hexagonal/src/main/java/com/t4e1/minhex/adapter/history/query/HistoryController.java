package com.t4e1.minhex.adapter.history.query;

import com.t4e1.minhex.adapter.ResVO;
import com.t4e1.minhex.adapter.history.ReqVO;
import com.t4e1.minhex.application.port.in.history.query.HistoryQueryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController("HistoryQueryController")
@RequestMapping("/history")
public class HistoryController {

    private final HistoryQueryUseCase historyQueryUseCase;

    @Autowired
    public HistoryController(HistoryQueryUseCase historyQueryUseCase) {
        this.historyQueryUseCase = historyQueryUseCase;
    }

    @GetMapping("{id}")
    public ResVO<List<String>> findHistoryById(@PathVariable("id") long id) {


        return null;
    }

}
