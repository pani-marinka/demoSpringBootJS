package com.demo.demoSpringBootJS.service;

import com.demo.demoSpringBootJS.enums.ScriptStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceStatusImpl implements ServiceStatus {
    // Хранилище Status
    private static final Map<Integer, String> STATUS_INFO_REPOSITORY_MAP = new HashMap<>();

    //create Status
    private void create() {
        STATUS_INFO_REPOSITORY_MAP.put(0, "scheduled");
        STATUS_INFO_REPOSITORY_MAP.put(1, "running");
        STATUS_INFO_REPOSITORY_MAP.put(2, "complete");
        STATUS_INFO_REPOSITORY_MAP.put(3, "failed");
    }

    @Override
    public ScriptStatus readStatus(int id) {
        switch (id) {
            case 0:
                return ScriptStatus.SCHEDULED;
            case 1:
                return ScriptStatus.RUNNING;

            case 2:
                return ScriptStatus.COMPLETE;

            case 3:
                return ScriptStatus.FAILD;

            default:
                return ScriptStatus.NOT_FOUND;

        }


           }


}
