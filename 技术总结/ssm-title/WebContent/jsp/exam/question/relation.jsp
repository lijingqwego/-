<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/question/relation.js"></script> 
<div id="content">
	<div id="content-header">
	    <h1>题目归库</h1>
	    <div style="width:120px;display: inline-block;">
             <select id="select-mune1">
               <option value="-1" selected="selected">一级菜单</option>
               <c:forEach items="${listmune }" var="vo">
                	<option value="${vo.subjectNo}">${vo.subjectName}</option>
                </c:forEach>
             </select>
		</div>
        <div style="width:120px;display: inline-block;">
	         <select id="select-mune2">
	           <option value="-1" selected="selected">二级菜单</option>
	         </select>
        </div>
        <div style="width:120px;display: inline-block;">
		       <select id="select-mune3">
		         <option value="-1" selected="selected">三级菜单</option>
		       </select>
        </div>
         <div style="width:120px;display:inline-block;">
              <label class="control-label">此次题库名称:</label>
        	  <input type="text" id="questionsname" maxlength="50">
        </div>
        <div style="width:120px;display:inline-block;">
		    <label>此次题库描述:</label>
        	<input type="text" id="questionsdesc" maxlength="100">
        </div>
	 </div>
	 <div class="widget-box" style="margin-top: 50px;">
          <div class="widget-content ">
            <table class="table table-bordered table-striped with-check">
              <thead>
                <tr>
                  <th><input type="checkbox" id="title-table-checkbox" name="title-table-checkbox" /></th>
                  <th>题目内容</th>
                  <th>题目类型</th>
                  <th>状态</th>
                </tr>
              </thead>
              <tbody>
                 <c:forEach items="${relationlist }" var="vo">
                 	<tr>
                 	<td><input type="checkbox" value="${vo.questionNo }" name="roellist"/></td>
                 	<td>${vo.questionName}</td>
                 	<td>${vo.questionType}（1：单选，2：多选，3判断）</td>
                 	<td>未分配</td>
                 	</tr>
                 </c:forEach>
                 <tr>
                 	<td colspan="3" style="text-align: center;"> <button class="btn btn-primary btn-large" id="btn-relevance">分配已经选中的题目</button></td>
                 </tr>
              </tbody>
            </table>
          </div>
        </div>
</div>
