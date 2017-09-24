<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script> 
<script src="${pageContext.request.contextPath }/js/role/updateRole.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">学生姓名:</label>
              <input type="hidden" name="studentNo" value="${student.studentNo}}" />
              <div class="controls">
                <input type="text" class="span11" name="studentName" value="${student.studentName }" placeholder="学生名称" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 班级:</label>
              <div class="controls">
                <input type="text" class="span11" name="classId" value="${student.classId }" placeholder="班级" />
              </div>
            </div>
            <div class="control-group">
              <label class="control-label"> 课程:</label>
              <div class="controls">
                <input type="text" class="span11" name="descn" value="${student.classId }" placeholder="班级" />
              </div>
            </div>
            <div class="form-actions">
              <button class="btn btn-success" id="btn-update">Save</button>
            </div>
          </form>
        </div>
      </div>
      </div>