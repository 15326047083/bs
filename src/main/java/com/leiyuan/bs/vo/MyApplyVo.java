package com.leiyuan.bs.vo;

// 我的申请（vo展示类）
public class MyApplyVo {
    private Integer applyId; // 申请ID
    private String applyTime; // 申请时间
    private Integer applyState; // 申请状态
    private Integer reId; // 岗位ID
    private String reTitle; // 岗位标题
    private Integer money; // 工资

    @Override
    public String toString() {
        return "MyApplyVo{" +
                "applyId=" + applyId +
                ", applyTime='" + applyTime + '\'' +
                ", applyState=" + applyState +
                ", reId=" + reId +
                ", reTitle='" + reTitle + '\'' +
                ", money=" + money +
                '}';
    }

    public MyApplyVo() {
    }

    public MyApplyVo(Integer applyId, String applyTime, Integer applyState, Integer reId, String reTitle, Integer
            money) {

        this.applyId = applyId;
        this.applyTime = applyTime;
        this.applyState = applyState;
        this.reId = reId;
        this.reTitle = reTitle;
        this.money = money;
    }

    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public Integer getApplyState() {
        return applyState;
    }

    public void setApplyState(Integer applyState) {
        this.applyState = applyState;
    }

    public Integer getReId() {
        return reId;
    }

    public void setReId(Integer reId) {
        this.reId = reId;
    }

    public String getReTitle() {
        return reTitle;
    }

    public void setReTitle(String reTitle) {
        this.reTitle = reTitle;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
