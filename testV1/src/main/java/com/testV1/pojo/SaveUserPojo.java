package com.testV1.pojo;

public class SaveUserPojo {
	private int openUid;

    private String openId;

    private String headImg;

    private String userName;

    private String userTel;

    public int getOpenUid() {
        return openUid;
    }

    public void setOpenUid(int openUid) {
        this.openUid = openUid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }
}
