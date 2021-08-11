package br.com.pedrofarbo.validators;

import java.io.Serializable;

public class ValidatorResponse implements Serializable {
    public String code;
    public String message;

    public ValidatorResponse() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
