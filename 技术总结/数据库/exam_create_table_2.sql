-----------------------------------------------------
-- Export file for user HUIJIQUANXIAN@ORCL         --
-- Created by Administrator on 2017/9/11, 15:59:22 --
-----------------------------------------------------

set define off
spool exam_create_table_2.log

prompt
prompt Creating table T_LESSON_PRODUCT_INFO
prompt ====================================
prompt
create table T_LESSON_PRODUCT_INFO
(
  lesson_id      VARCHAR2(36) not null,
  lesson_code    VARCHAR2(36) not null,
  lesson_name    VARCHAR2(30) not null,
  lesson_content VARCHAR2(200),
  lesson_cycle   INTEGER,
  create_time    DATE,
  update_time    DATE
)
;
comment on column T_LESSON_PRODUCT_INFO.lesson_id
  is '�γ̱��';
comment on column T_LESSON_PRODUCT_INFO.lesson_code
  is '�γ̱���';
comment on column T_LESSON_PRODUCT_INFO.lesson_name
  is '�γ�����';
comment on column T_LESSON_PRODUCT_INFO.lesson_content
  is '�γ�����';
comment on column T_LESSON_PRODUCT_INFO.lesson_cycle
  is '�γ�����(��)';
comment on column T_LESSON_PRODUCT_INFO.create_time
  is '����ʱ��';
comment on column T_LESSON_PRODUCT_INFO.update_time
  is '�޸�ʱ��';
alter table T_LESSON_PRODUCT_INFO
  add constraint PK_T_LESSON_PRODUCT_INFO primary key (LESSON_ID);

prompt
prompt Creating table T_SUBJECT_INFO
prompt =============================
prompt
create table T_SUBJECT_INFO
(
  subject_no     NUMBER not null,
  subject_code   VARCHAR2(36) not null,
  subject_name   VARCHAR2(36),
  class_content  VARCHAR2(2000),
  class_target   VARCHAR2(2000),
  class_hour     INTEGER,
  father_subject NUMBER not null,
  create_time    DATE,
  update_time    DATE,
  subject_order  VARCHAR2(5) not null
)
;
comment on column T_SUBJECT_INFO.subject_no
  is '��Ŀ���';
comment on column T_SUBJECT_INFO.subject_code
  is '��Ŀ����';
comment on column T_SUBJECT_INFO.subject_name
  is '��Ŀ���ƣ�1������Ŀ���⣻2:������Ŀģ�飻3������Ŀ���ƣ�';
comment on column T_SUBJECT_INFO.class_content
  is '�γ�����';
comment on column T_SUBJECT_INFO.class_target
  is '�γ�Ŀ��';
comment on column T_SUBJECT_INFO.class_hour
  is '��ʱ����';
comment on column T_SUBJECT_INFO.father_subject
  is '�ϼ���Ŀ';
comment on column T_SUBJECT_INFO.create_time
  is '����ʱ��';
comment on column T_SUBJECT_INFO.update_time
  is '�޸�ʱ��';
comment on column T_SUBJECT_INFO.subject_order
  is '�˵��ȼ�';
alter table T_SUBJECT_INFO
  add constraint PK_T_SUBJECT_INFO primary key (SUBJECT_NO);

prompt
prompt Creating table T_LES_SUB_RELATION
prompt =================================
prompt
create table T_LES_SUB_RELATION
(
  lesson_id   VARCHAR2(36),
  subject_no  NUMBER,
  create_time DATE,
  update_time DATE
)
;
comment on column T_LES_SUB_RELATION.lesson_id
  is '�γ̱��';
comment on column T_LES_SUB_RELATION.subject_no
  is '��Ŀ���';
comment on column T_LES_SUB_RELATION.create_time
  is '����ʱ��';
comment on column T_LES_SUB_RELATION.update_time
  is '�޸�ʱ��';
alter table T_LES_SUB_RELATION
  add constraint FK_T_LES_SU_REFERENCE_T_LESSON foreign key (LESSON_ID)
  references T_LESSON_PRODUCT_INFO (LESSON_ID);
