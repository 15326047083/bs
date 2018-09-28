package com.leiyuan.bs.entity;

// 留言表
public class Message {
    private Integer id; // 主键

    private String info; // 内容

    private Integer userId; // 留言者ID

    private String time; // 留言时间

    private Integer replyId; // 回复ID

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                ", replyId=" + replyId +
                '}';
    }

    public Message() {
    }

    public Message(Integer id, String info, Integer userId, String time, Integer replyId) {

        this.id = id;
        this.info = info;
        this.userId = userId;
        this.time = time;
        this.replyId = replyId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }
}