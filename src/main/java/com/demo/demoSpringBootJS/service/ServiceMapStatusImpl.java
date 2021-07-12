package com.demo.demoSpringBootJS.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceMapStatusImpl implements ServiceMapStatus {
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
    public String readStatus(int id) {
        if (STATUS_INFO_REPOSITORY_MAP.size() == 0) create();
        return STATUS_INFO_REPOSITORY_MAP.get(id);
    }


}
