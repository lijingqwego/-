-----------------------------------------------------
-- Export file for user HUIJIQUANXIAN@ORCL         --
-- Created by Administrator on 2017/9/11, 16:03:06 --
-----------------------------------------------------

set define off
spool exam_create_package_procedures_5.log

prompt
prompt Creating package PK_EXAMINATION
prompt ===============================
prompt
create or replace package pk_examination is

       procedure examination(vc_examination_info_no in varchar2,result0 out integer);
       procedure testexam(v_examinationno in varchar2,v_username in varchar2,vc_examinfono out varchar2,result0 OUT INTEGER);

end pk_examination;
/

prompt
prompt Creating package PK_EXA_PAGE_MAKE
prompt =================================
prompt
create or replace package pk_exa_page_make is

  -- Author  : ADMINISTRATOR
  -- Created : 2017/8/23 11:25:56
  -- Purpose : 生成试卷
  
 procedure make_page_type(
   examinationName in varchar2,
   examinationContent in varchar2,
   examinationType in number,
   subjectNo in number,
   examLength in number,
   singln in integer,
   multil in integer,
   decide in integer,
   username in varchar2,
   result0 out integer);
end pk_exa_page_make;
/

prompt
prompt Creating package PK_QUESTION
prompt ============================
prompt
create or replace package pk_question is

  -- Author  : ADMINISTRATOR
  -- Created : 2017/8/22 20:13:43
  -- Purpose : 对题库的操作
  --试题入库，不关联题库，题目划分由页面处理
  procedure save_list_singln(questionname in varchar2,questiontype in integer,answerone in varchar2,answertwo in varchar2,answerthree in varchar2,answerfour in varchar2,rightkey in varchar2,result0 out integer);
end pk_question;
/

prompt
prompt Creating package body PK_EXAMINATION
prompt ====================================
prompt
create or replace package body pk_examination is
       procedure examination(vc_examination_info_no in varchar2,result0 out integer) is
           true_num number:=0;--正确数量
           false_num number:=0;--错误数量
           sum_num number:=0;--总分数
           score_num number:=0;--分值
           cursor c_examination_list(examinationno varchar2) is--遍历答题卡
                  select * from t_examination_list where examination_info_no= examinationno order by question_num;
         begin
           --循环遍历对试卷进行评阅
             for vc_examination_list in c_examination_list(vc_examination_info_no) loop
               --核对答案，计算分数
               --在试卷表中题目号不是唯一的
                 select t.question_nscore  into score_num from t_exa_paper_info t where question_no=vc_examination_list.question_no and rownum=1;
                 if vc_examination_list.choose_key = vc_examination_list.right_key then
                     true_num:=true_num+1;
                     sum_num:=sum_num+score_num;
                 else
                     false_num:=false_num+1;
                 end if;
             end loop;
             --更新考试信息记录表
             update t_examination_info set 
                    right_num=true_num,
                    error_num=false_num,
                    score=sum_num,
                    end_time=sysdate
                    where examination_info_no=vc_examination_info_no;
         result0 :=1;
         commit;
         EXCEPTION  
                 WHEN OTHERS THEN  
                 result0 :=0 ;--执行失败的话返回-1  
         end;
   procedure testexam(v_examinationno in varchar2,v_username in varchar2,vc_examinfono out varchar2,result0 OUT INTEGER) is
         vc_paper t_exa_paper%rowtype;
         CURSOR c_paper_list(examinationno varchar2) IS
                select examination_id,question_no,question_type,question_num,right_key from t_exa_paper_info where examination_no=examinationno order by question_num;
     begin
       --增加考试信息记录表
       select * into vc_paper from t_exa_paper t where t.examination_no= v_examinationno;
       insert into t_examination_info(examination_info_no,
                                      examination_no,
                                      examination_user,
                                      examination_length,
                                      start_time)
                                      values(
                                      'ex_'||seq_exam_info.nextval,
                                      vc_paper.examination_no,
                                      v_username,
                                      vc_paper.exam_length,
                                      sysdate);
       for vc_paper_list in c_paper_list(v_examinationno) loop
         insert into t_examination_list(id,
                                        examination_info_no,
                                        examination_id,
                                        question_no,
                                        question_type,
                                        question_num,
                                        choose_key,
                                        right_key,
                                        create_time)
                                        values(
                                        'ex_'||seq_exam_answer.nextval,
                                         'ex_'||seq_exam_info.currval,
                                         vc_paper_list.examination_id,
                                         vc_paper_list.question_no,
                                         vc_paper_list.question_type,
                                         vc_paper_list.question_num,
                                         '待定',
                                         vc_paper_list.right_key,
                                         sysdate);
         end loop;
         result0 :=1;
         vc_examinfono := 'ex_'||seq_exam_info.currval;
         commit;
         EXCEPTION  
            WHEN OTHERS THEN  
            result0 := 0;--执行失败的话返回-1  
       end;