alter table T_LES_SUB_RELATION
  add constraint FK_T_LES_SU_REFERENCE_T_SUBJEC foreign key (SUBJECT_NO)
  references T_SUBJECT_INFO (SUBJECT_NO);

prompt
prompt Creating table T_SYSTEM_MG_CODE
prompt ===============================
prompt
create table T_SYSTEM_MG_CODE
(
  sys_id      VARCHAR2(36) not null,
  sys_type    VARCHAR2(36) not null,
  sys_no      NUMBER not null,
  sys_code    VARCHAR2(36) not null,
  sys_name    VARCHAR2(100) not null,
  f_sys_no    NUMBER not null,
  layer       NUMBER,
  attribute1  VARCHAR2(100),
  attribute2  VARCHAR2(100),
  attribute3  VARCHAR2(100),
  attribute4  VARCHAR2(100),
  attribute5  VARCHAR2(100),
  create_time DATE
)
;
comment on column T_SYSTEM_MG_CODE.sys_id
  is '����id';
comment on column T_SYSTEM_MG_CODE.sys_type
  is '�������';
comment on column T_SYSTEM_MG_CODE.sys_no
  is '�������';
comment on column T_SYSTEM_MG_CODE.sys_code
  is '���ͱ��';
comment on column T_SYSTEM_MG_CODE.sys_name
  is '��������';
comment on column T_SYSTEM_MG_CODE.f_sys_no
  is '�������(����Ϊ0)';
comment on column T_SYSTEM_MG_CODE.layer
  is '���Ͳ㼶';
comment on column T_SYSTEM_MG_CODE.attribute1
  is '����1';
comment on column T_SYSTEM_MG_CODE.attribute2
  is '����2';
comment on column T_SYSTEM_MG_CODE.attribute3
  is '����3';
comment on column T_SYSTEM_MG_CODE.attribute4
  is '����4';
comment on column T_SYSTEM_MG_CODE.attribute5
  is '����5';
comment on column T_SYSTEM_MG_CODE.create_time
  is '����ʱ��';
alter table T_SYSTEM_MG_CODE
  add constraint PK_T_SYSTEM_MG_CODE primary key (SYS_ID);

prompt
prompt Creating table T_USER_PERSON
prompt ============================
prompt
create table T_USER_PERSON
(
  person_id       VARCHAR2(36) not null,
  person_type     NUMBER not null,
  person_name     VARCHAR2(36) not null,
  age             NUMBER not null,
  sex             INTEGER not null,
  identity_id     VARCHAR2(20) not null,
  birthday        DATE,
  education       VARCHAR2(10),
  graduate_school VARCHAR2(36),
  graduation_time DATE,
  wechat          VARCHAR2(36),
  qq              VARCHAR2(36),
  email           VARCHAR2(36),
  mobile_phone    VARCHAR2(20),
  landline        VARCHAR2(20),
  address         VARCHAR2(100),
  create_time     DATE,
  update_time     DATE
)
;
comment on column T_USER_PERSON.person_id
  is '��ԱID';
comment on column T_USER_PERSON.person_type
  is '��Ա���ͣ�1����ʦ��2��ѧ����3�������Ρ�4��Ա����';
comment on column T_USER_PERSON.person_name
  is '����';
comment on column T_USER_PERSON.age
  is '����';
comment on column T_USER_PERSON.sex
  is '�Ա�(1:�У�2��Ů)';
comment on column T_USER_PERSON.identity_id
  is '���֤��';
comment on column T_USER_PERSON.birthday
  is '����';
comment on column T_USER_PERSON.education
  is 'ѧ��';
comment on column T_USER_PERSON.graduate_school
  is '��ҵѧУ';
comment on column T_USER_PERSON.graduation_time
  is '��ҵʱ��';
comment on column T_USER_PERSON.wechat
  is '΢�ź�';
comment on column T_USER_PERSON.qq
  is 'QQ��';
comment on column T_USER_PERSON.email
  is '����';
comment on column T_USER_PERSON.mobile_phone
  is '�ֻ�';
comment on column T_USER_PERSON.landline
  is '����';
comment on column T_USER_PERSON.address
  is '��ϵ��ַ';
