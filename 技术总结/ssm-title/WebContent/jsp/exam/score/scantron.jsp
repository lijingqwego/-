<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="#" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#">Student pages</a> <a href="#" class="current">Info</a> </div>
    <h1>答题卡</h1>
  </div>
  <div class="container-fluid">
   <hr>
    <div class="row-fluid">
      <div class="span12">   
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
          	<table class="table table-bordered">
          		<thead>
                <tr>
                  <th width="10%">考试人员</th>
                  <th>正确数量</th>
                  <th>错误数量</th>
                  <th>总分数</th>
                  <th>答题时长</th>
                </tr>
              </thead>
               <tbody>
               	<tr>
               		<td>${vo.examinationUser}</td>
               		<td>${vo.rightNum}</td>
               		<td>${vo.errorNum}</td>
               		<td>${vo.score}</td>
               		<td>${vo.examinationLength}</td>
               	</tr>
               </tbody>
          	</table>
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th width="10%">题目序号</th>
                  <th width="15%">题目类型</th>
                  <th>填写的答案</th>
                  <th>正确答案</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach items="${list }" var="vr">
                <tr class="gradeX">
                  <td>${vr.questionNum}</td>
                  <td>${vr.questionType}</td>
                  <td>${vr.chooseKey}</td>
                  <td>${vr.rightKey}</td>
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