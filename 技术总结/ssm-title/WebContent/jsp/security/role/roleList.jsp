<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>角色列表</h1>
  </div>
  
  <div class="container-fluid">
  
     <form class="form-search" action="${pageContext.request.contextPath }/role/showRoles.action" method="post">
         <input type="text" class="input-medium"  name="rolename" placeholder="角色名">	&nbsp;&nbsp;
         <input type="text" class="input-medium"  name="descn" placeholder="角色描述">
         <button type="submit" class="btn btn-primary ">Search</button>
         <a href="${pageContext.request.contextPath}/role/addRole.action"><input type="button" class="btn btn-primary " value="添加角色"></a>
     </form> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>角色 table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th width="20%">角色名称</th>
                  <th width="20%">角色说明</th>
                  <th width="20%">账号状态</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${rolelist }" var="role">
                <tr class="odd gradeX">
                  <td>${role.rolename}</td>
                  <td>${role.descn}</td>
                  <td>${role.flaginfo ==1 ? "正常状态" :"异常状态"}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/role/findByRoleid.action?roleid=${role.roleid}"><button class="btn btn-danger">修改角色</button></a>
                  	<a href="${pageContext.request.contextPath}/role/removeRole.action?roleid=${role.roleid}"><button class="btn btn-success">删除角色</button></a>
                  	<a href="${pageContext.request.contextPath}/role/roleAndAuthority.action?roleid=${role.roleid}"><button class="btn btn-primary">关联权限</button></a>
                  </td>
                </tr>
               </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <!-- end -->
      </div>
    </div>
  </div>
</div>