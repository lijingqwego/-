???prompt PL/SQL Developer import file
prompt Created on 2017年9月11日 by Administrator
set feedback off
set define off
prompt Disabling triggers for T_SUBJECT_INFO...
alter table T_SUBJECT_INFO disable all triggers;
prompt Deleting T_SUBJECT_INFO...
delete from T_SUBJECT_INFO;
commit;
prompt Loading T_SUBJECT_INFO...
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1001, 'JAVA', 'JAVASE', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100101, 'JAVA', '第一章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100102, 'JAVA', '第二章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100103, 'JAVA', '第三章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100104, 'JAVA', '第四章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100105, 'JAVA', '第五章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100106, 'JAVA', '第六章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100107, 'JAVA', '第七章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100108, 'JAVA', '第八章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100109, 'JAVA', '第九章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100110, 'JAVA', '第十章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100111, 'JAVA', '第十一章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100112, 'JAVA', '第十二章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100113, 'JAVA', '第十三章', null, null, 10, 1001, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1002, 'JAVAWEB', 'JAVAWEB', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100201, 'HTML', 'HTML', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100202, 'CSS', 'CSS', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100203, 'JavaScript', 'JavaScript', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100204, 'JSP', 'JSP', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100205, 'Servlet', 'Servlet', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100206, 'Jquery', 'Jquery', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100207, 'Ajax', 'Ajax', 'shi笨蛋', null, 10, 1002, null, to_date('29-08-2017 16:42:46', 'dd-mm-yyyy hh24:mi:ss'), '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100208, 'AngularJS', 'AngularJS', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100209, 'JSON', 'JSON', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100210, 'Bootstrap', 'Bootstrap', null, null, 10, 1002, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1003, 'DB', '数据库', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100301, 'ORACLE', 'ORACLE', null, null, 10, 1003, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100302, 'MYSQL', 'MYSQL', null, null, 10, 1003, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100303, 'SQLServer', 'SQLServer', null, null, 10, 1003, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100401, 'Spring', 'Spring', null, null, 10, 1004, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100402, 'SpringMVC', 'SpringMVC', null, null, 10, 1004, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100403, 'MyBatis', 'MyBatis', null, null, 10, 1004, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100404, 'Struts2', 'Struts2', null, null, 10, 1004, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100405, 'Hibernate', 'Hibernate', null, null, 10, 1004, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100406, 'TiTls', 'TiTls', null, null, 10, 1004, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1005, 'J2EE', 'J2EE技术', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100501, 'JPA', 'JPA', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100502, 'JDBC', 'JDBC', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100503, 'EJB', 'EJB', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100504, 'WebService', 'WebService', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100505, 'JNDI', 'JNDI', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100506, 'UML', 'UML', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100507, 'Log4j', 'Log4j', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100508, 'XML', 'XML', null, null, 10, 1005, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1006, '中间件服务器', '中间件服务器', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100601, 'Tomcat', 'Tomcat', null, null, 10, 1006, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100602, 'Jboos', 'Jboos', null, null, 10, 1006, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100603, 'WebLogic', 'WebLogic', null, null, 10, 1006, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100604, 'WebSphere', 'WebSphere', null, null, 10, 1006, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1007, 'ProjectManege', '项目管理与构建', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100701, 'VSS', 'VSS', null, null, 10, 1007, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1008, '软件开发', '软件开发', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100801, '软件开发流程', '软件开发流程', null, null, 10, 1008, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100802, '需求管理', '需求管理', null, null, 10, 1008, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1009, '综合课程', '综合课程', null, null, 10, 10, null, null, '2');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (100901, '职业素养培训', '职业素养培训', null, null, 10, 1009, null, null, '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (10, 'JAVA', 'java课程', null, null, 100, 0, null, null, '1');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (1, 'java', 'bushi我的', '你的吗', null, 20, 10010, to_date('29-08-2017 16:46:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('29-08-2017 16:46:23', 'dd-mm-yyyy hh24:mi:ss'), '3');
insert into T_SUBJECT_INFO (subject_no, subject_code, subject_name, class_content, class_target, class_hour, father_subject, create_time, update_time, subject_order)
values (5, 'JAVAWEB', 'javaweb项目', '网站类项目', '开发知名网站', 20, 0, to_date('07-09-2017 11:24:23', 'dd-mm-yyyy hh24:mi:ss'), to_date('07-09-2017 11:24:23', 'dd-mm-yyyy hh24:mi:ss'), '1');
commit;
prompt 59 records loaded
prompt Enabling triggers for T_SUBJECT_INFO...
alter table T_SUBJECT_INFO enable all triggers;
set feedback on
set define on
prompt Done.
