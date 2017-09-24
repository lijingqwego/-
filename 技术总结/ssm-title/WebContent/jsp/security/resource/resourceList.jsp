<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>资源列表</h1>
  </div>
  
  <div class="container-fluid">
  
     <form class="form-search" action="${pageContext.request.contextPath }/resource/showResource.action" method="post">
         <input type="text" class="input-medium"  name="resourcename" placeholder="资源名称">
         <button type="submit" class="btn btn-primary ">Search</button>
     </form> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>资源 table</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>资源名称</th>
                  <th>资源类型</th>
                  <th>资源链接</th>
                  <th>资源描述</th>
                  <th>状态信息</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${resourcelist }" var="resource">
                <tr class="odd gradeX">
                  <td>${resource.resourceName}</td>
                  <td>${resource.resourceType}</td>
                  <td>${resource.resourceUrl}</td>
                  <td>${resource.resourceDec}</td>
                  <td>${resource.enabled ==1 ? "正常状态" :"异常状态"}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/resource/findByResourceid.action?resourceid=${resource.resourceId}"><button class="btn btn-danger">修改资源</button></a>
                  	<a href="${pageContext.request.contextPath}/resource/removeResource.action?resourceid=${resource.resourceId}"><button class="btn btn-success">删除资源</button></a>
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