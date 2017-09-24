<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/user/addUser.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="${pageContext.request.contextPath }/account/insertUser.action" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">用户账号</label>
              <div class="controls">
                <input type="text" class="span11" name="loginid"  placeholder="请输入用户账号" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 用户姓名:</label>
              <div class="controls">
                <input type="text" class="span11" name="username" placeholder="请输入用户姓名" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">用户密码</label>
              <div class="controls">
                <input type="text"  class="span11" name="password" placeholder="请输入6位及以上的密码"  />
              </div>
            </div>
            <div class="form-actions">
              <button class="btn btn-success" id="btn-update">Save</button>
            </div>
          </form>
        </div>
      </div>
      </div>