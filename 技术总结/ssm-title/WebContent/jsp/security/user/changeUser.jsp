<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/user/changeUser.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-cog"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="${pageContext.request.contextPath }/user/changeUser.action" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">原有昵称:</label>
              <div class="controls">
                <input type="text" class="span11" name="oldusername" value="${username }" readonly="readonly" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 用户姓名:</label>
              <div class="controls">
                <input type="text" class="span11" name="username" placeholder="请输入用户姓名" />
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