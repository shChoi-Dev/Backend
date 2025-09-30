-- ��ǰ�з����̺�
CREATE TABLE category(
    ctgId VARCHAR2(2) NOT NULL PRIMARY KEY,
    ctgName VARCHAR2(30)
);

INSERT INTO category VALUES('1','��Ʈ��');
INSERT INTO category VALUES('2','������');
INSERT INTO category VALUES('3','���콺');
INSERT INTO category VALUES('4','Ű����');

SELECT * FROM category;

-- ��ǰ���̺�
CREATE TABLE product(
    prdNo VARCHAR(10) NOT NULL PRIMARY KEY,
    prdName VARCHAR(100) NOT NULL,
    prdPrice   INT,
    prdCompany VARCHAR(50),
    prdStock INT,
    prdDescript VARCHAR2(500),
    prdImg VARCHAR2(30),
    ctgId VARCHAR2(2),
    CONSTRAINT FK_porduct_category FOREIGN KEY (ctgId) REFERENCES category(ctgId)
    );

INSERT INTO product VALUES('1001','LG��Ʈ����',1599000,'LG����',10,'��ȭ������ ���� ������ �����ս�, ��� ���丮���� Ȯ�� �����Ӱ�!','1001.jpg','1');
INSERT INTO product VALUES('1002','LG�׷�',1929000,'LG����',5,'LG�׷� 17��ġ 2019���� i7 Ǯ�ɼ� ��Ʈ��','1002.jpg','1');
INSERT INTO product VALUES('1003','�Ｚ��Ʈ��9',1139000,'�Ｚ����',7,'�Ｚ��Ʈ��9 NT930XBV-A58A+WIN10��ǰ��ġ_ICT','1003.jpg','1');
INSERT INTO product VALUES('1004','�Ｚ��Ʈ��5',939020,'�Ｚ����',7,'�Ｚ��Ʈ��5METAL NT560XBE-K54A ����Ű����ũ NS','1004.jpg','1');
INSERT INTO product VALUES('1005','�ƺ�����',2496600,'����',5,'�ƺ����� 13�� 512GB Silver MV9ZKH/A ��ġ��','1005.jpg','1');
INSERT INTO product VALUES('1006','���ó�Ʈ��',1809000,'����',2,'���ó�Ʈ�� �ƺ����� 13��','1006.jpg','1');
INSERT INTO product VALUES('1007','�Ｑ SL-J1660',71900,'�Ｚ����',12,'�Ｚ SL=J1660��ũ�����ձ� + ������ũ���ޱ�','1007.jpg','2');
INSERT INTO product VALUES('1008','���Ͻ� P265DW',149000,'���Ͻ�',7,'���Ͻ� P2565DW �������� ������ ������ ������ ����Ʈ','1008.jpg','2');
INSERT INTO product VALUES('1009','�ۼ� L6160',299000,'�ۼ�',4,'�ۼ� L6160 ������ũ���ձ� �μ�+����+��ĵ+��Ʈ��ũ','1009.jpg','2');
INSERT INTO product VALUES('1010','HP M254dw',99500,'HP',5,'HP M254dw �÷������� �ڵ�����μ� �⺻ �������/KH','1010.jpg','2');
INSERT INTO product VALUES('1011','M331 ������ �������콺',24900,'�������ڸ���',5,'������, �� ���͸� ����, �÷��� �� �÷��� ������, �����ο� ��������','1011.jpg','3');
INSERT INTO product VALUES('1012','MS ��� ����� ���콺',39900,'����ũ�μ���Ʈ',20,'����ũ�μ���Ʈ ��ǰ ����, ������ �޴밡 ���� ����� �������� ����� ���콺. ��� ǥ�鿡���� �۵��ϴ� ���Ʈ�� ��� ����','1012.jpg','3');
INSERT INTO product VALUES('1013','�ƽ�ƿ TRONG G10 PRO',22900,'�ƽ�ƿ',10,'�ƽ�ƿ TRON G10 PRO Rebom ȭ��Ʈ ���̹� ���콺','1013.jpg','3');
INSERT INTO product VALUES('1014','���̸��� EQwear-V10',10890,'���̸���',10,'���̸��� EQwear-V10 ������ ���콺','1014.jpg','3');
INSERT INTO product VALUES('1016','�Ľ� VENOM-9',49000,'�Ľ�',7,'�Ľ� VENOM-9 ���κ��� LED  ���̹� ���� Ű���� û��','1016.jpg','4');
INSERT INTO product VALUES('1015','���̸��� IR-WMK5000',26900,'���̸���',15,'���̸���IR-WMK5000 ���� Ű���� ���콺 set Ű��Ų ����','1015.jpg','4');
INSERT INTO product VALUES('1017','����Ű���� MXKEYS',139000,'�������ڸ���',7,'�������ڸ��� ��ǰ ����Ű����  MX KEYS','1017.jpg','4');
INSERT INTO product VALUES('1018','SKP-900B ����Ű���� ���콺 ��Ʈ',19200,'�Ｚ����',3,'�Ｚ���� ��ǰ ����ǰ SKP-900B ���� Ű���� ���콺 ��Ʈ','1018.jpg','4');


-- ��ٱ��� ���̺�
CREATE TABLE cart (
    cartNo NUMBER GENERATED  ALWAYS AS IDENTITY START WITH 1 INCREMENT BY 1 
                    NOT NULL PRIMARY KEY,
    memId VARCHAR(10),
    prdNo VARCHAR(10),
    cartQty  INT,
    CONSTRAINT FK_cart_member  FOREIGN KEY (memId) REFERENCES member (memId),
    CONSTRAINT FK_cart_product FOREIGN KEY(prdNo) REFERENCES product (prdNo)                    
);

-- �ֹ� ���̺�
CREATE TABLE   order_info(
    ordNo VARCHAR(20) NOT NULL PRIMARY KEY,
    ordDate TIMESTAMP DEFAULT SYSDATE,
    memId VARCHAR(10),
    ordReceiver VARCHAR(30),
    ordRcvZipcode VARCHAR(6),
    ordRcvAddress1 VARCHAR(50),
    ordRcvAddress2 VARCHAR(50),
    ordRcvPhone VARCHAR(14),
    ordRcvMsg VARCHAR(30),
    ordPay VARCHAR(30),
    CONSTRAINT FK_order_member FOREIGN KEY ( memId) REFERENCES member(memId)
);

-- �ֹ� ��ǰ �� ����
CREATE TABLE order_product (
    ordNo VARCHAR2(20),
    prdNo VARCHAR2(10),
    ordQty INT,
    CONSTRAINT FK_order_product FOREIGN KEY (prdNo) REFERENCES product (prdNo),
    CONSTRAINT FK_order_prd_info FOREIGN KEY (ordNo) REFERENCES order_info(ordNo)
);










