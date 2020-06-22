package com.example;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.example.contractprovider.ApplicantController;
import com.example.contractprovider.ContractProviderApplication;
import io.restassured.config.EncoderConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicantController.class)
@ContextConfiguration(classes = ContractProviderApplication.class)
public class RegistrationBase {


  @Autowired
  private WebApplicationContext webApplicationContext;

  @Before
  public void setup() {
    RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    RestAssuredMockMvc.config = new RestAssuredMockMvcConfig().encoderConfig(new EncoderConfig(UTF_8.name(), UTF_8.name()));
  }

}
