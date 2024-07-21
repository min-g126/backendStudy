# DDL (Data Definition Language)

# CREATE
-- IF NOT EXISTS 적용 시, 기존에 존재하는 테이블을 생성해도 에러 발생하지 않음
-- 테이블의 컬럼 설정 구문
--        컬럼명 자료형(길이) [NOT NULL] [DEFAULT value] [AUTO_INCREMENT] 컬럼제약조건

CREATE TABLE IF NOT EXISTS tbl_1 (
    pk INT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;


-- 테이블 구조 확인
DESCRIBE tbl_1;

INSERT INTO tbl_1 VALUES (1, 10, 'Y');

SELECT * FROM tbl_1;


-- AUTO INCREMENT
CREATE TABLE tbl_2 (
    pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
	col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
) ENGINE=INNODB;

DESCRIBE tbl_2;

INSERT INTO tbl_2 VALUES (null, 10, 'Y');
INSERT INTO tbl_2 VALUES (null, 20, 'N');

SELECT * FROM tbl_2;



# ALTER 

-- 열(컬럼) 추가
ALTER TABLE tbl_2
ADD col2 INT NOT NULL;

DESCRIBE tbl_2;

SELECT * FROM tbl_2;

-- 열 삭제
ALTER TABLE tbl_2
DROP COLUMN col2;

-- 열 이름 및 데이터 형식 변경
ALTER TABLE tbl_2
CHANGE COLUMN fk change_fk DECIMAL NOT NULL;

-- 열 제약 조건 추가 및 삭제
ALTER TABLE tbl_2
DROP PRIMARY KEY;

-- MODIFY -> 수행 후 다시 위의 제약 조건 삭제 구문 수행
ALTER TABLE tbl_2
MODIFY pk INT;

DESCRIBE tbl_2;

-- 다시 제약조건 추가
ALTER TABLE tbl_2
ADD PRIMARY KEY(pk);

-- 컬럼 여러 개 추가
--   ALTER TABLE 테이블명
--     ADD 컬럼명 컬럼정의 [FIRST | AFTER 컬럼명]
--     ADD 컬럼명 컬럼정의 [FIRST | AFTER 컬럼명],
--     ...;
ALTER TABLE tbl_2
ADD col3 DATE NOT NULL,
ADD col4 TINYINT NOT NULL;

-- DATE형이 0으로 추가 불가능한 것은 MySQL 5.7버전 이후
-- SELECT @@GLOBAL.sql_mode 했을 때 나온 결과에 있는 NO_ZERO_DATE 때문
-- (0으로 채워진 DATE 컬럼이 존재하면 안됨)
-- 따라서 root 계정으로 SET GLOBAL = ''; 를 수행하고, 워크벤치를 껐다 켜서 반영시키면
-- 위의 ALTER 구문이 정상 작동함

-- ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION
SELECT @@GLOBAL.sql_mode;

DESCRIBE tbl_2;


# DROP
CREATE TABLE tbl_3 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255)
    CHECK (col1 IN('Y', 'N'))
) ENGINE=INNODB;

CREATE TABLE tbl_4 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255)
    CHECK (col1 IN('Y', 'N'))
) ENGINE=INNODB;

SELECT * FROM tbl_4;

-- DROP TABLE [IF EXISTS] 테이블명1, 테이블명2, ... [RESTRICT | CASCADE];
DROP TABLE IF EXISTS tbl_3;

DROP TABLE IF EXISTS tbl_3, tbl_4, tbl_5;



# TRUNCATE
CREATE TABLE tbl_5 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255)
    CHECK (col1 IN('Y', 'N'))
) ENGINE=INNODB;

INSERT INTO tbl_5 VALUES (null, 10, 'Y');
INSERT INTO tbl_5 VALUES (null, 20, 'N');
INSERT INTO tbl_5 VALUES (null, 30, 'Y');
INSERT INTO tbl_5 VALUES (null, 40, 'Y');
INSERT INTO tbl_5 VALUES (null, 50, 'N');

SELECT * FROM tbl_5;

TRUNCATE TABLE tbl_5;
