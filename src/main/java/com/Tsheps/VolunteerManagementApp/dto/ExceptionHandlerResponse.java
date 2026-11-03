package com.Tsheps.VolunteerManagementApp.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonPropertyOrder({"statusCode", "statusMessage", "ErrorMessage"})
public class ExceptionHandlerResponse {
    String statusMessage;
    int statusCode;
    String ErrorMessage;
}
