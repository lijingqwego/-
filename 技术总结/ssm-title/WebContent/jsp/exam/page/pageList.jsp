<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">
  
  <div class="container-fluid">
   <hr>
   <a href="${pageContext.request.contextPath}/page/toInsert.action"><button class="btn btn-info">添加</button></a>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th width="10%">试卷名称</th>
                  <th width="15%">试卷类型</th>
                  <th>试卷描述</th>
                  <th>科目编号</th>
                  <th>考试时长</th>
                  <th>试题数目</th>
                  <th>总分数</th>
                  <th>创建用户</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${pagelist }" var="vo">
                <tr class="gradeX">
                  <td>${vo.examinationName}</td>
                  <td>${vo.examinationType==1? "单元测试":"综合测试"}</td>
                  <td>${vo.examinationContent}</td>
                  <td>${vo.subjectNo}</td>
                  <td>${vo.examLength}</td>
                  <td>${vo.paperscore.questionNum}</td>
                  <td>${vo.paperscore.totalScore}</td>
                  <td>${vo.createUser}</td>
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