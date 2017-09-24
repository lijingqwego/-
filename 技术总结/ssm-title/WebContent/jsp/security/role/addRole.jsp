<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/role/updateRole.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="${pageContext.request.contextPath }/role/insertRole.action" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">角色名称 :</label>
              <div class="controls">
                <input type="text" class="span11" name="rolename" maxlength="50" value="${role.rolename }" placeholder="角色名称" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 角色描述:</label>
              <div class="controls">
                <input type="text" class="span11" name="descn" maxlength="100" value="${role.descn }" placeholder="该角色位同那个职位" />
              </div>
            </div>
            <div class="form-actions">
              <button class="btn btn-success" id="btn-update">Save</button>
            </div>
          </form>
        </div>
      </div>
      </div>