<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/question/insertquestion.js"></script>
<div id="content">
	<div class="widget-box">
		 <div style="width:300px;margin-left: 150px;margin-top: 50px;">
		 	<div style="width:100px;display:inline-block;">
	        <label class="control-label">添加方式</label>
	        </div>
	        <div style="width:300px;display:inline-block;">
              <select id="select-div">
                <option value="1" selected="selected">页面添加</option>
                <option value="2">excl导入添加</option>
              </select>
	        </div>
	    </div>
		<div id="div-excl">
	        <div style="margin-top: 50px;margin-left: 100px;margin-bottom:150px ;display:inline-block;">
	          <form action="${pageContext.request.contextPath}/question/inputQuestions.action" Method="post" enctype="multipart/form-data">
	              <div>
		              <div style="width:100px;display:inline-block;">
		              <label class="control-label">试题导入 :</label>
		              </div>
		              <div style="width:100px;display:inline-block;">
		                <input type="file" class="span11" id="fileexl" name="file" />
		              </div>
		              <div style="width:100px;display:inline-block;margin-left:150px;">
	             	  <label class="control-label"><input type="submit" class="btn btn-success" value="input" id="btn-input"></label>
	                  </div>
	            </div>
	          </form>
	        </div>
	        <div style="margin-top: 50px;display:inline-block;">
	         <a href="${pageContext.request.contextPath}/question/downloadExcel.action"><button class="btn btn-primary" id="output">模板下载</button></a>
	        </div>
	    </div>
	    <div id="div-select">
	       <div style="margin-top: 50px;margin-left: 100px;">
		  		<div style="width:100px;display:inline-block;text-align:center;">
	            <label class="control-label">选择题型</label>
	            </div>
	            <div style="width:300px;display:inline-block;">
	              <select id="select-question">
	                <option value="1" selected="selected">单选题</option>
	                <option value="2">多选题</option>
	                <option value="3">判断题</option>
	              </select>
	            </div>
		    </div>
	       <div class="widget-content nopadding" id="div-singln">
	         <form action="#" method="POST" class="form-horizontal" id="singlnform">
	           <div class="control-group">
	             <label class="control-label">题目内容:</label>
	             <div class="controls">
	              <textarea rows="3" cols="40" id="singlnName" maxlength="500"></textarea>
	             </div>
	           </div>
	           <div class="control-group">
	             <label class="control-label">选项一:</label>
	             <div class="controls">
	               <input type="text" class="span11" id="anwerone" maxlength="200" />
	             </div>
	           </div>
	           <div class="control-group">
	             <label class="control-label">选项二:</label>
	             <div class="controls">
	               <input type="text" class="span11" id="anwertwo" maxlength="200" />
	             </div>
	           </div>
	           <div class="control-group">
	             <label class="control-label">选项三:</label>
	             <div class="controls">
	               <input type="text" class="span11" id="anwerthree" maxlength="200" />
	             </div>
	           </div>
	           <div class="control-group">
	             <label class="control-label">选项四:</label>
	             <div class="controls">
	               <input type="text" class="span11" id="anwerfour" maxlength="200" />
	             </div>
	           </div>
	           <div class="control-group">
	             <label class="control-label">正确答案</label>
	             <div class="controls">
	               <input type="text" class="span11" id="singlnkey" maxlength="10" />
	             </div>
	           </div>
	           <div class="control-group">
	             <div class="controls">
	               <input type="button" class="btn btn-success" value="Save" id="btn-singln">
	             </div>
	           </div>
	         </form>
	       </div>
	       <div class="widget-content nopadding" style="dispaly:none" id="div-decide">
         <form action="#" method="POST" class="form-horizontal" id="decideform">
           <div class="control-group">
             <label class="control-label">题目内容:</label>
             <div class="controls">
             	<textarea rows="3" cols="40" id="decideName" maxlength="500"></textarea>
             </div>
           </div>
           <div class="control-group">
             <label class="control-label">题目答案:</label>
             <div class="controls">
               <input type="text" class="span11" maxlength="20" id="decideKey" />
             </div>
           </div>
           <div class="control-group">
	           	 <div class="controls">
	               <input type="button" class="btn btn-success" value="Save" id="btn-decide">
	             </div>
           </div>
         </form>
       </div>
        </div>
  </div>
</div>