package cn.gcrth.chatroom.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Massage {
    @Id
    private long id;
    private String from;
    private String to;
    private String time;
    private String content;
    @Generated(hash = 39142935)
    public Massage(long id, String from, String to, String time, String content) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.time = time;
        this.content = content;
    }
    @Generated(hash = 2073055479)
    public Massage() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFrom() {
        return this.from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return this.to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
