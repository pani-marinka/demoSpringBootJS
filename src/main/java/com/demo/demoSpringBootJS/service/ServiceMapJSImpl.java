package com.demo.demoSpringBootJS.service;

import com.demo.demoSpringBootJS.model.ScriptInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ServiceMapJSImpl implements ServiceMapJS {

    // Хранилище ScriptInfo
    private static final Map<Integer, ScriptInfo> SCRIPT_INFO_REPOSITORY_MAP = new HashMap<>();
    public static PriorityQueue<String> myPriorityQueue = new PriorityQueue<>();
    /*
    PriorityQueue<String> myPriorityQueue = new PriorityQueue<>();

        myPriorityQueue.add(1);
        myPriorityQueue.add(2);
        myPriorityQueue.add(3);

        for(int i: myPriorityQueue)
            System.out.println(i);
        myPriorityQueue.remove();
        System.out.println("After removing:");
        for(int i: myPriorityQueue)
            System.out.println(i);
     */

    @Autowired
    private ServiceMapStatus serviceMapStatus;


    // Переменная для генерации ID ScriptInfo
    private static final AtomicInteger SCRIPT_INFO_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(ScriptInfo scriptInfo) {
        final int scripInfoId = SCRIPT_INFO_ID_HOLDER.incrementAndGet();
        scriptInfo.setId(scripInfoId);
        scriptInfo.setTime_added(new Date());
        scriptInfo.setStatusId(0);
        SCRIPT_INFO_REPOSITORY_MAP.put(scripInfoId, scriptInfo);

    }

    @Override
    public List<ScriptInfo> readAll() {
        return new ArrayList<>(SCRIPT_INFO_REPOSITORY_MAP.values());
    }


    public List<Integer> getScheduler() {
        List<Integer> forSchedulerScriptInfoId = new ArrayList<>();
        Set<Integer> keys = SCRIPT_INFO_REPOSITORY_MAP.keySet();
        ScriptInfo scriptInfo;
        for (Integer id : keys) {
            scriptInfo = read(id);
            if (0 == scriptInfo.getStatusId()) forSchedulerScriptInfoId.add(id);
        }
        return forSchedulerScriptInfoId;
    }

    @Override
    public ScriptInfo read(int id) {
        return SCRIPT_INFO_REPOSITORY_MAP.get(id);
    }

    @Override
    public String readStatus(int id) {

        if (SCRIPT_INFO_REPOSITORY_MAP.get(id) == null) {
            return "ID DOES NOT EXIST";
        }
        return serviceMapStatus.readStatus(SCRIPT_INFO_REPOSITORY_MAP.get(id).getStatusId());

    }

    @Override
    public boolean update(ScriptInfo scriptInfo, int id) {
        return false;
    }

    @Override
    public boolean updateStart(int id) {
        ScriptInfo scriptInfo = read(id);
        if (scriptInfo == null) return false;
        scriptInfo.setStatusId(1);
        scriptInfo.setTime_started(new Date());
        SCRIPT_INFO_REPOSITORY_MAP.put(id, scriptInfo);
        return true;
    }

    @Override
    public boolean updateFinish(int id, String result) {
        ScriptInfo scriptInfo = read(id);
        if (scriptInfo == null) return false;
        scriptInfo.setTime_finished(new Date());
        scriptInfo.setResult(result);
        SCRIPT_INFO_REPOSITORY_MAP.put(id, scriptInfo);
        return true;
    }

    @Override
    public boolean delete(int id) { //delete without return item
        ScriptInfo scriptInfo = read(id);
        if (scriptInfo.getStatusId() == 1) {
            System.out.println("the Script  cannot be deleted, now It is running"); // script running
            return false;
        } else {
            SCRIPT_INFO_REPOSITORY_MAP.remove(id);
            return true; // all successfully
        }
    }
}
