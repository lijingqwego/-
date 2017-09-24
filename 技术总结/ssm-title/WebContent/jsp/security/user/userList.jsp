<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>用户列表</h1>
  </div>
  <div class="container-fluid">
     <form class="form-search" action="${pageContext.request.contextPath }/account/showAccounts.action" method="post">
         <input type="text" class="input-medium" id="loginid" name="loginid" placeholder="用户账号">	&nbsp;&nbsp;
         <input type="text" class="input-medium" id="username" name="username" placeholder="用户姓名">
         <button type="submit" class="btn btn-primary ">Search</button>&nbsp;&nbsp;&nbsp;&nbsp;
         <a href="${pageContext.request.contextPath}/account/addUser.action"><input type="button" class="btn btn-primary " value="添加用户"></a>
     </form> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>用户 table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th width="20%">用户账号</th>
                  <th width="15%">用户名</th>
                  <th width="15%">账号状态</th>
                  <th width="20%">最后的登录时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${userlist }" var="user">
                <tr class="odd gradeX">
                  <td>${user.loginid}</td>
                  <td>${user.username}</td>
                  <td>${user.userflag ==1 ? "正常状态" :"异常状态"}</td>
                  <td><fmt:formatDate value="${user.loginlasttime }" pattern="yyyy-MM-dd"/></td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/account/findByUserid.action?userid=${user.userid}"><button class="btn btn-danger">修改用户</button></a>
                  	<a href="${pageContext.request.contextPath}/account/removeUser.action?userid=${user.userid}"><button class="btn btn-success">删除用户</button></a>
                  	<a href="${pageContext.request.contextPath}/account/userandrole.action?userid=${user.userid}"><button class="btn btn-primary">关联角色</button></a>
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