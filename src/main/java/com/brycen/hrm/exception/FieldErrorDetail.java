package com.brycen.hrm.exception;

public class FieldErrorDetail {

    private String fieldName;
    private String errorCode;    
   
    public String getFieldName() {
        return fieldName;
    }
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
