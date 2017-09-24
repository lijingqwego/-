???prompt PL/SQL Developer import file
prompt Created on 2017年9月11日 by Administrator
set feedback off
set define off
prompt Disabling triggers for P_UM_AUTHORITY...
alter table P_UM_AUTHORITY disable all triggers;
prompt Deleting P_UM_AUTHORITY...
delete from P_UM_AUTHORITY;
commit;
prompt Loading P_UM_AUTHORITY...
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10012', '账号管理', '管理用户信息并分配角色', null, 'ROLE_ACCOUNT', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10013', '试题入库', '分配试题到科目中', null, 'ROLE_BANK', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10014', '科目管理', '管理科目', null, 'ROLE_SUBJECT', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10001', '基础用户', '用于登录以及进入系统修改个人信息', '待你君临天下，怕是为笼囚花。', 'ROLE_USER', '帝王', 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10002', '角色管理', '用于管理角色表，并允许分配权限', '待你功成名达，怀中人富贵家。', 'ROLE_ROLE', '书生', 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10003', '权限管理', '用于查看权限表只允许查看以及修改备注', '待你名满华夏，已无相安年华。', 'ROLE_AUTHORITY', '侠客', 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10004', '参加考试', '用户学生参加考试，挑选试卷并做题', '待你青丝绾正,铺十里红妆可愿', 'ROLE_EXAM', '少女', 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10005', '定制试卷', '为相关科目准备定制试卷', '我也没法确定智能', 'ROLE_PAGE', '灭绝师太', 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10006', '添加试题', '用于对试题库的管理', null, 'ROLE_QUESTION', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10007', '课程管理', '用户课程的管理，并对学生安排课程', null, 'ROLE_PRODUCT', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10008', '班级管理', '用于开设班级管理，并对学生分班和教师分配', null, 'ROLE_CLASS', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10009', '学生信息管理', '学生信息以及给学生安排课程', null, 'ROLE_STUDENT', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10010', '教师管理', '管理教师职员信息', null, 'ROLE_TEACHER', null, 1, 0, '1', null, null);
insert into P_UM_AUTHORITY (authorityid, authorityname, descn, function, code, functionname, enabled, issys, flaginfo, create_time, update_time)
values ('10011', '考试信息查看', '查看学士考试后的答题记录以及得分', null, 'ROLE_SEE', null, 1, 0, '1', null, null);
commit;
prompt 14 records loaded
prompt Enabling triggers for P_UM_AUTHORITY...
alter table P_UM_AUTHORITY enable all triggers;
set feedback on
set define on
prompt Done.
