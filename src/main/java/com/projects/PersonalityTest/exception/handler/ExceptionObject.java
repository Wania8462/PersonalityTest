package com.projects.PersonalityTest.exception.handler;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ExceptionObject {
    private Date timeStamp;
    private int status;
    private String error;
    private String path;
}
