<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.from.js"></script>
<script src="${pageContext.request.contextPath }/js/page/insertPage.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="#" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">试卷名称 :</label>
              <div class="controls">
                <input type="text" class="span11" id="examinationName"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">试卷类型:</label>
              <div class="controls">
                 <select id="examinationType">
                  <option value="2" selected="selected">综合测试</option>
                  <option value="1">单元测试</option>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">试卷描述:</label>
              <div class="controls">
                <input type="text" class="span11" id="examinationContent"/>
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
		        <div style="width: 120px;display: inline-block;margin-left: 20px;">
		              <select id="select-mune2">
		                <option value="-1" selected="selected">二级菜单</option>
		              </select>
		        </div>
		        <div style="width:120px;display:inline-block;margin-left: 20px;" id="div-mune3">
		          <select id="select-mune3">
		            <option value="-1" selected="selected">三级菜单</option>
		          </select>
		        </div>
		     </div>
            </div>
            <div class="control-group">
              <label class="control-label">考试时间:</label>
              <div class="controls">
                <select id="examLength">
                  <option value="30" selected="selected">30分钟</option>
                  <option value="45">45分钟</option>
                  <option value="60">60分钟</option>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">单选题个数:</label>
              <div class="controls">
                <input type="number" class="span11" id="singln" value="1"/>
                <span class="badge badge-warning">4分</span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">多选题个数:</label>
              <div class="controls">
                <input type="number" class="span11" id="multil" value="1"/>
                <span class="badge badge-important">5分</span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">判断题个数:</label>
              <div class="controls">
                <input type="number" class="span11" id="decide" value="1"/>
                <span class="badge badge-success">2分</span>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">总分:</label>
              <div class="controls">
                <span class="badge badge-success" id="span1">2分</span>
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