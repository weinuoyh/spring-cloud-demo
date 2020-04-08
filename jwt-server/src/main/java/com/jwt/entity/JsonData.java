package com.jwt.entity;

import lombok.Data;

@Data
public class JsonData {

    private boolean success;
    private String message;
    public JsonData() {

    }
    public JsonData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
    public JsonData(boolean success) {
        this.success = success;
    }

    public static JsonData success(String token) {
        JsonData jsonData = new JsonData();
        jsonData.setMessage(token);
        return jsonData;
    }
}
