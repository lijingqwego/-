<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/role/roleAndAuthority.js"></script> 
<div id="content">
	<div id="content-header">
	    <h1>关联科目</h1>
	 </div>
	 <div class="widget-box">
          <div class="widget-content ">
            <table class="table table-striped with-check data-table">
              <thead>
                <tr>
                  <th><input type="checkbox" id="title-table-checkbox" name="title-table-checkbox" /></th>
                  <th>科目代码</th>
                  <th>科目名称</th>
                  <th>科目内容</th>
                  <th>状态</th>
                </tr>
              </thead>
              <tbody>
                 <c:forEach items="${subjects }" var="vo">
                 	<tr>
                 	<td><c:if test="${vo.lessonid ==1}" ><input type="checkbox" value="${vo.subjectNo }" name="roellist"/></c:if></td>
                 	<td>${vo.subjectCode}</td>
                 	<td>${vo.subjectName}</td>
                 	<td>${vo.classContent}</td>
                 	<td>${vo.lessonid =="1" ? "无" :"已关联"}</td>
                 	</tr>
                 </c:forEach>
                 <tr>
                 	<td colspan="3" style="text-align: center;"> <button class="btn btn-primary btn-large" id="btn-relevance">关联已经选中的角色</button></td>
                 	<td colspan="3" style="text-align: center;"> <a href="${pageContext.request.contextPath}/product/norelevance.action"><button class="btn btn-primary">取消所有已关联的</button></a></td>
                 </tr>
              </tbody>
            </table>
          </div>
        </div>
</div>
