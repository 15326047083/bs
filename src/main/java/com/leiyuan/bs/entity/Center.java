package com.leiyuan.bs.entity;

// 中心简介，法律法规等
public class Center {
    private Integer id; // 主键

    private String title; // 标题

    private String info; // 内容

    private Integer state; // 状态(0为中心简介、1为法律法规)

    @Override
    public String toString() {
        return "Center{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", state=" + state +
                '}';
    }

    public Center() {
    }

    public Center(Integer id, String title, String info, Integer state) {

        this.id = id;
        this.title = title;
        this.info = info;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}