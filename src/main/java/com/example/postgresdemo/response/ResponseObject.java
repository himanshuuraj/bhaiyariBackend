package com.example.postgresdemo.response;

public class ResponseObject {

    Boolean successStatus = true;
    int status = 200;
    String error;
    Object body;

    public Boolean getSuccessStatus() {
        return successStatus;
    }

    public void setSuccessStatus(Boolean successStatus) {
        this.successStatus = successStatus;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

}
