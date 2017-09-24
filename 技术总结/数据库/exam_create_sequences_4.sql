-----------------------------------------------------
-- Export file for user HUIJIQUANXIAN@ORCL         --
-- Created by Administrator on 2017/9/11, 16:00:35 --
-----------------------------------------------------

set define off
spool exam_create_sequences_4.log

prompt
prompt Creating sequence SEQ_ANSWER
prompt ============================
prompt
create sequence SEQ_ANSWER
minvalue 1
maxvalue 999999
start with 194
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_EXAM_ANSWER
prompt =================================
prompt
create sequence SEQ_EXAM_ANSWER
minvalue 1
maxvalue 999999
start with 768
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_EXAM_INFO
prompt ===============================
prompt
create sequence SEQ_EXAM_INFO
minvalue 1
maxvalue 999999
start with 49
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_PAGE_ANSWER
prompt =================================
prompt
create sequence SEQ_PAGE_ANSWER
minvalue 1
maxvalue 999999
start with 130
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_PAPER
prompt ===========================
prompt
create sequence SEQ_PAPER
minvalue 1
maxvalue 999999
start with 5
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_PAPER_LIST
prompt ================================
prompt
create sequence SEQ_PAPER_LIST
minvalue 1
maxvalue 999999
start with 54
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_QUESTION
prompt ==============================
prompt
create sequence SEQ_QUESTION
minvalue 1
maxvalue 999999
start with 86
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_SUBJECT
prompt =============================
prompt
create sequence SEQ_SUBJECT
minvalue 1
maxvalue 999999
start with 6
increment by 1
nocache;


spool off
