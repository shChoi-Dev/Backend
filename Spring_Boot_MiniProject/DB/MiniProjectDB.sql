CREATE TABLE PRODUCT (
    prd_no NUMBER PRIMARY KEY,
    prd_name VARCHAR2(100) NOT NULL,
    prd_price NUMBER NOT NULL,
    prd_img VARCHAR2(200) DEFAULT 'default.png',
    prd_stock NUMBER DEFAULT 0,
    reg_date DATE DEFAULT SYSDATE
);

-- 예시 데이터 추가
INSERT INTO PRODUCT (prd_no, prd_name, prd_price, prd_img) VALUES (1, '프리미엄 기내용 캐리어', 125000, 'carrier1.jpg');
INSERT INTO PRODUCT (prd_no, prd_name, prd_price, prd_img) VALUES (2, '여행용 멀티 어댑터', 25000, 'adapter1.jpg');
INSERT INTO PRODUCT (prd_no, prd_name, prd_price, prd_img) VALUES (3, '휴대용 디지털 저울', 18000, 'scale1.jpg');
INSERT INTO PRODUCT (prd_no, prd_name, prd_price, prd_img) VALUES (4, '도난방지 여행용 백팩', 89000, 'backpack1.jpg');

SELECT * FROM PRODUCT;

CREATE TABLE MEMBER (
    mem_id VARCHAR2(50) PRIMARY KEY,
    mem_pwd VARCHAR2(100) NOT NULL,
    mem_name VARCHAR2(50) NOT NULL,
    mem_email VARCHAR2(100),
    mem_joindate DATE DEFAULT SYSDATE,
    mem_hp VARCHAR2(20),
    mem_zipcode VARCHAR2(10),
    mem_address1 VARCHAR2(100),
    mem_address2 VARCHAR2(100)
);

ALTER TABLE PRODUCT ADD (prd_desc VARCHAR2(1000));

UPDATE PRODUCT SET prd_desc = '견고한 알루미늄 바디와 저소음 휠을 장착한 프리미엄 캐리어입니다. 넉넉한 수납 공간으로 실용성을 더했습니다.' WHERE prd_no = 1;
UPDATE PRODUCT SET prd_desc = '전 세계 150여 개국에서 사용 가능한 만능 여행용 어댑터입니다. 컴팩트한 디자인으로 휴대성이 뛰어납니다.' WHERE prd_no = 2;
UPDATE PRODUCT SET prd_desc = '최대 50kg까지 측정 가능한 고정밀 디지털 저울입니다. 여행 전 수하물 무게를 정확하게 확인할 수 있습니다.' WHERE prd_no = 3;
UPDATE PRODUCT SET prd_desc = '히든 포켓과 방수 원단을 적용하여 소지품을 안전하게 보관할 수 있는 여행용 백팩입니다.' WHERE prd_no = 4;

COMMIT;

ALTER TABLE MEMBER ADD (mem_role VARCHAR2(20) DEFAULT 'USER');

UPDATE MEMBER SET mem_role = 'ADMIN' WHERE mem_id = 'admin';
COMMIT;

ALTER TABLE PRODUCT ADD (prd_category VARCHAR2(50));

-- 기존 상품에 카테고리 지정
UPDATE PRODUCT SET prd_category = '캐리어' WHERE prd_no IN (1, 5);
UPDATE PRODUCT SET prd_category = '여행소품' WHERE prd_no IN (2, 3);
UPDATE PRODUCT SET prd_category = '안전용품' WHERE prd_no = 4;
COMMIT;