-----------------------------------------------------
-- Export file for user HUIJIQUANXIAN@ORCL         --
-- Created by Administrator on 2017/9/11, 15:58:50 --
-----------------------------------------------------

set define off
spool exam_create_table_3.log

prompt
prompt Creating table T_EXA_PAPER
prompt ==========================
prompt
create table T_EXA_PAPER
(
  examination_no      VARCHAR2(36) not null,
  examination_type    NUMBER not null,
  examination_name    VARCHAR2(500) not null,
  examination_content VARCHAR2(1000),
  subject_no          NUMBER,
  exam_length         NUMBER,
  state               NUMBER,
  create_user         VARCHAR2(36),
  create_time         DATE,
  update_time         DATE
)
;
comment on column T_EXA_PAPER.examination_no
  is '试卷编号';
comment on column T_EXA_PAPER.examination_type
  is '试卷类型（1：单元测试；2:综合和测试';
comment on column T_EXA_PAPER.examination_name
  is '试卷名称';
comment on column T_EXA_PAPER.examination_content
  is '试卷描述';
comment on column T_EXA_PAPER.subject_no
  is '科目编号';
comment on column T_EXA_PAPER.exam_length
  is '考试时长(分钟)';
comment on column T_EXA_PAPER.state
  is '状态（1：有效；2：无效）';
comment on column T_EXA_PAPER.create_user
  is '创建用户';
comment on column T_EXA_PAPER.create_time
  is '创建时间';
comment on column T_EXA_PAPER.update_time
  is '修改时间';
alter table T_EXA_PAPER
  add constraint PK_T_EXA_PAPER primary key (EXAMINATION_NO);
alter table T_EXA_PAPER
  add constraint FK_T_EXA_PA_REFERENCE_T_SUBJEC foreign key (SUBJECT_NO)
  references T_SUBJECT_INFO (SUBJECT_NO);

prompt
prompt Creating table T_EXAMINATION_INFO
prompt =================================
prompt
create table T_EXAMINATION_INFO
(
  examination_info_no VARCHAR2(36) not null,
  examination_no      VARCHAR2(36),
  examination_user    VARCHAR2(36),
  right_num           NUMBER,
  error_num           NUMBER,
  score               NUMBER,
  examination_length  NUMBER,
  start_time          DATE,
  end_time            DATE
)
;
comment on column T_EXAMINATION_INFO.examination_info_no
  is '考试编号';
comment on column T_EXAMINATION_INFO.examination_no
  is '试卷编号';
comment on column T_EXAMINATION_INFO.examination_user
  is '考试人员';
comment on column T_EXAMINATION_INFO.right_num
  is '正确数量';
comment on column T_EXAMINATION_INFO.error_num
  is '错误数量';
comment on column T_EXAMINATION_INFO.score
  is '考试分数';
comment on column T_EXAMINATION_INFO.examination_length
  is '考试时长(用时)';
comment on column T_EXAMINATION_INFO.start_time
  is '开始时间';
comment on column T_EXAMINATION_INFO.end_time
  is '结束时间';
alter table T_EXAMINATION_INFO
  add constraint PK_T_EXAMINATION_INFO primary key (EXAMINATION_INFO_NO);
alter table T_EXAMINATION_INFO
  add constraint FK_T_EXAMIN_REFERENCE_T_EXA_P2 foreign key (EXAMINATION_NO)
  references T_EXA_PAPER (EXAMINATION_NO);

prompt
prompt Creating table T_EXA_QUESTION_DETAILED
prompt ======================================
prompt
create table T_EXA_QUESTION_DETAILED
(
  question_no   VARCHAR2(36) not null,
  question_num  NUMBER not null,
  question_type NUMBER not null,
  question_name VARCHAR2(2000) not null,
  right_key     VARCHAR2(10),
  state         NUMBER,
  create_time   DATE,
  update_time   DATE
)
;
comment on column T_EXA_QUESTION_DETAILED.question_no
  is '题目编号';
comment on column T_EXA_QUESTION_DETAILED.question_num
  is '题目序号';
comment on column T_EXA_QUESTION_DETAILED.question_type
  is '题目类型（1：单选题；2：多选题；3：判断题；4：编程题）';
comment on column T_EXA_QUESTION_DETAILED.question_name
  is '题目名称';
comment on column T_EXA_QUESTION_DETAILED.right_key
  is '正确答案(单选题：A;多选题： ABC;判断题： 是或者否)';
comment on column T_EXA_QUESTION_DETAILED.state
  is '状态（1：有效；2：无效）';
comment on column T_EXA_QUESTION_DETAILED.create_time
  is '创建时间';
comment on column T_EXA_QUESTION_DETAILED.update_time
  is '修改时间';
alter table T_EXA_QUESTION_DETAILED
  add constraint PK_T_EXA_QUESTION_DETAILED primary key (QUESTION_NO);