end;
/

prompt
prompt Creating package body PK_EXA_PAGE_MAKE
prompt ======================================
prompt
create or replace package body pk_exa_page_make is
  procedure make_page_type(examinationName in varchar2,
    examinationContent in varchar2,
    examinationType in number,
    subjectNo in number,
    examLength in number,
    singln in integer,
    multil in integer,
    decide in integer,
    username in varchar2,
    result0 out integer) is
    --选择题答案题游标
    CURSOR c_answer(questionno varchar2) IS
           select answer_num,answer_name 
           from t_exa_answer_info 
           where question_no=questionno;
     --单选题游标
     CURSOR c_singln(subjectno NUMBER, nums integer) IS
           select * from (select question_no,question_name,right_key from t_exa_question_Detailed where exists(select 
           question_id from t_exa_questions where subject_no=subjectno) and question_type=1 order by dbms_random.value) where rownum <=nums;
     --多选题游标
     CURSOR c_multil(subjectno NUMBER, nums integer) IS
           select * from (select question_no,question_name,right_key from t_exa_question_Detailed where exists(select 
           question_id from t_exa_questions where subject_no=subjectno) and question_type=2 order by dbms_random.value) where rownum <=nums;
     --判断题游标
     CURSOR c_decide(subjectno NUMBER, nums integer) IS
           select * from (select question_no,question_name,right_key from t_exa_question_Detailed where exists(select 
           question_id from t_exa_questions where subject_no=subjectno) and question_type=3 order by dbms_random.value) where rownum <=nums;
    --定义题目排列
    vr_i integer := 0;
    --定义题目总分值
    vc_total_score number:=0;
  begin
    --读取填写试卷模板
     insert into t_exa_paper(examination_no,
                             examination_type,
                             examination_name,
                             examination_content,
                             subject_no,
                             exam_length,
                             state,
                             create_user,
                             create_time,
                             update_time)
                             values(
                             'ex_'||seq_paper.nextval,
                             examinationType,
                             examinationName,
                             examinationContent,
                             subjectNo,
                             examLength,
                             1,
                             username,
                             sysdate,
                             sysdate);
      --填写单选题
      for vc_singl in c_singln(subjectNo,singln) loop
        insert into t_exa_paper_info(examination_id,
                                     examination_no,
                                     question_no,
                                     question_type,
                                     question_num,
                                     question_name,
                                     question_nscore,
                                     right_key,
                                     create_time,
                                     update_time)
                                     values(
                                     'ex_'||seq_paper_list.nextval,
                                     'ex_'||seq_paper.currval,
                                     vc_singl.question_no,
                                     1,
                                     vr_i,
                                     vc_singl.question_name,
                                     4,
                                     vc_singl.right_key,
                                     sysdate,
                                     sysdate);
         
         --填写单选题答案
         for vc_answer in c_answer(vc_singl.question_no) loop
           insert into t_exa_paper_list(examinati_list_id,
                                        examination_id,
                                        question_num,
                                        answer_num,
                                        answer_content,
                                        istrue,
                                        create_user,
                                        create_time,
                                        update_time)
                                        values(
                                        'ex_'||seq_page_answer.nextval,
                                         'ex_'||seq_paper_list.currval,
                                         vr_i,
                                         vc_answer.answer_num,
                                         vc_answer.answer_name,
                                         1,
                                         username,
                                         sysdate,
                                         sysdate);
           end loop;
           vr_i:=vr_i+1;
           vc_total_score:=vc_total_score+4;
        end loop;
        --填写多选题
        for vc_multil in c_multil(subjectNo,multil) loop
        insert into t_exa_paper_info(examination_id,
                                     examination_no,
                                     question_no,
                                     question_type,
                                     question_num,
                                     question_name,
                                     question_nscore,
                                     right_key,
                                     create_time,
                                     update_time)
                                     values(
                                     'ex_'||seq_paper_list.nextval,
                                     'ex_'||seq_paper.currval,
                                     vc_multil.question_no,
                                     2,
                                     vr_i,
                                     vc_multil.question_name,
                                     5,
                                     vc_multil.right_key,
                                     sysdate,
                                     sysdate);
         for vc_answer in c_answer(vc_multil.question_no) loop
           insert into t_exa_paper_list(examinati_list_id,
                                        examination_id,
                                        question_num,
                                        answer_num,
                                        answer_content,
                                        istrue,
                                        create_user,
                                        create_time,
                                        update_time)
                                        values(
                                        'ex_'||seq_page_answer.nextval,
                                         'ex_'||seq_paper_list.currval,
                                         vr_i,
                                         vc_answer.answer_num,
                                         vc_answer.answer_name,
                                         1,
                                         username,
                                         sysdate,
                                         sysdate);
           end loop;
           vr_i:=vr_i+1;
            vc_total_score:=vc_total_score+5;
        end loop;
        --填写判断题
        for vc_decide in c_decide(subjectNo,decide) loop
            insert into t_exa_paper_info(examination_id,
                                     examination_no,
                                     question_no,
                                     question_type,
                                     question_num,
                                     question_name,
                                     question_nscore,
                                     right_key,
                                     create_time,
                                     update_time)
                                     values(
                                     'ex_'||seq_paper_list.nextval,
                                     'ex_'||seq_paper.currval,
                                     vc_decide.question_no,
                                     3,
                                     vr_i,
                                     vc_decide.question_name,
                                     2,
                                     vc_decide.right_key,
                                     sysdate,
                                     sysdate);
           vr_i:=vr_i+1;
            vc_total_score:=vc_total_score+2;
        end loop;
        --题目值是从1开始加的，最后要减去1
        vr_i :=vr_i-1;
        insert into t_exa_paper_score(examination_no,
                                      question_type,
                                      question_num,
                                      question_score,
                                      total_score,
                                      create_time,
                                      update_time)
                                      values(
                                      'ex_'||seq_paper.currval,
                                      examinationType,
                                      vr_i,
                                      5,
                                      vc_total_score,
                                      sysdate,
                                      sysdate);
                                       
        result0:=1;
        commit;
       EXCEPTION  
                  WHEN OTHERS THEN  
                  result0 := 0;--执行失败的话返回-1    
    end;
