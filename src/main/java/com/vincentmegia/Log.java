package com.vincentmegia;

import java.util.Objects;

public class Log {
    private String userid;
    private int timestamp;
    private String action;

    public Log(String userid, int timestamp, String action) {
        this.userid = userid;
        this.timestamp = timestamp;
        this.action = action;
    }

    public String getUserid() { return userid; }
    public void setUserid(String userid) { this.userid = userid; }
    public int getTimestamp() { return timestamp; }
    public void setTimestamp(int timestamp) { this.timestamp = timestamp; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(userid, log.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid);
    }

    @Override
    public String toString() {
        return "Log{" +
                "userid='" + userid + '\'' +
                ", timestamp=" + timestamp +
                ", action='" + action + '\'' +
                '}';
    }
}
