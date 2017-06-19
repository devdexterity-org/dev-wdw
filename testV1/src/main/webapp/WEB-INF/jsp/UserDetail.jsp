<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户明细</title>
<script type="text/javascript" src="../static/js/jquery.2.0.min.js"></script>
<script type="text/javascript" src="../static/js/jquery.resize.js"></script>
<script type="text/javascript" src="../static/js/Util.js"></script>
<script type="text/javascript" src="../static/js-ctrl/userDetailCtrl.js"></script>
<link rel="stylesheet" href="../static/css/common.css" type="text/css"> 
<link rel="stylesheet" href="../static/css/user.css" type="text/css"> 
</head>
<body>
<script>
    window.onload = UserDetailCtrl.ctrl;
</script>
<div class="main_div">
    <div class="main_div_inner">
        <div class="user_info_row">
            <div class="user_title"><div class="user_title_left"></div><span>填写用户信息：</span></div>
        </div>
        <div class="user_info_row">
            <div class="user_info_title">openId：</div>
            <div class="user_info_content" ><input class="common_input" id="openId" type="text" placeholder="请输入openId"  value="${user.openId}"/></div>
        </div>
        <div class="user_info_row">
            <div class="user_info_title">姓名：</div>
            <div class="user_info_content"><input class="common_input" id="userName" type="text" placeholder="请输入姓名" value="${user.userName}"/></div>
        </div>
        <div class="user_info_row">
            <div class="user_info_title">电话：</div>
            <div class="user_info_content"><input class="common_input" id="userTel" type="text" placeholder="请输入电话" value="${user.userTel}"/></div>
        </div>
        <div class="user_info_row">
            <div class="user_info_title">头像：</div>
            <div class="user_info_content">
                <img id="headImg" src="${user.headImg}">
            </div>
        </div>
        <div class="user_info_submit">
            <div class="submit_btn" onclick="UserDetailCtrl.submit('${type}',${user.openUid})">提 交</div>
            <div class="submit_btn" style="background:dimgray" onclick="UserDetailCtrl.goBack()">返 回</div>
        </div>
    </div>
</div>
</body>
</html>