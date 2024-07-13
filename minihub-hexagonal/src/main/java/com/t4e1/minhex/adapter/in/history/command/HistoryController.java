package com.t4e1.minhex.adapter.in.history.command;

import com.t4e1.minhex.adapter.in.history.dto.HistoryDTO;
import com.t4e1.minhex.adapter.in.history.vo.ReqVO;
import com.t4e1.minhex.adapter.in.history.vo.ResVO;
import com.t4e1.minhex.application.port.in.history.command.HistoryPort;
import com.t4e1.minhex.common.converter.VOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController("HistoryCommandController")
@RequestMapping("/history")
public class HistoryController {

    private final HistoryPort historyPort;
    private final VOMapper voMapper;

    @Autowired
    public HistoryController(HistoryPort historyPort,
                             VOMapper voMapper) {
        this.historyPort = historyPort;
        this.voMapper = voMapper;
    }

    @PostMapping
    public ResponseEntity<ResVO> addRecord(@RequestBody ReqVO addData){

        HistoryDTO inputData = voMapper.INSTANCE.historyDTO(addData);

        if(historyPort.addRecord(inputData)){
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

        if(historyPort.modifyRecord(modifyData)){

            return ResponseEntity.status(HttpStatus.OK).body(new ResVO("/records/" + id, modifyData));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResVO> deleteRecord(@PathVariable("id") int id) {

        if(historyPort.deleteRecord(id)){

            return ResponseEntity.status(HttpStatus.OK).body(new ResVO("/records/list", null));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}