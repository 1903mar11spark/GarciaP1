DROP USER companyAdmin CASCADE;

CREATE USER companyAdmin
IDENTIFIED BY p455w0rd
DEFAULT TABLESPACE users
TEMPORARY TABLESPACE temp
QUOTA 10M ON users;

GRANT connect to companyAdmin;
GRANT resource to companyAdmin;
GRANT create session TO companyAdmin;
GRANT create table TO companyAdmin;
GRANT create view TO companyAdmin;

conn companyAdmin/p455w0rd

DROP TABLE LOGIN;
DROP TABLE EMPLOYEE;
DROP TABLE REIMBURSEMENTS;

CREATE TABLE LOGIN(
    USER_ID VARCHAR2(20) PRIMARY KEY NOT NULL,
    U_PASSWORD VARCHAR2(20),
    EMPLOYEE_ID INT NOT NULL
);
/

CREATE TABLE EMPLOYEE(
    EMPLOYEE_ID INT PRIMARY KEY NOT NULL,
    FIRST_NAME VARCHAR2(30),
    LAST_NAME VARCHAR2(30),
    TITLE VARCHAR2(20),
    SUBORDINATE INT,
    ADDRESS VARCHAR2(30),
    PHONE VARCHAR2(13),
    DOB VARCHAR2(20),
    HIRE_DATE VARCHAR2(10),
    CITY VARCHAR2(20),
    STATE_E VARCHAR2(20),
    ZIP VARCHAR2(10)
    );
/
CREATE TABLE REIMBURSEMENTS(
    R_ID INT PRIMARY KEY NOT NULL,
    R_VALUE NUMBER(10,2),
    R_STATE VARCHAR2(15),
    R_DESC VARCHAR2(50),
    R_IMG BLOB,
    R_CREATION VARCHAR2(10),
    R_AUTH_DATE VARCHAR2(10),
    EMPLOYEE_ID INT NOT NULL,
    AUTH_BY INT
);
/


ALTER TABLE LOGIN
    ADD CONSTRAINT FK_EMPLOYEE
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);
/
ALTER TABLE REIMBURSEMENTS
    ADD CONSTRAINT FK_EMPLOYEE_R
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);
/
CREATE SEQUENCE SQ_EMPLOYEE_ID
START WITH 3
INCREMENT BY 1;
/
DROP SEQUENCE SQ_EMPLOYEE_ID;  
CREATE OR REPLACE TRIGGER TR_EMPLOYEE_ID
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    SELECT SQ_EMPLOYEE_ID.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/
CREATE SEQUENCE SQ_R_ID
START WITH 1
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER TR_R_ID
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW
BEGIN
    SELECT SQ_R_ID.NEXTVAL INTO :NEW.R_ID FROM DUAL;
END;
/

INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, TITLE,ADDRESS,PHONE, DOB,HIRE_DATE,CITY,STATE_E,ZIP)
 VALUES ('Xenmas', 'Shidosha', 'Manager','12702 Oblivion ave','(657)113 6635', '06/06/1986', '11/12/13','Tampa','FL','33601');
/

INSERT ALL INTO LOGIN
    VALUES('Sawaa','P455*',1)
    SELECT * FROM DUAL;
    /
UPDATE EMPLOYEE
SET TITLE = 'HR' WHERE EMPLOYEE_ID = 1;
/
INSERT ALL INTO LOGIN
 VALUES('Roxas','Keyblade',13)
 SELECT * FROM DUAL;
 /
 INSERT ALL INTO LOGIN
 VALUES('Axel','flame',8)
 SELECT * FROM DUAL;
 /
 
 UPDATE REIMBURSEMENTS
SET R_STATE = 'Pending' WHERE R_ID = 2;
/
 