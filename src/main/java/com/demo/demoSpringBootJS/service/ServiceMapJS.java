package com.demo.demoSpringBootJS.service;

import com.demo.demoSpringBootJS.model.ScriptInfo;

import java.util.List;

public interface ServiceMapJS {
    /**
     * Создает новую запись с скриптом
     * * @param scriptInfo - информация для создания скрипта
     */
    void create(ScriptInfo scriptInfo);
    /**
     * Возвращает список все ScriptInfo
     * @return список клиентов
     */
    List<ScriptInfo> readAll();

    /**
     * Возвращает ScriptInfo по его ID
     * @param id - ID ScriptInfo
     * @return - объект ScriptInfo с заданным ID
     */
    ScriptInfo read(int id);

    /**
     * Обновляет ScriptInfo с заданным ID,
     * в соответствии с переданным
     * @param id - id ScriptInfo которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(ScriptInfo scriptInfo, int id);

    /**
     * Обновляет Date time_started - дату время запуска Schedul;
     * Обновляет status - running (1)
     * ScriptInfo с заданным ID,
     * в соответствии с переданным
     * @param id - id ScriptInfo которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean updateStart(int id);


    /**
     * Обновляет ScriptInfo Date time_finished - дату время завершения выполения скрипта;
     * Обновляет status : 'complete' 2 or 'failed' 3,
     *    с заданным ID,
     * в соответствии с переданным
     * @param id - id ScriptInfo которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */

    boolean updateFinish(int id, String result);



    /**
     * Удаляет ScriptInfo с заданным ID
     * @param id - id ScriptInfo, которого нужно удалить
     * @return - true если ScriptInfo был удален, иначе false
     */
    boolean delete(int id);

    /**
     * Возвращает  ID ScriptInfo, которые нужно запустить
     * @return - List<Integer> с полученными ID
     */
    List<Integer> getScheduler();


    /**
     * Возвращает  Status script с заданным ID
     * @return - String Status
     */
    String readStatus(int id);

}
