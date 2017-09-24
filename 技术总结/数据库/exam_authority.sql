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


spool off
