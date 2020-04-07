package lu.intech.poc_typeform.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;
import lu.intech.poc_typeform.services.TFResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;


@Log
@RestController
@RequestMapping("/responses")
public class TFResponseController {

    @Autowired
    private TFResponseService TFResponseService;

    @ApiOperation(value = "Retrieve the full heroes list")
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllResponses(@RequestParam(name = "since", required = false) String date) throws IOException {
        if (date == null) {
            log.info("GET /responses");
        } else {
            log.info("GET /responses since " + date);
        }
        Map<String, Object> responses = TFResponseService.retrieveAllResponses(date);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

}
