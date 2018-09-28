package com.leiyuan.bs.vo;

public class ReplyVo {
    private Integer id; // 主键

    private String info; // 内容

    private Integer userId; // 留言者ID

    private String time; // 留言时间

    private Integer replyId; // 回复ID

    private String name; // 名字

    private String email; // 邮箱

    private String phone; // 电话

    private String password; // 密码

    private Integer age; // 年龄

    private String sex; // 性别

    public ReplyVo(){}
    public ReplyVo(Integer id, String info, Integer userId, String time, Integer replyId, String name, String email, String phone, String password, Integer age, String sex) {
        this.id = id;
        this.info = info;
        this.userId = userId;
        this.time = time;
        this.replyId = replyId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "ReplyVo{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", userId=" + userId +
                ", time='" + time + '\'' +
                ", replyId=" + replyId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
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
        this.info = info;
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
        this.time = time;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
