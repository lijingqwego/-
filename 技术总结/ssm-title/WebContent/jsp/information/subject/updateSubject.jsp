<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/subject/updateSubject.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="#" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">科目编码 :</label>
              <input type="hidden" id="subjectNo" value="${subject.subjectNo }" />
              <div class="controls">
                <input type="text" class="span11" id="subjectCode" value="${subject.subjectCode }"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">科目名称:</label>
              <div class="controls">
                <input type="text" class="span11" id="subjectName" value="${subject.subjectName }" />
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">科目内容:</label>
              <div class="controls">
                <input type="text" class="span11" id="classContent" value="${subject.classContent }" />
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">科目目标:</label>
              <div class="controls">
                <input type="text" class="span11" id="classTarget" value="${subject.classTarget}" />
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">科时:</label>
              <div class="controls">
                <input type="number" class="span11" id="classHour" value="${subject.classHour}" />
              </div>
            </div>
            <div class="control-group">
              <div class="controls">
                <input type="button" class="btn btn-success" value="Save" id="btn-update">
              </div>
            </div>
          </form>
        </div>
      </div>
      </div>