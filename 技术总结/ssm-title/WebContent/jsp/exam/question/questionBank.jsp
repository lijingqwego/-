<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>题库列表</h1>
  </div>
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="span12">
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th width="20%">题库名称</th>
                  <th width="25%">题库描述</th>
                  <th>题目名称</th>
                  <th>所属科目</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${banklist }" var="vo">
                <tr class="odd gradeX">
                  <td>${vo.questionsName}</td>
                  <td>${vo.questionsDesc}</td>
                   <td>${vo.questionName}</td>
                  <td>${vo.subjectName}</td>
                  <td>
                  	<a href="${pageContext.request.contextPath}/bank/removebank.action?questionsno=${vo.questionsNo}"><button class="btn btn-success">释放题目</button></a>
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