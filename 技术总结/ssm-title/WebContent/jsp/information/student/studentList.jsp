<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/student/studentList.js"></script>

<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>学生列表</h1>
  </div>
  
  <div class="container-fluid">
  
     <form class="form-search" action="${pageContext.request.contextPath }/student/showStudents.action" method="post">
         <input type="text" class="input-medium"  name="studentname" placeholder="学生姓名">	&nbsp;&nbsp;
         <input type="text" class="input-medium"  name="studentno" placeholder="学号">    &nbsp;&nbsp;
         <input type="text" class="input-medium"  name="class" placeholder="班级id">
         <button type="submit" class="btn btn-primary ">Search</button>
     </form> 
   <hr>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
            <h5>学生表</h5>
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th width="20%">学号</th>
                  <th width="20%">学生姓名</th>
                  <th width="20%">班级</th>
                  <th width="10%">课程</th>
                  <th width="10%">更新时间</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${list }" var="vo">
                <tr class="odd gradeX">
                  <td>${vo.studentNo}</td>
                  <td>${vo.studentName}</td>
                  <td>${vo.classId}</td>
                  <td>${vo.lessonId}</td>
                  <td><fmt:formatDate value="${vo.updateTime}" pattern="yyyy-MM-dd"/></td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/student/findByStudentid.action?studentid=${vo.studentNo}"><button class="btn btn-danger">查看学生信息</button></a>
                  	<button onclick="deleteto(${vo.studentNo})" class="btn btn-success">删除该学生信息</button>
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