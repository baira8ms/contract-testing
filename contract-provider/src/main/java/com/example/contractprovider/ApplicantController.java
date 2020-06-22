package com.example.contractprovider;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicantController {

  @PostMapping(value = "/applicant", consumes = "*/*", produces = "application/json")
  public ResponseEntity<String> createApplicant(@RequestBody JsonNode requestNode) {
    ResponseEntity<String> response;
    if (requestNode.has("applicantName")) {
      response = ResponseEntity.status(HttpStatus.CREATED).body("created");
    } else {
      response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed");
    }
    return response;
  }
}
