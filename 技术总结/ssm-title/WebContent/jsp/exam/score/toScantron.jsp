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
        	<form action="${pageContext.request.contextPath }/examination/seeScantron.action" method="POST" class="form-horizontal">
        		<div class="control-group">
	              <label class="control-label">考试编号:</label>
	             	<input type="text" class="span11" name="examinationno"/>
	              <div class="controls">
	              </div>
            	</div>
	            <div class="control-group">
	              <div class="controls">
	                <input type="submit" class="btn btn-success" value="Save">
	              </div>
	            </div>
        	</form>
        </div>
	</div>
</div>