prompt
prompt Creating table T_EXA_PAPER_INFO
prompt ===============================
prompt
create table T_EXA_PAPER_INFO
(
  examination_id  VARCHAR2(36) not null,
  examination_no  VARCHAR2(36) not null,
  question_no     VARCHAR2(36) not null,
  question_type   NUMBER not null,
  question_num    NUMBER not null,
  question_name   VARCHAR2(100),
  question_nscore NUMBER,
  right_key       VARCHAR2(10),
  create_time     DATE,
  update_time     DATE
)
;
comment on column T_EXA_PAPER_INFO.examination_id
  is '试卷内容主键编号';
comment on column T_EXA_PAPER_INFO.examination_no
  is '试卷编号';
comment on column T_EXA_PAPER_INFO.question_no
  is '题目编号';
comment on column T_EXA_PAPER_INFO.question_type
  is '题目类型';
comment on column T_EXA_PAPER_INFO.question_num
  is '题目序号';
comment on column T_EXA_PAPER_INFO.question_name
  is '题目名称';
comment on column T_EXA_PAPER_INFO.question_nscore
  is '题目分值';
comment on column T_EXA_PAPER_INFO.right_key
  is '正确答案';
comment on column T_EXA_PAPER_INFO.create_time
  is '创建时间';
comment on column T_EXA_PAPER_INFO.update_time
  is '修改时间';
alter table T_EXA_PAPER_INFO
  add constraint PK_T_EXA_PAPER_INFO primary key (EXAMINATION_ID);
alter table T_EXA_PAPER_INFO
  add constraint FK_T_EXA_PA_REFERENCE_T_EXA_PA foreign key (EXAMINATION_NO)
  references T_EXA_PAPER (EXAMINATION_NO);
alter table T_EXA_PAPER_INFO
  add constraint FK_T_EXA_PA_REFERENCE_T_EXA_QU foreign key (QUESTION_NO)
  references T_EXA_QUESTION_DETAILED (QUESTION_NO);

prompt
prompt Creating table T_EXAMINATION_LIST
prompt =================================
prompt
create table T_EXAMINATION_LIST
(
  id                  VARCHAR2(36) not null,
  examination_info_no VARCHAR2(36) not null,
  examination_id      VARCHAR2(36),
  question_no         VARCHAR2(36) not null,
  question_type       NUMBER not null,
  question_num        NUMBER not null,
  choose_key          VARCHAR2(10),
  right_key           VARCHAR2(10),
  create_time         DATE
)
;
comment on column T_EXAMINATION_LIST.id
  is '主键编号';
comment on column T_EXAMINATION_LIST.examination_info_no
  is '考试编号';
comment on column T_EXAMINATION_LIST.examination_id
  is '试卷内容主键编号';
comment on column T_EXAMINATION_LIST.question_no
  is '题目编号';
comment on column T_EXAMINATION_LIST.question_type
  is '题目类型';
comment on column T_EXAMINATION_LIST.question_num
  is '题目序号';
comment on column T_EXAMINATION_LIST.choose_key
  is '选择答案';
comment on column T_EXAMINATION_LIST.right_key
  is '正确答案';
comment on column T_EXAMINATION_LIST.create_time
  is '创建时间';
alter table T_EXAMINATION_LIST
  add constraint PK_T_EXAMINATION_LIST primary key (ID);
alter table T_EXAMINATION_LIST
  add constraint FK_T_EXAMIN_REFERENCE_T_EXAMIN foreign key (EXAMINATION_INFO_NO)
  references T_EXAMINATION_INFO (EXAMINATION_INFO_NO);
alter table T_EXAMINATION_LIST
  add constraint FK_T_EXAMIN_REFERENCE_T_EXA_PA foreign key (EXAMINATION_ID)
  references T_EXA_PAPER_INFO (EXAMINATION_ID);

prompt
prompt Creating table T_EXA_ANSWER_INFO
prompt ================================
prompt
create table T_EXA_ANSWER_INFO
(
  answer_id    VARCHAR2(36) not null,
  question_no  VARCHAR2(36) not null,
  answer_num   NUMBER,
  answer_name  VARCHAR2(500),
  istrue       NUMBER,
  create_time  DATE,
  uppdate_time DATE
)
;
comment on column T_EXA_ANSWER_INFO.answer_id
  is '主键编号';
comment on column T_EXA_ANSWER_INFO.question_no
  is '题目编号';
comment on column T_EXA_ANSWER_INFO.answer_num
  is '答案序号';
comment on column T_EXA_ANSWER_INFO.answer_name
  is '答案内容';
comment on column T_EXA_ANSWER_INFO.istrue
  is '是否正确答案(1:是；2：否)';
comment on column T_EXA_ANSWER_INFO.create_time
  is '创建时间';
comment on column T_EXA_ANSWER_INFO.uppdate_time
  is '修改时间';
