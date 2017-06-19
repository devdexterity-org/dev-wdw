<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<script type="text/javascript" src="../resources/js/jquery.2.0.min.js"></script>
<script type="text/javascript" src="../resources/js/jquery.resize.js"></script>
<script type="text/javascript" src="../resources/js/Util.js"></script>
<script type="text/javascript" src="../resources/js-ctrl/userManageCtrl.js"></script>
<link rel="stylesheet" href="../resources/css/common.css" type="text/css"> 
<link rel="stylesheet" href="../resources/css/user.css" type="text/css"> 
</head>
<body>
<script>
    window.onload = UserManageCtrl.ctrl
</script>
<div class="main_div">
	<div class="search_div">
        <div class="search_bar">
            <input type="text" id="search_text"  placeholder="请输入关键字搜索"/>
            <div onclick="UserManageCtrl.search()"><img src="../resources/images/search.png"/></div>
        </div>
	</div>
	<div class="btn_line">
        <div onclick="UserManageCtrl.addUser()">新增</div>
    </div>
	<table class="common_table" border="0" cellspacing="0" cellpadding="0">
       <tr>
           <th>openUid</th>
           <th>openId</th>
           <th>headImg</th>
           <th>userName</th>
           <th>userTel</th>
           <th>操作</th>
       </tr>
        <c:forEach items="${list}" var="item">
	          <tr>
	              <td>${item.openUid}</td>
	              <td>${item.openId}</td>
	              <td><img style="width:100px" src="${item.headImg}"/></td>
	              <td>${item.userName}</td>
	              <td>${item.userTel}</td>
	              <td><a onclick="UserManageCtrl.editUser('${item.openUid}')">编辑</a><span>/</span><a onclick="UserManageCtrl.delUser('${item.openUid}')">删除</a></td>
	          </tr>
          </c:forEach>
   </table>
</div>

</body>
</html>