-----------------------------------------------------
-- Export file for user HUIJIQUANXIAN@ORCL         --
-- Created by Administrator on 2017/9/11, 15:58:14 --
-----------------------------------------------------

set define off
spool exam_create_table_1.log

prompt
prompt Creating table P_UM_AUTHORITY
prompt =============================
prompt
create table P_UM_AUTHORITY
(
  authorityid   VARCHAR2(36) not null,
  authorityname VARCHAR2(100) not null,
  descn         VARCHAR2(500),
  function      VARCHAR2(50),
  code          VARCHAR2(50),
  functionname  VARCHAR2(50),
  enabled       INTEGER default 1,
  issys         INTEGER default 0,
  flaginfo      VARCHAR2(20) default 1,
  create_time   DATE,
  update_time   DATE
)
;
comment on table P_UM_AUTHORITY
  is '权限表';
comment on column P_UM_AUTHORITY.authorityid
  is '权限主键';
comment on column P_UM_AUTHORITY.authorityname
  is '权限名称';
comment on column P_UM_AUTHORITY.descn
  is '权限说明';
comment on column P_UM_AUTHORITY.function
  is '1:增加、2:删除、3:修改、4:查看、5:授权';
comment on column P_UM_AUTHORITY.code
  is '权限编码：由主模块编码＋子模块编码＋操作编码 所组成）';
comment on column P_UM_AUTHORITY.functionname
  is '权限操作名称';
comment on column P_UM_AUTHORITY.enabled
  is '是否被禁用（0禁用1正常）';
comment on column P_UM_AUTHORITY.issys
  is '是否是超级权限（0非1是）';
comment on column P_UM_AUTHORITY.flaginfo
  is '标志信息';
comment on column P_UM_AUTHORITY.create_time
  is '创建时间';
comment on column P_UM_AUTHORITY.update_time
  is '修改时间';
alter table P_UM_AUTHORITY
  add constraint PK_P_UM_AUTHORITY primary key (AUTHORITYID);

prompt
prompt Creating table P_UM_RESOURCES
prompt =============================
prompt
create table P_UM_RESOURCES
(
  resource_id   VARCHAR2(36) not null,
  resource_name VARCHAR2(100),
  resource_type VARCHAR2(50),
  priority      INTEGER,
  resource_url  VARCHAR2(200),
  resource_dec  VARCHAR2(200),
  enabled       INTEGER default 1,
  create_time   DATE,
  update_time   DATE
)
;
comment on table P_UM_RESOURCES
  is '资源表';
comment on column P_UM_RESOURCES.resource_id
  is '资源id';
comment on column P_UM_RESOURCES.resource_name
  is '资源名称';
comment on column P_UM_RESOURCES.resource_type
  is '资源类型（url、method）';
comment on column P_UM_RESOURCES.priority
  is '资源优先权(即排序)';
comment on column P_UM_RESOURCES.resource_url
  is '资源链接(URL)';
comment on column P_UM_RESOURCES.resource_dec
  is '资源描述';
comment on column P_UM_RESOURCES.enabled
  is '是否被禁用(0禁用1正常)';
comment on column P_UM_RESOURCES.create_time
  is '创建时间';
comment on column P_UM_RESOURCES.update_time
  is '修改时间';
alter table P_UM_RESOURCES
  add constraint PK_P_UM_RESOURCES primary key (RESOURCE_ID);

prompt
prompt Creating table P_UM_AUTHORITY_RESOURCE
prompt ======================================
prompt
create table P_UM_AUTHORITY_RESOURCE
(
  authorityid VARCHAR2(36),
  resource_id VARCHAR2(36),
  flaginfo    VARCHAR2(20) default '1'
)
;
comment on table P_UM_AUTHORITY_RESOURCE
  is '权限资源关联表';
comment on column P_UM_AUTHORITY_RESOURCE.authorityid
  is '权限主键';
