<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>权限列表</h1>
  </div>
  
  <div class="container-fluid">
  
     <form class="form-search" action="${pageContext.request.contextPath }/authority/showAuthority.action" method="post">
         <input type="text" class="input-medium"  name="authorityname" placeholder="权限名称">
         <input type="text" class="input-medium"  name="descn" placeholder="权限简介">
         <button type="submit" class="btn btn-primary ">Search</button>
     </form> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>权限table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th width="20%">权限名称</th>
                  <th width="15%">权限描述</th>
                  <th width="15%">功能</th>
                  <th width="15%">权限操作名称</th>
                  <th width="15%">权限编码</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${authoritylist }" var="authority">
                <tr class="odd gradeX">
                  <td>${authority.authorityname}</td>
                  <td>${authority.descn}</td>
                  <td>${authority.function}</td>
                  <td>${authority.functionname }</td>
                  <td>${authority.code }</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/authority/findByAuthorityid.action?authorityid=${authority.authorityid}"><button class="btn btn-danger">修改权限</button></a>
                  	<a href="${pageContext.request.contextPath}/authority/removeAuthority.action?authorityid=${authority.authorityid}"><button class="btn btn-success">删除权限</button></a>
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