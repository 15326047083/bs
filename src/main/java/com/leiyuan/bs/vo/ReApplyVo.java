package com.leiyuan.bs.vo;

// 岗位申请（展示vo类）
public class ReApplyVo {
    private Integer applyId; // 申请ID
    private String applyTime; // 申请时间
    private Integer applyState; // 申请状态
    private Integer reId; // 岗位ID
    private Integer userId; // 主键
    private String userName; // 名称
    private String userEmail; // 邮箱
    private String userPhone; // 手机
    private String userPassword; // 密码
    private Integer userAge; // 年龄
    private String userSex; // 性别

    @Override
    public String toString() {
        return "ReApplyVo{" +
                "applyId=" + applyId +
                ", applyTime='" + applyTime + '\'' +
                ", applyState=" + applyState +
                ", reId=" + reId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                '}';
    }

    public ReApplyVo() {
    }

    public ReApplyVo(Integer applyId, String applyTime, Integer applyState, Integer reId, Integer userId, String
            userName, String userEmail, String userPhone, String userPassword, Integer userAge, String userSex) {

        this.applyId = applyId;
        this.applyTime = applyTime;
        this.applyState = applyState;
        this.reId = reId;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userAge = userAge;
        this.userSex = userSex;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }
}
