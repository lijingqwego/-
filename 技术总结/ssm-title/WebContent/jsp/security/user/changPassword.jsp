<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/user/changePassword.js"></script>
<div id="content">
	<div class="row-fluid">
        <div class="span12">
          <div class="widget-box">
            <div class="widget-title"> <span class="icon"> <i class="icon-cog"></i> </span>
              <h5>to change password</h5>
            </div>
            <div class="widget-content nopadding">
              <form class="form-horizontal" method="post" action="#" name="password_validate" id="password_validate" novalidate="novalidate">
                <div class="control-group">
                  <label class="control-label">Password</label>
                  <div class="controls">
                    <input type="password" name="oldpwd" id="oldpwd" />
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">new password</label>
                  <div class="controls">
                    <input type="password" name="newpwd" id="newpwd" />
                  </div>
                </div>
                <div class="control-group">
                  <label class="control-label">Confirm Password</label>
                  <div class="controls">
                    <input type="password" name="newpwd" id="newpwd1" />
                  </div>
                </div>
               <div class="control-group">
                  <div class="controls">
                  <input class="btn btn-success" type="button" id="btn_change" value="确认修改">
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
</div>