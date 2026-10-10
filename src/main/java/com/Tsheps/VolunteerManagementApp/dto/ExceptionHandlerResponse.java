package com.Tsheps.VolunteerManagementApp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
@JsonPropertyOrder({"statusValue", "statusMessage", "message"})
public class ExceptionHandlerResponse {
    String statusMessage;
    int statusValue;
    String message;
}
