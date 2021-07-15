package com.demo.demoSpringBootJS.service;

import com.demo.demoSpringBootJS.enums.ScriptStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceStatusImpl implements ServiceStatus {


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
