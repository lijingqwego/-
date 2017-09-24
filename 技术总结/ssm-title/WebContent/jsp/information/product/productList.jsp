<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"></div>
    <h1>课程列表</h1>
  </div>
  <div class="container-fluid">
   <hr>
   <a href="${pageContext.request.contextPath}/product/toinsert.action"><button class="btn btn-info">添加</button></a>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th width="20%">课程编码</th>
                  <th width="15%">课程名</th>
                  <th width="15%">课程描述</th>
                  <th width="20%">课程周期</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${productlist }" var="vo">
                <tr class="odd gradeX">
                  <td>${vo.lessonCode}</td>
                  <td>${vo.lessonName}</td>
                  <td>${vo.lessonContent}</td>
                  <td>${vo.lessonCycle}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/product/findByLessonid.action?lessonid=${vo.lessonId}"><button class="btn btn-danger">修改课程信息</button></a>
                  	<a href="${pageContext.request.contextPath}/product/removeProduct.action?lessonid=${vo.lessonId}"><button class="btn btn-success">删除课程</button></a>
                  	<a href="${pageContext.request.contextPath}/product/productandsubject.action?lessonid=${vo.lessonId}"><button class="btn btn-primary">关联科目</button></a>
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