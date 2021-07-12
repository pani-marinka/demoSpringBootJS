package com.demo.demoSpringBootJS.service;

public interface ServiceMapStatus {
    /**
     * Возвращает String Status по его ID
     * @param id - ID
     * @return - String Status  с заданным ID : 'scheduled' 0,  'running' 1, 'complete' 2,  'failed' 3
     */
    String readStatus(int id);
}
