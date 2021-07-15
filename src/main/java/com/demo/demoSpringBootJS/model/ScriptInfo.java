package com.demo.demoSpringBootJS.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ScriptInfo {
  /*  id:4
    text: console.log(1+2);
    status: 'complete'
    time_added: 2021-07-08 12:00
    time_started: 2021-07-08 12:01
    time_finished: 2021-07-08 12:02
    result: '3'

   */


    private Integer id; //autogeneration
    private String textScript;
    private Integer statusId; // 'complete' 2,  'failed' 3,  'scheduled' 0,  'running' 1 from mapStatus
    private Date time_added;
    private Date time_started;
    private Date time_finished;
    private String result;

}
