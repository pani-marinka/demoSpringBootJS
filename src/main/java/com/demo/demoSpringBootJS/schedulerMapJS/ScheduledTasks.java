package com.demo.demoSpringBootJS.schedulerMapJS;


import com.demo.demoSpringBootJS.model.ScriptInfo;
import com.demo.demoSpringBootJS.service.ServiceMapJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

import static com.demo.demoSpringBootJS.service.ServiceMapJSImpl.myPriorityQueue;

@EnableScheduling
public class ScheduledTasks {

    @Autowired
    private ServiceMapJS serviceMapJS;

    @Scheduled(fixedRate = 5000)
    public void execNewScript() {
       if (serviceMapJS.getScheduler() != null){
           ScriptInfo scriptInfo;
           String script;
           List<Integer> forSchedulerScriptInfoId = serviceMapJS.getScheduler();
           for(Integer id : forSchedulerScriptInfoId){
               scriptInfo = serviceMapJS.read(id);
               script = scriptInfo.getTextScript();
               myPriorityQueue.add(script);
               serviceMapJS.updateStart(id);
           }
       }
    }
}

