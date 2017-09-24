<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="sidebar">
  <ul>
  	<sec:authorize access="hasRole('ROLE_USER')">
	  	<li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>系统设置</span></a>
	      <ul>
	        <li><a href="${pageContext.request.contextPath }/user/toChangePassword.action">修改密码</a></li>
	        <li><a href="${pageContext.request.contextPath }/user/toChangeUser.action">修改昵称</a></li>
	      </ul>
	    </li>
    </sec:authorize>
	<sec:authorize access="hasAnyRole('ROLE_AUTHORITY','ROLE_ACCOUNT','ROLE_ROLE')">
	    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>系统安全管理</span></a>
	      <ul>
	      	<sec:authorize access="hasRole('ROLE_ACCOUNT')">
	        <li><a href="${pageContext.request.contextPath }/account/showAccounts.action">账号管理</a></li>
	        </sec:authorize>
	        <sec:authorize access="hasRole('ROLE_ROLE')">
	        <li><a href="${pageContext.request.contextPath }/role/showRoles.action">角色管理</a></li>
	        </sec:authorize>
	        <sec:authorize access="hasRole('ROLE_AUTHORITY')">
	        <li><a href="${pageContext.request.contextPath }/authority/showAuthority.action">权限查看</a></li>
	        <li><a href="${pageContext.request.contextPath }/resource/showResource.action">资源信息管理</a></li>
	        </sec:authorize>
	      </ul>
	    </li>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_STUDENT','ROLE_TEACHER','ROLE_CLASS','ROLE_PRODUCT','ROLE_TEACHER')">
	    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>教学信息管理</span></a>
	      <ul>
	      	<sec:authorize access="hasRole('ROLE_STUDENT')">
	        <li><a href="${pageContext.request.contextPath }/student/showStudents.action">学生信息管理</a></li>
	        </sec:authorize>
	        <sec:authorize access="hasRole('ROLE_TEACHER')">
	        <li><a href="${pageContext.request.contextPath }/teacher/showTeachers.action">教师信息管理</a></li>
	        </sec:authorize>
	        <sec:authorize access="hasRole('ROLE_CLASS')">
	        <li><a href="${pageContext.request.contextPath }/class/showClasses.action">班级信息管理</a></li>
	        </sec:authorize>
	        <sec:authorize access="hasRole('ROLE_PRODUCT')">
	        <li><a href="${pageContext.request.contextPath }/product/showProducts.action">课程信息管理</a></li>
	        </sec:authorize>
	         <sec:authorize access="hasRole('ROLE_SUBJECT')">
	        <li><a href="${pageContext.request.contextPath }/subject/showSubjects.action">科目信息管理</a></li>
	        </sec:authorize>
	      </ul>
	    </li>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_EXAM','ROLE_SEE')">
	    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>考试模块</span></a>
	      <ul>
	        <sec:authorize access="hasRole('ROLE_EXAM')">
	        <li><a href="${pageContext.request.contextPath }/examtest/totest.action">参加考试</a></li>
	        </sec:authorize>
	       <sec:authorize access="hasRole('ROLE_SEE')">
	        <li><a href="${pageContext.request.contextPath }/examination/toScantron.action">查询考试结果</a></li>
	        </sec:authorize>
	      </ul>
	    </li>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_PAGE','ROLE_QUESTION','ROLE_BANK')">
	    <li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>试卷制作</span></a>
	      <ul>
	       <sec:authorize access="hasRole('ROLE_QUESTION')">
	        <li><a href="${pageContext.request.contextPath }/question/toQuestion.action">题目管理</a></li>
	        </sec:authorize>
	        <sec:authorize access="hasRole('ROLE_BANK')">
	        <li><a href="${pageContext.request.contextPath }/bank/showBank.action">题库管理</a></li>
	        <li><a href="${pageContext.request.contextPath }/bank/relation.action">题目入库</a></li>
	        </sec:authorize>
	         <sec:authorize access="hasRole('ROLE_PAGE')">
	        <li><a href="${pageContext.request.contextPath }/page/showPages.action">查看已有试卷</a></li>
	        </sec:authorize>
	      </ul>
	    </li>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_USER')">
    <li class="submenu"> <a href="#"><i class="icon icon-info-sign"></i> <span>Error</span> <span class="label label-important">4</span></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/example/error403.action">Error 403</a></li>
        <li><a href="${pageContext.request.contextPath }/example/error404.action">Error 404</a></li>
        <li><a href="${pageContext.request.contextPath }/example/error405.action">Error 405</a></li>
        <li><a href="${pageContext.request.contextPath }/example/error500.action">Error 500</a></li>
      </ul>
    </li>
    </sec:authorize>
  	<li class="submenu"> <a href="#"><i class="icon icon-th-list"></i> <span>案列页面</span> <span class="label label-important">8</span></a>
      <ul>
        <li><a href="${pageContext.request.contextPath }/example/table.action">Table</a></li>
        <li><a href="${pageContext.request.contextPath }/example/button_and_icons.action">Buttons & icons</a></li>
        <li><a href="${pageContext.request.contextPath }/example/form_common.action">Form common</a></li>
        <li><a href="${pageContext.request.contextPath }/example/form_validation.action">Form validation</a></li>
        <li><a href="${pageContext.request.contextPath }/example/form_wizard.action">Form wizard</a></li>
        <li><a href="${pageContext.request.contextPath }/example/gridlayout.action">Grid Layout</a></li>
        <li><a href="${pageContext.request.contextPath }/example/index_info.action">Index info</a></li>
        <li><a href="${pageContext.request.contextPath }/example/interface_elements.action">Interface elements</a></li>
      </ul>
    </li>
  </ul>
</div>