<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.from.js"></script>
<script src="${pageContext.request.contextPath }/js/subject/insertSubject.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="#" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">科目编码 :</label>
              <div class="controls">
                <input type="text" class="span11" id="subjectCode"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">科目名称:</label>
              <div class="controls">
                <input type="text" class="span11" id="subjectName" />
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">科目内容:</label>
              <div class="controls">
                <input type="text" class="span11" id="classContent"/>
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">科目目标:</label>
              <div class="controls">
                <input type="text" class="span11" id="classTarget" />
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">科时:</label>
              <div class="controls">
                <input type="number" class="span11" id="classHour"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">级别:</label>
              <div class="controls" >
                <select id="subjectOrder">
                  <option value="1" selected="selected" >一级目录</option>
                  <option value="2">二级目录</option>
                  <option value="3" >三级目录</option>
                </select>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">父级编码:</label>
              <div class="controls">
	           	  <div style="width:120px;display:inline-block;" id="div1">
		              <select id="select-mune1">
		                <option value="-1" selected="selected">无</option>
		                <option value="0" >根基级菜单</option>
		              </select>
		          </div>
	              <div style="width:120px;display:inline-block;" id="div2">
		              <select id="select-mune2">
		                <option value="-1" selected="selected">一级菜单</option>
		              </select>
	             </div>
	             <div style="width:120px;display:inline-block;" id="div3">
			          <select id="select-mune3">
			            <option value="-1" selected="selected">二级菜单</option>
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