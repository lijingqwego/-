???prompt PL/SQL Developer import file
prompt Created on 2017年9月11日 by Administrator
set feedback off
set define off
prompt Disabling triggers for P_UM_ROLE...
alter table P_UM_ROLE disable all triggers;
prompt Deleting P_UM_ROLE...
delete from P_UM_ROLE;
commit;
prompt Loading P_UM_ROLE...
insert into P_UM_ROLE (roleid, rolename, descn, code, flaginfo, sort, enabled, create_time, update_time)
values ('20001', '校长大人', '最高级的管理员，可以拥有所有的权限', 'manage', '1', null, 1, null, null);
insert into P_UM_ROLE (roleid, rolename, descn, code, flaginfo, sort, enabled, create_time, update_time)
values ('30001', '教师', '负责自己课程分配学生的教学工作', 'teacher', '1', null, 1, null, null);
insert into P_UM_ROLE (roleid, rolename, descn, code, flaginfo, sort, enabled, create_time, update_time)
values ('40001', '学生', '十年树木，百年树人，一个小树苗总会成长到替你撑起一片天空', 'student', '1', null, 1, null, null);
insert into P_UM_ROLE (roleid, rolename, descn, code, flaginfo, sort, enabled, create_time, update_time)
values ('10001', '基础角色', '最基础的角色，只是表明是这个项目的一个个体', 'user', '1', null, 1, null, null);
insert into P_UM_ROLE (roleid, rolename, descn, code, flaginfo, sort, enabled, create_time, update_time)
values ('50001', '题库管理者', '题库管理者', 'textpage', '1', null, 1, null, null);
insert into P_UM_ROLE (roleid, rolename, descn, code, flaginfo, sort, enabled, create_time, update_time)
values ('60001', '试卷批改者', '批改试卷', 'exampage', '1', null, 1, null, null);
insert into P_UM_ROLE (roleid, rolename, descn, code, flaginfo, sort, enabled, create_time, update_time)
values ('70001', '人事部', '负责学生课程安排，班级分配', 'personnel', '1', null, 1, null, null);
commit;
prompt 7 records loaded
prompt Enabling triggers for P_UM_ROLE...
alter table P_UM_ROLE enable all triggers;
set feedback on
set define on
prompt Done.
