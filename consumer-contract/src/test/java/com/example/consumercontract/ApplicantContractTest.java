package com.example.consumercontract;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureStubRunner(
    stubsMode = StubsMode.LOCAL,
    ids = "com.example:contract-provider:8990",
    consumerName = "registration",
    stubsPerConsumer = true
)
@AutoConfigureMockMvc
public class ApplicantContractTest {

  @Test
  public void testApplicantContract() {

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    HttpEntity entity = new HttpEntity<>("{\"name\":\"Bhanu\", \"purposeOfVisit\":\"business\"}",
        headers);
    ResponseEntity<String> stringResponseEntity = new RestTemplate()
        .postForEntity("http://localhost:8990/applicant", entity, String.class);
    assertThat(stringResponseEntity.getStatusCode().value()).isEqualTo(201);
  }


}
