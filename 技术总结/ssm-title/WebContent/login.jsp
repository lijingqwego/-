<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<head>
        <title>慧极科技</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath }/css/matrix-login.css" />
        <link href="${pageContext.request.contextPath }/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>
		<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>  
        <script src="${pageContext.request.contextPath }/js/matrix.login2.js"></script>
        <style type="text/css">
			.div1{
					width:100%;
					height:100%;
					background:url(img/user/login.jpg);
					padding-top:10%;
					z-index:-1
					}
		</style> 
    </head>
    <body>
    <div class="div1">
        <div id="loginbox">            
            <form id="loginform" class="form-vertical" action="${pageContext.request.contextPath }/login.action" method="post"  >
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"></i></span>
                            <input type="text" id="username" name="username" maxlength="20" placeholder="请输入账号" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span>
                            <input type="password" id="password" name="password" maxlength="20" placeholder="请输入密码" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                	<div style="margin-left:10%;display:inline">
                        <input type="button" value="to sign up" class="btn btn-success" id="btn_sign" />
                    </div>
                	<div style="margin-left:40%;display:inline">
                        <input type="button" value="to login" class="btn btn-success" id="btn_login" />
                    </div>
                </div>
            </form>
        </div>
</div>
    </body>

</html>