comment on column T_USER_PERSON.create_time
  is '����ʱ��';
comment on column T_USER_PERSON.update_time
  is '�޸�ʱ��';
alter table T_USER_PERSON
  add constraint PK_T_USER_PERSON primary key (PERSON_ID);

prompt
prompt Creating table T_USER_STUDENT
prompt =============================
prompt
create table T_USER_STUDENT
(
  student_no   VARCHAR2(36) not null,
  student_name VARCHAR2(20) not null,
  class_id     VARCHAR2(36) not null,
  lesson_id    VARCHAR2(36),
  create_time  DATE,
  update_time  DATE
)
;
comment on column T_USER_STUDENT.student_no
  is 'ѧ��ѧ��';
comment on column T_USER_STUDENT.student_name
  is '����';
comment on column T_USER_STUDENT.class_id
  is '�༶ID';
comment on column T_USER_STUDENT.lesson_id
  is '�γ̱��';
comment on column T_USER_STUDENT.create_time
  is '����ʱ��';
comment on column T_USER_STUDENT.update_time
  is '�޸�ʱ��';
alter table T_USER_STUDENT
  add constraint PK_T_USER_STUDENT primary key (STUDENT_NO);
alter table T_USER_STUDENT
  add constraint FK_T_USER_S_REFERENCE_T_CLASS_ foreign key (CLASS_ID)
  references T_CLASS_INFO (CLASS_ID);
alter table T_USER_STUDENT
  add constraint FK_T_USER_S_REFERENCE_T_LESSON foreign key (LESSON_ID)
  references T_LESSON_PRODUCT_INFO (LESSON_ID);

prompt
prompt Creating table T_USER_TEACHER
prompt =============================
prompt
create table T_USER_TEACHER
(
  teacher_id     VARCHAR2(36) not null,
  teacher_name   VARCHAR2(20) not null,
  teaching_types INTEGER not null,
  introduction   VARCHAR2(500),
  workyear       INTEGER,
  photo_address  VARCHAR2(100),
  create_time    DATE,
  update_time    DATE
)
;
comment on column T_USER_TEACHER.teacher_id
  is '��ʦ���';
comment on column T_USER_TEACHER.teacher_name
  is '��ʦ����';
comment on column T_USER_TEACHER.teaching_types
  is '�ڿ�����(1:������2������)';
comment on column T_USER_TEACHER.introduction
  is '��ʦ����';
comment on column T_USER_TEACHER.workyear
  is '��������';
comment on column T_USER_TEACHER.photo_address
  is '��Ƭ��ַ';
comment on column T_USER_TEACHER.create_time
  is '����ʱ��';
comment on column T_USER_TEACHER.update_time
  is '�޸�ʱ��';
alter table T_USER_TEACHER
  add constraint PK_T_USER_TEACHER primary key (TEACHER_ID);

prompt
prompt Creating table T_U_P_RELATION
prompt =============================
prompt
create table T_U_P_RELATION
(
  userid     VARCHAR2(36) not null,
  person_id  VARCHAR2(36),
  teacher_id VARCHAR2(36),
  student_no VARCHAR2(36)
)
;
comment on column T_U_P_RELATION.userid
  is '�û�����';
comment on column T_U_P_RELATION.person_id
  is '��ԱID';
comment on column T_U_P_RELATION.teacher_id
  is '��ʦ���';
comment on column T_U_P_RELATION.student_no
  is 'ѧ��ѧ��';
alter table T_U_P_RELATION
  add constraint PK_T_U_P_RELATION primary key (USERID);
alter table T_U_P_RELATION
  add constraint FK_T_U_P_RE_REFERENCE_T_USER_P foreign key (PERSON_ID)
  references T_USER_PERSON (PERSON_ID);
alter table T_U_P_RELATION
  add constraint FK_T_U_P_RE_REFERENCE_T_USER_S foreign key (STUDENT_NO)
  references T_USER_STUDENT (STUDENT_NO);
alter table T_U_P_RELATION
  add constraint FK_T_U_P_RE_REFERENCE_T_USER_T foreign key (TEACHER_ID)
  references T_USER_TEACHER (TEACHER_ID);


spool off
