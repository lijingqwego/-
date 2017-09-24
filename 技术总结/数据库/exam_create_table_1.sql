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
  is 'Ȩ�ޱ�';
comment on column P_UM_AUTHORITY.authorityid
  is 'Ȩ������';
comment on column P_UM_AUTHORITY.authorityname
  is 'Ȩ������';
comment on column P_UM_AUTHORITY.descn
  is 'Ȩ��˵��';
comment on column P_UM_AUTHORITY.function
  is '1:���ӡ�2:ɾ����3:�޸ġ�4:�鿴��5:��Ȩ';
comment on column P_UM_AUTHORITY.code
  is 'Ȩ�ޱ��룺����ģ����룫��ģ����룫�������� ����ɣ�';
comment on column P_UM_AUTHORITY.functionname
  is 'Ȩ�޲�������';
comment on column P_UM_AUTHORITY.enabled
  is '�Ƿ񱻽��ã�0����1������';
comment on column P_UM_AUTHORITY.issys
  is '�Ƿ��ǳ���Ȩ�ޣ�0��1�ǣ�';
comment on column P_UM_AUTHORITY.flaginfo
  is '��־��Ϣ';
comment on column P_UM_AUTHORITY.create_time
  is '����ʱ��';
comment on column P_UM_AUTHORITY.update_time
  is '�޸�ʱ��';
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
  is '��Դ��';
comment on column P_UM_RESOURCES.resource_id
  is '��Դid';
comment on column P_UM_RESOURCES.resource_name
  is '��Դ����';
comment on column P_UM_RESOURCES.resource_type
  is '��Դ���ͣ�url��method��';
comment on column P_UM_RESOURCES.priority
  is '��Դ����Ȩ(������)';
comment on column P_UM_RESOURCES.resource_url
  is '��Դ����(URL)';
comment on column P_UM_RESOURCES.resource_dec
  is '��Դ����';
comment on column P_UM_RESOURCES.enabled
  is '�Ƿ񱻽���(0����1����)';
comment on column P_UM_RESOURCES.create_time
  is '����ʱ��';
comment on column P_UM_RESOURCES.update_time
  is '�޸�ʱ��';
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
  is 'Ȩ����Դ������';
comment on column P_UM_AUTHORITY_RESOURCE.authorityid
  is 'Ȩ������';
comment on column P_UM_AUTHORITY_RESOURCE.resource_id
  is '��Դid';
comment on column P_UM_AUTHORITY_RESOURCE.flaginfo
  is '��־��Ϣ';
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
  is '��ɫ��';
comment on column P_UM_ROLE.roleid
  is '��ɫ����';
comment on column P_UM_ROLE.rolename
  is '��ɫ����';
comment on column P_UM_ROLE.descn
  is '��ɫ˵��';
comment on column P_UM_ROLE.code
  is '��ɫ����';
comment on column P_UM_ROLE.flaginfo
  is '��־��Ϣ';
comment on column P_UM_ROLE.sort
  is '��ɫ����';
comment on column P_UM_ROLE.enabled
  is '�Ƿ񱻽��ã�0����1������';
comment on column P_UM_ROLE.create_time
  is '����ʱ��';
comment on column P_UM_ROLE.update_time
  is '�޸�ʱ��';
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
  is '��ɫȨ�޹�����';
comment on column P_UM_ROLE_AUTHORITY.roleid
  is '��ɫ����';
comment on column P_UM_ROLE_AUTHORITY.authorityid
  is 'Ȩ������';
comment on column P_UM_ROLE_AUTHORITY.flaginfo
  is '��־��Ϣ';
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
  is '�û���';
comment on column P_UM_USER.userid
  is '�û�����';
comment on column P_UM_USER.loginid
  is '��¼�ʺ�';
comment on column P_UM_USER.username
  is '�û�����';
comment on column P_UM_USER.password
  is '����';
comment on column P_UM_USER.usertype
  is '�û�����';
comment on column P_UM_USER.userflag
  is '�Ƿ���Ч��1������Ч�� 0������Ч�� Ĭ����Ч��';
comment on column P_UM_USER.logincount
  is '��¼����';
comment on column P_UM_USER.enabled
  is '�Ƿ񱻽��ã�0����1������';
comment on column P_UM_USER.loginlasttime
  is '���һ�ε�¼ʱ��';
comment on column P_UM_USER.issys
  is '�Ƿ񳬼��û���0��1�ǣ�';
comment on column P_UM_USER.create_time
  is '����ʱ��';
comment on column P_UM_USER.update_time
  is '�޸�ʱ��';
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
  is '�û���ɫ������';
comment on column P_UM_USER_ROLE.userid
  is '�û�����';
comment on column P_UM_USER_ROLE.roleid
  is '��ɫ����';
comment on column P_UM_USER_ROLE.flaginfo
  is '��־��Ϣ';
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
  is '�༶ID';
comment on column T_CLASS_INFO.lesson_id
  is '�γ̱��';
comment on column T_CLASS_INFO.class_code
  is '�༶���';
comment on column T_CLASS_INFO.class_name
  is '�༶����';
comment on column T_CLASS_INFO.student_count
  is 'ѧ������';
comment on column T_CLASS_INFO.teacher
  is '��ʦ����ʦ��ţ�';
comment on column T_CLASS_INFO.headmaster
  is '�����Σ���ʦ��ţ�';
comment on column T_CLASS_INFO.monitor
  is '�೤(ѧ��ѧ��)';
comment on column T_CLASS_INFO.startdate
  is '��������';
comment on column T_CLASS_INFO.enddate
  is '��ҵ����';
comment on column T_CLASS_INFO.create_time
  is '����ʱ��';
comment on column T_CLASS_INFO.update_time
  is '�޸�ʱ��';
alter table T_CLASS_INFO
  add constraint PK_T_CLASS_INFO primary key (CLASS_ID);
alter table T_CLASS_INFO
  add constraint FK_T_CLASS_REFERENCE_T_LESSON foreign key (LESSON_ID)
  references T_LESSON_PRODUCT_INFO (LESSON_ID);


spool off
