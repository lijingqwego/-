<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.from.js"></script>
<script src="${pageContext.request.contextPath }/js/exam/toTest.js"></script>
<div id="content">
	<div class="widget-box">
		<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>参加考试选择考试科目</h5>
        </div>
        <div class="widget-content nopadding">
        	<form action="#" method="POST" class="form-horizontal" id="updateform">
        		<div class="control-group">
	              <label class="control-label">考试类型:</label>
	              <div class="controls">
	                 <select id="examinationType">
	                  <option value="2" selected="selected">综合测试</option>
	                  <option value="1" >单元测试</option>
	                </select>
	              </div>
            	</div>
            	<div class="control-group">
	              <label class="control-label">考试科目:</label>
	              <div class="controls">
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
			        <div style="width:120px;display: inline-block;" id="div-mune3">
			          <select id="select-mune3">
			            <option value="-1" selected="selected">三级菜单</option>
			          </select>
			        </div>
            	  </div>
            	</div>
	            <div class="control-group">
	              <div class="controls">
	                <input type="button" class="btn btn-success" value="Save" id="btn-insert">
	              </div>
	            </div>
        	</form>
        </div>
	</div>
</div>