package com.tiantianchiji.onlineexam.dtos;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class JsonResponse<BodyType> implements Serializable{
    private static final long _serialVersionUID = 1L;

    private HttpStatus status;
    private String message;
    private BodyType body;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BodyType getBody() {
        return body;
    }

    public void setBody(BodyType body) {
        this.body = body;
    }

}
