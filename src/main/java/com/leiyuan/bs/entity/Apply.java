package com.leiyuan.bs.entity;

// 申请表
public class Apply {
    private Integer id; // 主键

    private Integer userId; // 申请者ID

    private Integer reId; // 岗位ID

    private String applyTime; // 申请时间

    private Integer state; // 申请状态

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", userId=" + userId +
                ", reId=" + reId +
                ", applyTime='" + applyTime + '\'' +
                ", state=" + state +
                '}';
    }

    public Apply() {
    }

    public Apply(Integer id, Integer userId, Integer reId, String applyTime, Integer state) {

        this.id = id;
        this.userId = userId;
        this.reId = reId;
        this.applyTime = applyTime;
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

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime == null ? null : applyTime.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}