package com.byka.humanlibrary.data;

import java.io.Serializable;

public class RegistrationEvent implements Serializable {
    private Boolean isSuccess;
    private String message;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
