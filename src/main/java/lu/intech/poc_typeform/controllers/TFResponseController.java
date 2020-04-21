package lu.intech.poc_typeform.controllers;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lu.intech.poc_typeform.api.TFResponseDto;
import lu.intech.poc_typeform.services.TFResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Instant;


@Slf4j
@RestController
@RequestMapping("/responses")
public class TFResponseController {

    @Autowired
    private TFResponseService TFResponseService;

    @ApiOperation(value = "Retrieve the full heroes list")
    @GetMapping
    public ResponseEntity<TFResponseDto> getAllResponses(@RequestParam(name = "since", required = false) Instant date) throws IOException, URISyntaxException {
        log.info("GET /responses since {}", date);
        TFResponseDto responses = TFResponseService.retrieveAllResponses(date);
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

}
