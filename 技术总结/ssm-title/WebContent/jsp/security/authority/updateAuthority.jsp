<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/authority/updateAuthority.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="${pageContext.request.contextPath }/authority/updateAuthority.action" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">权限名称 :</label>
              <input type="hidden" name="authorityid" value="${authority.authorityid }" />
              <div class="controls">
                <input type="text" class="span11" name="authorityname" value="${authority.authorityname }" placeholder="权限名称" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 权限说明:</label>
              <div class="controls">
                <input type="text" class="span11" name="descn" value="${authority.descn }" placeholder="该权限主要作用是" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">功能</label>
              <div class="controls">
                <input type="text"  class="span11" value="${authority.function }" name="function" placeholder="功能是"  />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">功能名称</label>
              <div class="controls">
              	<input type="text" class="span11" value="${authority.functionname }" name="functionname">
              </div>
            </div>
            
            <div class="form-actions">
              <button class="btn btn-success" id="btn-update">Save</button>
            </div>
          </form>
        </div>
      </div>
      </div>