package com.demo.demoSpringBootJS.model;

import java.util.Date;
import java.util.Objects;

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

    public String getTextScript() {
        return textScript;
    }

    public void setTextScript(String textScript) {
        this.textScript = textScript;
    }

    private String result;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getTime_added() {
        return time_added;
    }

    public void setTime_added(Date time_added) {
        this.time_added = time_added;
    }

    public Date getTime_started() {
        return time_started;
    }

    public void setTime_started(Date time_started) {
        this.time_started = time_started;
    }

    public Date getTime_finished() {
        return time_finished;
    }

    public void setTime_finished(Date time_finished) {
        this.time_finished = time_finished;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScriptInfo that = (ScriptInfo) o;
        return Objects.equals(id, that.id) && Objects.equals(textScript, that.textScript) && Objects.equals(statusId, that.statusId) && Objects.equals(time_added, that.time_added) && Objects.equals(time_started, that.time_started) && Objects.equals(time_finished, that.time_finished) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textScript, statusId, time_added, time_started, time_finished, result);
    }

    @Override
    public String toString() {
        return "ScriptInfo{" +
                "id=" + id +
                ", textScript='" + textScript + '\'' +
                ", statusId=" + statusId +
                ", time_added=" + time_added +
                ", time_started=" + time_started +
                ", time_finished=" + time_finished +
                ", result='" + result + '\'' +
                '}';
    }
}
