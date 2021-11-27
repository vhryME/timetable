package com.vhry.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
public class AppException extends RuntimeException {

    ErrorCodeEnum errorCode;
    private Map<String, Object> properties;

    public AppException(ErrorCodeEnum errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public AppException(ErrorCodeEnum errorCode, Map<String, Object> properties) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
        this.properties = properties;
    }

    public AppException(ErrorCodeEnum errorCode, String message, Map<String, Object> properties) {
        super(message);
        this.errorCode = errorCode;
        this.properties = properties;
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCodeEnum getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

}
