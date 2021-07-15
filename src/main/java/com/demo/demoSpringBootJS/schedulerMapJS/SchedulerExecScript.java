package com.demo.demoSpringBootJS.schedulerMapJS;

import com.demo.demoSpringBootJS.service.ServiceMapJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import static com.demo.demoSpringBootJS.service.ServiceMapJSImpl.myPriorityQueue;

public class SchedulerExecScript {
    @EnableScheduling
    public class ScheduledTasks {

        @Autowired
        private ServiceMapJS serviceMapJS;

        @Scheduled(fixedRate = 5000)
        public void execScript() {
            if (myPriorityQueue != null){
                for(String i: myPriorityQueue){
               // i--- что сюда писать?
                    myPriorityQueue.poll();
                }
            }
        }
    }
}
