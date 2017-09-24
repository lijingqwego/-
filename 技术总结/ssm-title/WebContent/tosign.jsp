<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en">
<head>
        <title>用户注册</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css" />
        <link href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/js/user/sign.js"></script>
		<style type="text/css">
			html, body { 
			   width: 100%;  
			   height: 90%;
			}
			.div1{ 
			width:100%;
			height:100%;
			background:url(img/user/login.jpg);
			padding-top:10%;
			padding-left:35%;
			z-index:-1
			}
			.div2{
			text-align:center;
			width:300px;
			border:3px solid #3f4954;
			}
		</style> 
    </head>
<body>
<div class="div1">
	<div class="div2">
  	<form class="form-vertical" action="#" method="post"  >
	    	<div class="control-group">
	            <div class="controls">
	                <span class="add-on bg_ly"><label class="control-label">用户账号</label></span>
	                <input type="text" id="userid" name="userid" maxlength="20" placeholder="如 yanyan2222" />
	            </div>
         	</div>
	       <div class="control-group">
	           <div class="controls">
	                   <span class="add-on bg_ly"><label class="control-label">用户密码</label></span>
	                   <input type="password" id="password" name="password" maxlength="20" placeholder="如：a2356s56" />
	           </div>
	       </div>
	       <div class="control-group">
	           <div class="controls">
	                   <span class="add-on bg_ly"><label class="control-label">用户姓名</label></span>
	                   <input type="text" id="username" name="username" maxlength="20" placeholder="如：洛水子涵"/>
	           </div>
	       </div>
    	<div class="control-group">
	      	<div style="margin-left:10px;display:inline">
	              <input type="button" value="to check user" class="btn btn-success" id="btn_check" />
	          </div>
	      	<div style="margin-left:60px;display:inline">
	              <input type="button" value="to sign up" class="btn btn-success" id="btn_sign" />
	          </div>
      </div>
  	</form>
  	</div>
</div>
</body>
</html>
