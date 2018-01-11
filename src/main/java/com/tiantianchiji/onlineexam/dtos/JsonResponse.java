package com.tiantianchiji.onlineexam.dtos;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class JsonResponse<BodyType> implements Serializable{
    private static final long _serialVersionUID = 1L;

    private int status;
    private String message;
    private BodyType body;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setByHttpStatus(HttpStatus httpStatus) {
        this.status = httpStatus.value();
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

    public JsonResponse<BodyType> fillStatus(HttpStatus status) {
        this.setByHttpStatus(status);
        return this;
    }

    public JsonResponse<BodyType> fillMessage(String message) {
        this.setMessage(message);
        return this;
    }

    public JsonResponse<BodyType> fillBody(BodyType body) {
        this.setBody(body);
        return this;
    }
}
