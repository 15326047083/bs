package com.leiyuan.bs.entity;

// 招聘信息
public class Recruitment {
    private Integer id; // 主键

    private Integer userId; // 发布用户ID

    private String title; // 标题

    private String info; // 详情

    private Integer money; // 工资

    private String startTime; // 上班时间

    private String endTime; // 下半时间

    private Integer placeState; // 校内0校外1

    private Integer state; // 招聘状态0招聘中1招聘成功

    @Override
    public String toString() {
        return "Recruitment{" +
                "id=" + id +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", money=" + money +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", placeState=" + placeState +
                ", state=" + state +
                '}';
    }

    public Recruitment() {
    }

    public Recruitment(Integer id, Integer userId, String title, String info, Integer money, String startTime, String
            endTime, Integer placeState, Integer state) {

        this.id = id;
        this.userId = userId;
        this.title = title;
        this.info = info;
        this.money = money;
        this.startTime = startTime;
        this.endTime = endTime;
        this.placeState = placeState;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getPlaceState() {
        return placeState;
    }

    public void setPlaceState(Integer placeState) {
        this.placeState = placeState;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}