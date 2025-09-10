create table member2(
    memId varchar(10)not null primary key,
    memPwd varchar(10) not null,
    memName varchar(30),
    memEmail varchar(20),
    memJoinDate date default(current_date));
    
    
    
INSERT INTO member2 (memId, memPwd, memName, memEmail) VALUES ('kim', '1234', '김길동', 'kim@naver.com');
INSERT INTO member2 (memId, memPwd, memName, memEmail) VALUES ('lee', '1111', '이길동', 'lee@naver.com');
INSERT INTO member2 (memId, memPwd, memName, memEmail) VALUES ('park', '2222', '강길동', 'park@naver.com');



SELECT * FROM member2;