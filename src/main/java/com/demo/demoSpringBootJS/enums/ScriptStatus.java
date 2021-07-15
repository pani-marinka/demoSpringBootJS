package com.demo.demoSpringBootJS.enums;

public enum ScriptStatus {
    SCHEDULED ("0"),
    RUNNING ("1"),
    COMPLETE("2"),
    FAILD ("3"),
    NOT_FOUND("NOT_FOUND");


    private ScriptStatus(String value) {
        this.value = value;
    }
    private String value;
    public String getValue() {
        return value;
    }
    /*
    (0, "scheduled");
        STATUS_INFO_REPOSITORY_MAP.put(1, "running");
        STATUS_INFO_REPOSITORY_MAP.put(2, "complete");
        STATUS_INFO_REPOSITORY_MAP.put(3, "failed");
     */

}

