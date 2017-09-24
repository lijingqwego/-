<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>慧极科技</title><meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/uniform.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/select2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/matrix-style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/matrix-media.css" />
<!-- 增加 -->
 <link rel="stylesheet" href="${pageContext.request.contextPath }/css/colorpicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/datepicker.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-wysihtml5.css" />
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/exam/questionlist.js"></script>
<style type="text/css">

h1 {
	font-family:"微软雅黑";
	font-size:40px;
	margin:20px 0;
	border-bottom:solid 1px #ccc;
	padding-bottom:20px;
	letter-spacing:2px;
}

.time-item{
	background:#C71C60;
	color:#fff;
	line-height:49px;
	font-size:36px;
	font-family:Arial;
	padding:0 10px;
	margin-right:50px;
	margin-top:50px;
	display: inline-block;
	border-radius:5px;
	box-shadow:1px 1px 3px rgba(0,0,0,0.2);
}

#day_show {
	float:left;
	line-height:49px;
	color:#c71c60;
	font-size:32px;
	margin:0 10px;
	font-family:Arial,Helvetica,sans-serif;
}

.item-title .unit {
	background:none;
	line-height:49px;
	font-size:24px;
	padding:0 10px;
	float:left;
}
body{
	background:#22B8DD;
	color: #000000;
}
</style>
</head>
<body>
  <div style="width:50%;height: 150px;margin-top: 50px;margin-left: 50px;display: inline-block;">
    <label >考试编号</label>
    <input type="text" value="${examinfo.examinationInfoNo }" readonly="readonly"/>
    <label >考试人员</label>
     <input type="text" value="${examinfo.examinationUser }" readonly="readonly"/>
    <label >考试时间</label>
     <input type="number" value="${examinfo.examinationLength }" id="examlenght" readonly="readonly"/>
  </div>
  <div class="time-item">
	<strong id="hour_show">0时</strong>
	<strong id="minute_show">0分</strong>
	<strong id="second_show">0秒</strong>
  </div>
  <div class="container-fluid">
    <div class="row-fluid">
       <!-- begin -->
        <div class="widget-box">
          <div class="widget-content nopadding">
          	<form action="${pageContext.request.contextPath }/examtest/testOver.action" method="post" class="form-horizontal" id="questionform">
            <table class="table table-bordered">
               <c:forEach items="${questionlist }" var="vo">
                <tr class="odd gradeX">
                  <td style="width:30px">${vo.questionnum}</td>
                  <td style="width:30px"></td>
                  <td>${vo.questionname}</td>
                </tr>
                <c:if test="${vo.questiontype ==1}">
                	<c:forEach items="${vo.answerlist }" var="vr">
                		<tr class="odd gradeX">
                		  <td></td>
                		  <c:choose> 
  							<c:when test="${vr.answerNum==1}">
  								<td>
  									<label>
					                  <input type="radio" name="sk_${vo.questionnum}" value="A"/>A.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when>
  							<c:when test="${vr.answerNum==2}">
  								<td>
  									<label>
					                  <input type="radio" name="sk_${vo.questionnum}" value="B"/>B.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when>
  							<c:when test="${vr.answerNum==3}">
  								<td>
  									<label>
					                  <input type="radio" name="sk_${vo.questionnum}" value="C"/>C.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when>
  							<c:when test="${vr.answerNum==4}">
  								<td>
  									<label>
					                  <input type="radio" name="sk_${vo.questionnum}" value="D"/>D.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when> 
						  </c:choose> 
		                </tr>
                	</c:forEach>
                </c:if>
                <c:if test="${vo.questiontype ==2}">
                	<c:forEach items="${vo.answerlist}" var="vr">
                		<tr class="odd gradeX">
		                   <td></td>
                		  <c:choose> 
  							<c:when test="${vr.answerNum==1}">
  								<td>
  									<label>
					                  <input type="checkbox" name="mk_${vo.questionnum}" value="A"/>A.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when>
  							<c:when test="${vr.answerNum==2}">
  								<td>
  									<label>
					                  <input type="checkbox" name="mk_${vo.questionnum}" value="B"/>B.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when>
  							<c:when test="${vr.answerNum==3}">
  								<td>
  									<label>
					                  <input type="checkbox" name="mk_${vo.questionnum}" value="C"/>C.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when>
  							<c:when test="${vr.answerNum==4}">
  								<td>
  									<label>
					                  <input type="checkbox" name="mk_${vo.questionnum}" value="D"/>D.
					                 </label>
					             </td>
					             <td>${vr.answerContent}</td>
  							</c:when> 
						  </c:choose> 
		                </tr>
                	</c:forEach>
                </c:if>
                <c:if test="${vo.questiontype ==3}">
               		<tr class="odd gradeX">
               		  <td></td>
	                  <td>
	                  	<label>
					      <input type="radio" name="dk_${vo.questionnum}" value="是"/>是
					    </label>
	                  </td>
	                  <td>
	                  	<label>
					      <input type="radio" name="dk_${vo.questionnum}" value="否"/>否
					    </label>
	                  </td>
	                </tr>
                </c:if>
               </c:forEach>
            </table>
            <div class="control-group">
              <div class="controls">
                <input type="button" class="btn btn-success" value="Save" id="btn-insert">
              </div>
            </div>
            </form>
          </div>
        </div>
        <!-- end -->
      </div>
  </div>
</body>
</html>
