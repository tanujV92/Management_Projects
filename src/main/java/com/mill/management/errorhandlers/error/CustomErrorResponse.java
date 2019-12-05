package com.mill.management.errorhandlers.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CustomErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd hh:mm:ss")
    private Date timeStamp;
    private int status;
    private String error;
    private String path;
}