end;
/

prompt
prompt Creating package body PK_QUESTION
prompt =================================
prompt
create or replace package body pk_question is
       procedure save_list_singln(questionname in varchar2,questiontype in integer,answerone in varchar2,answertwo in varchar2,answerthree in varchar2,answerfour in varchar2,rightkey in varchar2,result0 out integer) as 
         begin
               insert into t_exa_question_Detailed(question_no,Question_Num,Question_Type,Question_Name,Right_Key,State,Create_Time,Update_Time) 
                    values('qt_'||seq_question.nextval,1,questiontype,questionname,rightkey,1,sysdate,sysdate);
                    if questiontype < 3 then
                       insert into t_exa_answer_info(answer_id,question_no,answer_num,answer_name,istrue,create_time,uppdate_time) 
                             values('as_'||seq_answer.nextval,'qt_'||seq_question.currval,1,answerone,1,sysdate,sysdate);
                       insert into t_exa_answer_info(answer_id,question_no,answer_num,answer_name,istrue,create_time,uppdate_time) 
                             values('as_'||seq_answer.nextval,'qt_'||seq_question.currval,2,answertwo,1,sysdate,sysdate);
                       insert into t_exa_answer_info(answer_id,question_no,answer_num,answer_name,istrue,create_time,uppdate_time) 
                              values('as_'||seq_answer.nextval,'qt_'||seq_question.currval,3,answerthree,1,sysdate,sysdate);
                       insert into t_exa_answer_info(answer_id,question_no,answer_num,answer_name,istrue,create_time,uppdate_time) 
                              values('as_'||seq_answer.nextval,'qt_'||seq_question.currval,4,answerfour,1,sysdate,sysdate);
                    end if; 
           commit;    
           --返回结果，执行成功的话返回1  
            result0 := 1;  
            --捕捉异常，回滚操作  
            EXCEPTION  
                    WHEN OTHERS THEN  
                    result0 := 0;--执行失败的话返回-1    
            end;
        end;
/


spool off
