<%@ page language="java" pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery-form.js"></script>
<script src="${pageContext.request.contextPath }/js/product/updateProduct.js"></script>
<div id="content">
	<div class="widget-box">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>Personal-info</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="${pageContext.request.contextPath }/product/updateProduct.action" method="POST" class="form-horizontal" id="updateform">
            <div class="control-group">
              <label class="control-label">课程编码 :</label>
              <input type="hidden" id="lessonId" value="${product.lessonId }" />
              <div class="controls">
                <input type="text" class="span11" id="lessonCode" value="${product.lessonCode }"/>
              </div>
            </div>
            <div class="control-group">
              <label class="control-label">课程名称:</label>
              <div class="controls">
                <input type="text" class="span11" id="lessonName" value="${product.lessonName }" />
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">课程描述:</label>
              <div class="controls">
                <textarea rows="4" cols="20" id="lessonContent" maxlength="90" >${product.lessonContent }</textarea>
              </div>
            </div>
             <div class="control-group">
              <label class="control-label">课程周期:</label>
              <div class="controls">
                <input type="number" class="span11" id="lessonCycle" value="${product.lessonCycle }" />
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