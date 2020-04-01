package com.uwm.onlineshopping.util;

import java.util.HashMap;
import java.util.Map;


public class ServiceResponse {

    private Boolean success;
    private String message;
    private Map<String, Object> params;

    public ServiceResponse(String message) {
        this(true, message);
    }

    public ServiceResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
        this.params = new HashMap<String, Object>();
    }

    public ServiceResponse addParam(String key, Object value) {
        params.put(key, value);
        return this;
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public static ServiceResponse getServiceResponse(Boolean success, String message) {
        return new ServiceResponse(success, message);
    }

    public static ServiceResponse getServiceResponse(String message) {
        return new ServiceResponse(message);
    }

}
