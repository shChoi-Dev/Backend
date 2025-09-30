--------------------------------------------------------
--  파일이 생성됨 - 목요일-8월-29-2024   
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

Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('hong','1234','홍길동','hkd@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-1234-1234','12345','서울 강남구','11번지');
Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('lee','1234','이몽룡','lee@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-1111-1111','12345','경기 안양시','100번지');
Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('sch','1234','성춘향','sch@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-2222-2222','12345','제주 제주시','1번지');
Insert into MEMBER (MEMID,MEMPWD,MEMNAME,MEMEMAIL,MEMJOINDATE,MEMHP,MEMZIPCODE,MEMADDRESS1,MEMADDRESS2) values ('cha','1234','차철수','cha@naver.com',to_date('2024-08-29','YYYY-MM-DD'),'010-3333-3333','12345','인천 강화군','50번지');
---------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "MEMBER" MODIFY ("MEMID" NOT NULL ENABLE);
  ALTER TABLE "MEMBER" ADD CONSTRAINT "MEMBER_PK" PRIMARY KEY ("MEMID");

