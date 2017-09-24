<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>课目列表</h1>
  </div>
  <div class="container-fluid">
   <hr>
   <a href="${pageContext.request.contextPath}/subject/toInsert.action"><button class="btn btn-info">添加</button></a>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th width="10%">科目编码</th>
                  <th width="15%">科目名</th>
                  <th>科目内容</th>
                  <th>科目目标</th>
                  <th>科时</th>
                  <th>父级科目</th>
                  <th>级别</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${subjectlist }" var="vo">
                <tr class="odd gradeX">
                  <td>${vo.subjectCode}</td>
                  <td>${vo.subjectName}</td>
                  <td>${vo.classContent}</td>
                  <td>${vo.classTarget}</td>
                  <td>${vo.classHour}</td>
                  <td>${vo.fatherName}</td>
                  <td>${vo.subjectOrder}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/subject/findBysubjectno.action?subjectno=${vo.subjectNo}"><button class="btn btn-danger">修改科目信息</button></a>
                  	<a href="${pageContext.request.contextPath}/subject/removeProduct.action?subjectno=${vo.subjectNo}"><button class="btn btn-success">删除科目</button></a>
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