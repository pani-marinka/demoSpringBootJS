package com.demo.demoSpringBootJS.service;

import com.demo.demoSpringBootJS.enums.ScriptStatus;

public interface ServiceStatus {
    /**
     * Return String Status по его ID
     * @param id - ID
     * @return - String Status  with adjusted  ID : 'scheduled' 0,  'running' 1, 'complete' 2,  'failed' 3
     */
    ScriptStatus readStatus(int id);
}
