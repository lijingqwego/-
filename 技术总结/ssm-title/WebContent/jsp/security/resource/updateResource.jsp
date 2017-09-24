<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/resource/updateResource.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="${pageContext.request.contextPath }/resource/updateResource.action" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">资源名称 :</label>
              <input type="hidden" name="resourceId" value="${resource.resourceId }" />
              <div class="controls">
                <input type="text" class="span11" name="resourceName" value="${resource.resourceName }" placeholder="用户账号" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 资源类型:</label>
              <div class="controls">
                <input type="text" class="span11" name="resourceType" value="${resource.resourceType }" placeholder="请输入4位以上的账号id" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">资源链接</label>
              <div class="controls">
                <input type="text"  class="span11" value="${resource.resourceUrl }" name="resourceUrl" placeholder="请输入6位及以上的密码"  />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">资源描述</label>
              <div class="controls">
                <input type="text"  class="span11" value="${resource.resourceDec }" name="resourceDec" placeholder="请输入6位及以上的密码"  />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">上次更新时间</label>
              <div class="controls">
              	<input type="date" class="span11" value="<fmt:formatDate value='${resource.updateTime }' pattern='yyyy-MM-dd '/>" readonly="readonly">
              </div>
            </div>
            
            <div class="form-actions">
              <button class="btn btn-success" id="btn-update">Save</button>
            </div>
          </form>
        </div>
      </div>
      </div>