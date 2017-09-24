-----------------------------------------------------
-- Export file for user HUIJIQUANXIAN@ORCL         --
-- Created by Administrator on 2017/9/11, 15:56:07 --
-----------------------------------------------------

set define off
spool exam_authority.log

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


spool off
