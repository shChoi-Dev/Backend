--------------------------------------------------------
--  ������ ������ - �����-8��-29-2024   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "MEMBER" 
   (	"MEMID" VARCHAR2(10), 
	"MEMPWD" VARCHAR2(100), 
	"MEMNAME" VARCHAR2(30), 
	"MEMEMAIL" VARCHAR2(30), 
	"MEMJOINDATE" DATE DEFAULT SYSDATE, 
	"MEMHP" VARCHAR2(13), 
	"MEMZIPCODE" VARCHAR2(13), 
	"MEMADDRESS1" VARCHAR2(30), 
	"MEMADDRESS2" VARCHAR2(30)
   );

Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('hong','1234','ȫ�浿','hkd@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-1234-1234','12345','���� ������','11����');
Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('lee','1234','�̸���','lee@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-1111-1111','12345','��� �Ⱦ��','100����');
Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('sch','1234','������','sch@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-2222-2222','12345','���� ���ֽ�','1����');
Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('cha','1234','��ö��','cha@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-3333-3333','12345','��õ ��ȭ��','50����');
---------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MEMBER" MODIFY ("MEMID" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("MEMID");

