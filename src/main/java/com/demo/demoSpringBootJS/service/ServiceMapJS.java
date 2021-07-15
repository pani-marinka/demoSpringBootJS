package com.demo.demoSpringBootJS.service;

import com.demo.demoSpringBootJS.model.ScriptInfo;

import java.util.List;

public interface ServiceMapJS {
    /**
     * Creates a new entry with a script
     * * @param scriptInfo - information for creating a script
     */
    void create(ScriptInfo scriptInfo);
    /**
     * Returns a list of all ScriptInfo
     * @return customer list
     */
    List<ScriptInfo> readAll();

    /**
     * Returns ScriptInfo by its ID
     * @param id - ID ScriptInfo
     * @return - a ScriptInfo object with a given ID
     */
    ScriptInfo read(int id);

    /**
     * Updates the ScriptInfo with the given ID,
     * in accordance with the transmitted
     * @param id - id of ScriptInfo which needs to be updated
     * @return - true if the data has been updated, otherwise false
     */
    boolean update(ScriptInfo scriptInfo, int id);

    /**
     * Updates Date time_started - date and time when Schedul was started;
     * Updates status - running (1)
     * ScriptInfo with the given ID,
     * in accordance with the transmitted
     * @param id - id of ScriptInfo which needs to be updated
     * @return - true if the data has been updated, otherwise false
     */
    boolean updateStart(int id);


    /**
     * Updates ScriptInfo Date time_finished - date and time of completion of the script execution;
     * Updates status: 'complete' 2 or 'failed' 3,
     * with a given ID,
     * in accordance with the transmitted
     * @param id - id of ScriptInfo which needs to be updated
     * @return - true if the data has been updated, otherwise false
     */

    boolean updateFinish(int id, String result);



    /**
     * Removes ScriptInfo with given ID
     * @param id - the id of the ScriptInfo to be removed
     * @return - true if the ScriptInfo was removed, false otherwise

     */
    boolean delete(int id);

    /**
     * Returns the ID ScriptInfo to run
     * @return - List <Integer> with received IDs
     */
    List<Integer> getScheduler();


    /**
     * Возвращает  Status script с заданным ID
     * @return - String Status
     */
    String readStatus(int id);

}
