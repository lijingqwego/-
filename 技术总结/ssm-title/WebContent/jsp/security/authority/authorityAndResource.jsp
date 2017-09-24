<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/resource/authorityAndResource.js"></script> 
<div id="content">
	<div id="content-header">
	    <h1>角色关联</h1>
	 </div>
	 <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>角色关联</h5>
            <span class="label label-info">Featured</span> </div>
          <div class="widget-content ">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th><input type="checkbox" id="title-table-checkbox" name="title-table-checkbox" /></th>
                  <th>资源名称</th>
                  <th>资源类型</th>
                  <th>资源链接</th>
                  <th>资源描述</th>
                  <th>更新时间</th>
                  <th>关联状态</th>
                </tr>
              </thead>
              <tbody>
                 <c:forEach items="${resourcelist }" var="resource">
                 	<tr>
                 	<td><input type="checkbox" value="${resource.resourceId }" name="roellist" <c:if test="${resource.authorityid !=1}" > checked="checked"</c:if> /></td>
                 	<td>${resource.resourceName}</td>
                 	<td>${resource.resourceType}</td>
                 	<td>${resource.resourceUrl}</td>
                 	<td>${resource.resourceDec}</td>
                 	<td><fmt:formatDate value="${resource.updateTime }" pattern="yyyy-MM-dd"/></td>
                  <td>
                 	<td>${resource.authorityid =="1" ? "无" :"已关联"}</td>
                 	</tr>
                 </c:forEach>
                 <tr>
                 	<td colspan="4" style="text-align: center;"> <button class="btn btn-primary btn-large" id="btn-relevance">关联已经选中的角色</button></td>
                 </tr>
              </tbody>
            </table>
          </div>
        </div>
</div>