comment on column P_UM_AUTHORITY_RESOURCE.resource_id
  is '资源id';
comment on column P_UM_AUTHORITY_RESOURCE.flaginfo
  is '标志信息';
alter table P_UM_AUTHORITY_RESOURCE
  add constraint IND_AUTHORITY_RESOURCES_UNIQUE unique (AUTHORITYID, RESOURCE_ID);
alter table P_UM_AUTHORITY_RESOURCE
  add constraint FK_P_UM_AUT_REFERENCE_P_UM_AUT foreign key (AUTHORITYID)
  references P_UM_AUTHORITY (AUTHORITYID);
alter table P_UM_AUTHORITY_RESOURCE
  add constraint FK_P_UM_AUT_REFERENCE_P_UM_RES foreign key (RESOURCE_ID)
  references P_UM_RESOURCES (RESOURCE_ID);

prompt
prompt Creating table P_UM_ROLE
prompt ========================
prompt
create table P_UM_ROLE
(
  roleid      VARCHAR2(36) not null,
  rolename    VARCHAR2(100),
  descn       VARCHAR2(255),
  code        VARCHAR2(50),
  flaginfo    VARCHAR2(20) default '1',
  sort        NUMBER,
  enabled     INTEGER default 1,
  create_time DATE,
  update_time DATE
)
;
comment on table P_UM_ROLE
  is '角色表';
comment on column P_UM_ROLE.roleid
  is '角色主键';
comment on column P_UM_ROLE.rolename
  is '角色名称';
comment on column P_UM_ROLE.descn
  is '角色说明';
comment on column P_UM_ROLE.code
  is '角色编码';
comment on column P_UM_ROLE.flaginfo
  is '标志信息';
comment on column P_UM_ROLE.sort
  is '角色排序';
comment on column P_UM_ROLE.enabled
  is '是否被禁用（0禁用1正常）';
comment on column P_UM_ROLE.create_time
  is '创建时间';
comment on column P_UM_ROLE.update_time
  is '修改时间';
alter table P_UM_ROLE
  add constraint PK_P_UM_ROLE primary key (ROLEID);

prompt
prompt Creating table P_UM_ROLE_AUTHORITY
prompt ==================================
prompt
create table P_UM_ROLE_AUTHORITY
(
  roleid      VARCHAR2(36),
  authorityid VARCHAR2(36),
  flaginfo    VARCHAR2(20) default '1'
)
;
comment on table P_UM_ROLE_AUTHORITY
  is '角色权限关联表';
comment on column P_UM_ROLE_AUTHORITY.roleid
  is '角色主键';
comment on column P_UM_ROLE_AUTHORITY.authorityid
  is '权限主键';
comment on column P_UM_ROLE_AUTHORITY.flaginfo
  is '标志信息';
alter table P_UM_ROLE_AUTHORITY
  add constraint IND_ROLE_AUTHORITY_UNIQUE unique (ROLEID, AUTHORITYID);
alter table P_UM_ROLE_AUTHORITY
  add constraint FK_P_UM_ROL_REFERENCE_P_UM_AUT foreign key (AUTHORITYID)
  references P_UM_AUTHORITY (AUTHORITYID);
alter table P_UM_ROLE_AUTHORITY
  add constraint FK_P_UM_ROL_REFERENCE_P_UM_ROL foreign key (ROLEID)
  references P_UM_ROLE (ROLEID);

prompt
prompt Creating table P_UM_USER
prompt ========================
prompt
create table P_UM_USER
(
  userid        VARCHAR2(36) not null,
  loginid       VARCHAR2(50) not null,
  username      VARCHAR2(50),
  password      VARCHAR2(255) not null,
  usertype      INTEGER,
  userflag      INTEGER default 1,
  logincount    INTEGER,
  enabled       INTEGER default 1,
  loginlasttime DATE,
  issys         INTEGER default 0,
  create_time   DATE,
  update_time   DATE
)
;
comment on table P_UM_USER
  is '用户表';
