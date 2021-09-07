package com.example.demoapp.employees;

public class ErrorResponse {

    private int code;
    private String detail;

    public ErrorResponse(int code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    public ErrorResponse() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }



}