alter table T_EXA_ANSWER_INFO
  add constraint PK_T_EXA_ANSWER_INFO primary key (ANSWER_ID);
alter table T_EXA_ANSWER_INFO
  add constraint FK_T_EXA_AN_REFERENCE_T_EXA_QU foreign key (QUESTION_NO)
  references T_EXA_QUESTION_DETAILED (QUESTION_NO);

prompt
prompt Creating table T_EXA_PAPER_LIST
prompt ===============================
prompt
create table T_EXA_PAPER_LIST
(
  examinati_list_id VARCHAR2(36) not null,
  examination_id    VARCHAR2(36) not null,
  question_num      NUMBER not null,
  answer_num        NUMBER not null,
  answer_content    VARCHAR2(500) not null,
  istrue            NUMBER not null,
  create_user       VARCHAR2(36),
  create_time       DATE,
  update_time       DATE
)
;
comment on column T_EXA_PAPER_LIST.examinati_list_id
  is '主键编号';
comment on column T_EXA_PAPER_LIST.examination_id
  is '试卷内容主键编号';
comment on column T_EXA_PAPER_LIST.answer_num
  is '答案序号';
comment on column T_EXA_PAPER_LIST.answer_content
  is '答案内容';
comment on column T_EXA_PAPER_LIST.istrue
  is '是否正确答案(1:是；2：否)';
comment on column T_EXA_PAPER_LIST.create_user
  is '创建用户';
comment on column T_EXA_PAPER_LIST.create_time
  is '创建时间';
comment on column T_EXA_PAPER_LIST.update_time
  is '修改时间';
alter table T_EXA_PAPER_LIST
  add constraint PK_T_EXA_PAPER_LIST primary key (EXAMINATI_LIST_ID);
alter table T_EXA_PAPER_LIST
  add constraint FK_T_EXA_PA_REFERENCE_T_EXA_P3 foreign key (EXAMINATION_ID)
  references T_EXA_PAPER_INFO (EXAMINATION_ID);

prompt
prompt Creating table T_EXA_PAPER_SCORE
prompt ================================
prompt
create table T_EXA_PAPER_SCORE
(
  examination_no VARCHAR2(36),
  question_type  NUMBER not null,
  question_num   NUMBER,
  question_score NUMBER,
  total_score    NUMBER,
  create_time    DATE,
  update_time    DATE
)
;
comment on column T_EXA_PAPER_SCORE.examination_no
  is '试卷编号';
comment on column T_EXA_PAPER_SCORE.question_type
  is '题目类型（1：单选；2：多选；3：判断；4：编程题）';
comment on column T_EXA_PAPER_SCORE.question_num
  is '题目数量';
comment on column T_EXA_PAPER_SCORE.question_score
  is '题目分值';
comment on column T_EXA_PAPER_SCORE.total_score
  is '总分值';
comment on column T_EXA_PAPER_SCORE.create_time
  is '创建时间';
comment on column T_EXA_PAPER_SCORE.update_time
  is '修改时间';
alter table T_EXA_PAPER_SCORE
  add constraint IND_NO_TYPE_UNIQUE unique (EXAMINATION_NO, QUESTION_TYPE);
alter table T_EXA_PAPER_SCORE
  add constraint FK_T_EXA_PA_REFERENCE_T_EXA_P2 foreign key (EXAMINATION_NO)
  references T_EXA_PAPER (EXAMINATION_NO);

prompt
prompt Creating table T_EXA_QUESTIONS
prompt ==============================
prompt
create table T_EXA_QUESTIONS
(
  questions_no   VARCHAR2(36) not null,
  subject_no     NUMBER not null,
  questions_name VARCHAR2(100),
  questions_desc VARCHAR2(500),
  create_time    DATE,
  update_time    DATE,
  question_id    VARCHAR2(36) not null
)
;
comment on column T_EXA_QUESTIONS.questions_no
  is '题库编号';
comment on column T_EXA_QUESTIONS.subject_no
  is '科目编号';
comment on column T_EXA_QUESTIONS.questions_name
  is '题库名称';
comment on column T_EXA_QUESTIONS.questions_desc
  is '题库描述';
comment on column T_EXA_QUESTIONS.create_time
  is '创建时间';
comment on column T_EXA_QUESTIONS.update_time
  is '修改时间';
comment on column T_EXA_QUESTIONS.question_id
  is '题目编号';
alter table T_EXA_QUESTIONS
  add constraint PK_T_EXA_QUESTIONS primary key (QUESTIONS_NO);
alter table T_EXA_QUESTIONS
  add constraint FK_T_EXA_QU_REFERENCE_T_SUBJEC foreign key (SUBJECT_NO)
  references T_SUBJECT_INFO (SUBJECT_NO);
alter table T_EXA_QUESTIONS
  add constraint PK_QUESTIONS_QUESTION foreign key (QUESTION_ID)
  references T_EXA_QUESTION_DETAILED (QUESTION_NO);


spool off
