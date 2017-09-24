<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/user/userAndRole.js"></script> 
<div id="content">
	<div id="content-header">
	    <h1>角色关联</h1>
	 </div>
	 <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>角色关联</h5>
            <span class="label label-info">Featured</span> </div>
          <div class="widget-content ">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th></th>
                  <th>角色名称</th>
                  <th>角色描述</th>
                  <th>关联状态</th>
                </tr>
              </thead>
              <tbody>
                 <c:forEach items="${roles}" var="role">
                 	<tr>
                 	<td><label><input type="radio" value="${role.roleid }" name="roellist" <c:if test="${role.userid !=1}" > checked="checked" </c:if> /></label></td>
                 	<td>${role.rolename}</td>
                 	<td>${role.descn}</td>
                 	<td>${role.userid =="1" ? "无" :"已关联"}</td>
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
