<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
	<link href="<%=request.getContextPath() %>/static/login.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/static/bootstrap.min.css">
	<script src="<%=request.getContextPath() %>/static/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/popper.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/bootstrap.min.js"></script>
	<link href="<%=request.getContextPath() %>/static/bootstrap.min.css" rel="stylesheet" type="text/css" />
<jsp:include page="Super/Super_head.jsp"></jsp:include>
<style type="text/css">
	html,body{
		background:url("img/background.jpg");
		width:100%;
		height: 100%;
		overflow: hidden;
	}
	.btn{
		width:280px;
	}
	.btn:hover{
		background-color:#4492E0;
	}
</style>
</head>
<body >
	<div align="center" style="margin-top: 20px"><h2 align="center" style="margin-top:20px;">图书馆管理系统</h2></div>
	<!-- 文字滚动 -->
	<MARQUEE scrollAmount=10 direction=left>欢迎您的使用</MARQUEE>
	<!-- 使用百分比设置表单位置始终居中 -->
	<div class="form_wrapper">
		<form style="margin-left:40%;margin-top:5%;" action="LoginCheck" class="form-horizontal" method="post">
	         <div class="form-group">
	             <label for="user" stype="display:inline;">账户：</label>
	            <input id="user" type="text" class="form-control" name="username" style="display:inline;width:200px;"autocomplete="off" placeholder="用户名" />
	         </div>
	         <div class="form-group">
	             <label for="password" style="display:inline;">密码：</label>
	             <input id="password" type="password" class="form-control" name="password" style="display:inline;width:200px;"autocomplete="off" placeholder="密码"/>
	         </div>
	         <div class="form-group">
	             <label for="usertype" style="display:inline;">类型：</label>
				 <select id="usertype" class="dropdown" name="usertype" style="display:inline;">
						<option value = "-1">系统管理员</option>
						<option value = "0">图书管理员</option>
						<option value = "1">读者</option>
				</select>
	         </div>
		         <button type="submit" class="btn"  >登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
	     </form>
	</div>
		
     <!-- 若登陆失败，弹窗提醒 -->
     		<%
		   String mess = (String)session.getAttribute("message");
		   if(mess==null){
		        
		   } else{%>
				<script type="text/javascript">	  
					alert("<%=mess%>");
				</script>
			<%
			session.setAttribute("message",null);
			%>
			<% }%>
			
</body>
<jsp:include page="Super/Super_footer.jsp"></jsp:include>
</html>