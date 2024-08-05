package com.t4e1.minhex.adapter.history.command;

import com.t4e1.minhex.adapter.history.HistoryDTO;
import com.t4e1.minhex.adapter.history.ReqVO;
import com.t4e1.minhex.adapter.ResVO;
import com.t4e1.minhex.application.port.in.history.command.HistoryCommandUseCase;
import com.t4e1.minhex.adapter.converter.VOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("HistoryCommandController")
@RequestMapping("/history")
public class HistoryController {

    private final HistoryCommandUseCase historyCommandUseCase;
    private final VOMapper voMapper;

    @Autowired
    public HistoryController(HistoryCommandUseCase historyCommandUseCase,
                             VOMapper voMapper) {
        this.historyCommandUseCase = historyCommandUseCase;
        this.voMapper = voMapper;
    }

    @PostMapping
    public ResponseEntity<ResVO> addRecord(@RequestBody ReqVO addData){

        HistoryDTO inputData = voMapper.INSTANCE.historyDTO(addData);

        if(historyCommandUseCase.addRecord(inputData)){
            ResVO response = new ResVO("/records/list", inputData);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

//    @PostMapping("/images")
//    public ResponseEntity<List<String>> addImages(List<MultipartFile> files) {
//
//        List<String> response = s3Service.s3Upload(files);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(response);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<ResVO> modifyRecord(@PathVariable("id") int id,
                                                     @RequestBody ReqVO data) {

        HistoryDTO modifyData = voMapper.INSTANCE.historyDTO(data);

        if(historyCommandUseCase.modifyRecord(modifyData)){

            return ResponseEntity.status(HttpStatus.OK).body(new ResVO("/records/" + id, modifyData));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResVO> deleteRecord(@PathVariable("id") int id) {

        if(historyCommandUseCase.deleteRecord(id)){

            return ResponseEntity.status(HttpStatus.OK).body(new ResVO("/records/list", null));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