comment on column P_UM_USER.userid
  is '用户主键';
comment on column P_UM_USER.loginid
  is '登录帐号';
comment on column P_UM_USER.username
  is '用户姓名';
comment on column P_UM_USER.password
  is '密码';
comment on column P_UM_USER.usertype
  is '用户类型';
comment on column P_UM_USER.userflag
  is '是否有效（1代表有效， 0代表无效， 默认有效）';
comment on column P_UM_USER.logincount
  is '登录次数';
comment on column P_UM_USER.enabled
  is '是否被禁用（0禁用1正常）';
comment on column P_UM_USER.loginlasttime
  is '最后一次登录时间';
comment on column P_UM_USER.issys
  is '是否超级用户（0非1是）';
comment on column P_UM_USER.create_time
  is '创建时间';
comment on column P_UM_USER.update_time
  is '修改时间';
alter table P_UM_USER
  add constraint PK_P_UM_USER primary key (USERID);

prompt
prompt Creating table P_UM_USER_ROLE
prompt =============================
prompt
create table P_UM_USER_ROLE
(
  userid   VARCHAR2(36) not null,
  roleid   VARCHAR2(36) not null,
  flaginfo VARCHAR2(20) default '1'
)
;
comment on table P_UM_USER_ROLE
  is '用户角色关联表';
comment on column P_UM_USER_ROLE.userid
  is '用户主键';
comment on column P_UM_USER_ROLE.roleid
  is '角色主键';
comment on column P_UM_USER_ROLE.flaginfo
  is '标志信息';
alter table P_UM_USER_ROLE
  add constraint IND_ROLE_USER_UNIQUE unique (USERID, ROLEID);
alter table P_UM_USER_ROLE
  add constraint FK_P_UM_USE_REFERENCE_P_UM_ROL foreign key (ROLEID)
  references P_UM_ROLE (ROLEID);
alter table P_UM_USER_ROLE
  add constraint FK_P_UM_USE_REFERENCE_P_UM_USE foreign key (USERID)
  references P_UM_USER (USERID);

prompt
prompt Creating table T_CLASS_INFO
prompt ===========================
prompt
create table T_CLASS_INFO
(
  class_id      VARCHAR2(36) not null,
  lesson_id     VARCHAR2(36),
  class_code    VARCHAR2(20) not null,
  class_name    VARCHAR2(36) not null,
  student_count INTEGER,
  teacher       VARCHAR2(36),
  headmaster    VARCHAR2(36),
  monitor       VARCHAR2(36),
  startdate     DATE,
  enddate       DATE,
  create_time   DATE,
  update_time   DATE
)
;
comment on column T_CLASS_INFO.class_id
  is '班级ID';
comment on column T_CLASS_INFO.lesson_id
  is '课程编号';
comment on column T_CLASS_INFO.class_code
  is '班级编号';
comment on column T_CLASS_INFO.class_name
  is '班级名称';
comment on column T_CLASS_INFO.student_count
  is '学生数量';
comment on column T_CLASS_INFO.teacher
  is '老师（老师编号）';
comment on column T_CLASS_INFO.headmaster
  is '班主任（老师编号）';
comment on column T_CLASS_INFO.monitor
  is '班长(学生学号)';
comment on column T_CLASS_INFO.startdate
  is '开班日期';
comment on column T_CLASS_INFO.enddate
  is '结业日期';
comment on column T_CLASS_INFO.create_time
  is '创建时间';
comment on column T_CLASS_INFO.update_time
  is '修改时间';
alter table T_CLASS_INFO
  add constraint PK_T_CLASS_INFO primary key (CLASS_ID);
alter table T_CLASS_INFO
  add constraint FK_T_CLASS_REFERENCE_T_LESSON foreign key (LESSON_ID)
  references T_LESSON_PRODUCT_INFO (LESSON_ID);


spool off
