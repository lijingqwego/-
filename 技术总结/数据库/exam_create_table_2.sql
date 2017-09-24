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
  is '课程编号';
comment on column T_LESSON_PRODUCT_INFO.lesson_code
  is '课程编码';
comment on column T_LESSON_PRODUCT_INFO.lesson_name
  is '课程名称';
comment on column T_LESSON_PRODUCT_INFO.lesson_content
  is '课程描述';
comment on column T_LESSON_PRODUCT_INFO.lesson_cycle
  is '课程周期(月)';
comment on column T_LESSON_PRODUCT_INFO.create_time
  is '创建时间';
comment on column T_LESSON_PRODUCT_INFO.update_time
  is '修改时间';
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
  is '科目编号';
comment on column T_SUBJECT_INFO.subject_code
  is '科目代码';
comment on column T_SUBJECT_INFO.subject_name
  is '科目名称（1级：科目主题；2:级：科目模块；3级：科目名称）';
comment on column T_SUBJECT_INFO.class_content
  is '课程内容';
comment on column T_SUBJECT_INFO.class_target
  is '课程目标';
comment on column T_SUBJECT_INFO.class_hour
  is '课时总数';
comment on column T_SUBJECT_INFO.father_subject
  is '上级科目';
comment on column T_SUBJECT_INFO.create_time
  is '创建时间';
comment on column T_SUBJECT_INFO.update_time
  is '修改时间';
comment on column T_SUBJECT_INFO.subject_order
  is '菜单等级';
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
  is '课程编号';
comment on column T_LES_SUB_RELATION.subject_no
  is '科目编号';
comment on column T_LES_SUB_RELATION.create_time
  is '创建时间';
comment on column T_LES_SUB_RELATION.update_time
  is '修改时间';
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
  is '主键id';
comment on column T_SYSTEM_MG_CODE.sys_type
  is '码表类型';
comment on column T_SYSTEM_MG_CODE.sys_no
  is '码表类型';
comment on column T_SYSTEM_MG_CODE.sys_code
  is '类型编号';
comment on column T_SYSTEM_MG_CODE.sys_name
  is '类型名称';
comment on column T_SYSTEM_MG_CODE.f_sys_no
  is '父级编号(顶级为0)';
comment on column T_SYSTEM_MG_CODE.layer
  is '类型层级';
comment on column T_SYSTEM_MG_CODE.attribute1
  is '属性1';
comment on column T_SYSTEM_MG_CODE.attribute2
  is '属性2';
comment on column T_SYSTEM_MG_CODE.attribute3
  is '属性3';
comment on column T_SYSTEM_MG_CODE.attribute4
  is '属性4';
comment on column T_SYSTEM_MG_CODE.attribute5
  is '属性5';
comment on column T_SYSTEM_MG_CODE.create_time
  is '创建时间';
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
  is '人员ID';
comment on column T_USER_PERSON.person_type
  is '人员类型（1：老师、2：学生、3：班主任、4：员工）';
comment on column T_USER_PERSON.person_name
  is '姓名';
comment on column T_USER_PERSON.age
  is '年龄';
comment on column T_USER_PERSON.sex
  is '性别(1:男；2：女)';
comment on column T_USER_PERSON.identity_id
  is '身份证号';
comment on column T_USER_PERSON.birthday
  is '生日';
comment on column T_USER_PERSON.education
  is '学历';
comment on column T_USER_PERSON.graduate_school
  is '毕业学校';
comment on column T_USER_PERSON.graduation_time
  is '毕业时间';
comment on column T_USER_PERSON.wechat
  is '微信号';
comment on column T_USER_PERSON.qq
  is 'QQ号';
comment on column T_USER_PERSON.email
  is '邮箱';
comment on column T_USER_PERSON.mobile_phone
  is '手机';
comment on column T_USER_PERSON.landline
  is '座机';
comment on column T_USER_PERSON.address
  is '联系地址';
comment on column T_USER_PERSON.create_time
  is '创建时间';
comment on column T_USER_PERSON.update_time
  is '修改时间';
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
  is '学生学号';
comment on column T_USER_STUDENT.student_name
  is '姓名';
comment on column T_USER_STUDENT.class_id
  is '班级ID';
comment on column T_USER_STUDENT.lesson_id
  is '课程编号';
comment on column T_USER_STUDENT.create_time
  is '创建时间';
comment on column T_USER_STUDENT.update_time
  is '修改时间';
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
  is '老师编号';
comment on column T_USER_TEACHER.teacher_name
  is '老师名称';
comment on column T_USER_TEACHER.teaching_types
  is '授课类型(1:开发：2：测试)';
comment on column T_USER_TEACHER.introduction
  is '老师介绍';
comment on column T_USER_TEACHER.workyear
  is '工作经验';
comment on column T_USER_TEACHER.photo_address
  is '照片地址';
comment on column T_USER_TEACHER.create_time
  is '创建时间';
comment on column T_USER_TEACHER.update_time
  is '修改时间';
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
  is '用户主键';
comment on column T_U_P_RELATION.person_id
  is '人员ID';
comment on column T_U_P_RELATION.teacher_id
  is '老师编号';
comment on column T_U_P_RELATION.student_no
  is '学生学号';
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
