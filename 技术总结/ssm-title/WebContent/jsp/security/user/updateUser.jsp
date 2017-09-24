<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/user/updateUser.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-cog"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="${pageContext.request.contextPath }/account/updateUser.action" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">用户账号 :</label>
              <input type="hidden" name="userid" value="${user.userid }" />
              <div class="controls">
                <input type="text" class="span11" id="loginid" name="loginid" maxlength="20" value="${user.loginid }" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 用户姓名:</label>
              <div class="controls">
                <input type="text" class="span11" id="username" name="username" maxlength="20" value="${user.username }" placeholder="请输入用户姓名" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">上次更新时间</label>
              <div class="controls">
              	<input type="text" class="span11" value="<fmt:formatDate value='${user.updateTime }' pattern='yyyy-MM-dd '/>" readonly="readonly">
              </div>
            </div>
             <div class="control-group">
             	<label class="control-label"><input type="button" class="btn btn-success" value="Save" id="btn-update"></label>
              <div class="controls">
              </div>
            </div>
          </form>
        </div>
      </div>
      </div>