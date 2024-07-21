# CONSTRAINTS
-- 데이터 무결성 보장을 목적으로 테이블 작성(정의)시 각 컬럼의 값 기록에 대한 제약조건 설정 가능
-- 입력/수정하는 데이터에 문제가 없는지 자동으로 검사해 줌
-- NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CEHCK

# NOT NULL
DROP TABLE IF EXISTS user_notnull;
CREATE TABLE user_notnull (
	user_no INT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255)  NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255)
) ENGINE=INNODB;

INSERT INTO user_notnull(user_no, user_id, user_pwd, user_name, gender, phone,email)
VALUES
(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
(2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gmail.com');

SELECT * FROM user_notnull; 

INSERT INTO user_notnull(user_no, user_id, user_pwd, user_name, gender, phone,email)
VALUES
(3, 'user03', 'pass03', '황향숙', '여', '010-9999-9999', 'hwanghs@kakao.com');




# UNIQUE
DROP TABLE IF EXISTS user_unique;
CREATE TABLE user_unique (
	user_no INT NOT NULL UNIQUE,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255)  NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    CONSTRAINT UNIQUE (phone)
) ENGINE=INNODB;

INSERT INTO user_unique(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
(2, 'user02', 'pass02', '한소희', '여', '010-7856-4321', 'hansh@gmail.com'); 

SELECT * FROM user_unique;

INSERT INTO user_unique (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (101, 'user01', 'pass01', '박서준', '남', '010-1234-5679', null);

INSERT INTO user_unique(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (3, 'user03', 'pass03', '한소희', '여', '010-7856-4321', null); 



# PRIMARY KEY (PK)
-- NOT NULL + UNIQUE
-- 한 테이블 한 개만 설정할 수 있음
DROP TABLE IF EXISTS user_pk;
CREATE TABLE user_pk (
	-- user_no INT PRIMARY KEY,
    user_no INT ,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255)  NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    CONSTRAINT user_pk_const PRIMARY KEY (user_no, user_id)
) ENGINE=INNODB;


INSERT INTO user_pk(user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
(2, 'user02', 'pass02', '한소희', '여', '010-7856-4321', 'hansh@gmail.com'); 


SELECT * FROM user_pk;

-- PRIMARY KEY 제약조건으로 인해 에러 발생 (PK는 NOT NULL)
INSERT INTO user_pk (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (null, 'user01', 'pass01', '박서준', '남', '010-1234-5678', null);

-- PRIMARY KEY 제약조건으로 인해 에러 발생 (PK는 UNIQUE)
INSERT INTO user_pk (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES (1, 'user03', 'pass03', '한세준', '남', '010-1234-5678', null); 



# FOREIGN KEY (FK)
-- FOREIGN KEY 제약조건에 의해 테이블 간 관계(Relationship) 형성
DROP TABLE IF EXISTS user_level;
CREATE TABLE user_level (
	level_code INT NOT NULL UNIQUE,
    level_title VARCHAR(25) NOT NULL
) ENGINE=INNODB;

INSERT INTO user_level
VALUES
(10, '초보'),
(20, '중수'),
(30, '고수');

SELECT * FROM user_level;


DROP TABLE IF EXISTS user_fk_1;
CREATE TABLE user_fk_1 (
	user_no INT PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255)  NOT NULL,
    user_name VARCHAR(255),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    level_code INT,
    CONSTRAINT level_code_fk 
    FOREIGN KEY (level_code) REFERENCES user_level (level_code)
) ENGINE=INNODB;

INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(1, 'user01', 'pass01', '다람쥐', '010-4444-4444', 'squirrel@gmail.com', 10),
(2, 'user02', 'pass02', '원숭이', '010-8888-8888', null, 20);

SELECT * FROM user_fk_1;

-- FOREIGN KEY 제약조건으로 인한 에러 발생 (참조 테이블 컬럼에 없는 값 적용)
INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(3, 'user03', 'pass03', '양', '010-5555-5555', 'sheep@gmail.com', 50);

-- 제공되는 값 외에 NULL을 사용할 수 있음
INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(3, 'user03', 'pass03', '양', '010-5555-5555', 'sheep@gmail.com', null);

-- ON UPDATE SET NULL, ON DELETE SET NULL
DROP TABLE IF EXISTS user_fk_2;
CREATE TABLE user_fk_2 (
	user_no INT PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255)  NOT NULL,
    user_name VARCHAR(255),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    level_code INT,
    CONSTRAINT level_code_fk 
    FOREIGN KEY (level_code) 
		REFERENCES user_level (level_code)
        ON UPDATE SET NULL
        ON DELETE SET NULL
) ENGINE=INNODB;

INSERT INTO user_fk_2 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
(1, 'user01', 'pass01', '뽀로로', '010-8282-8282', 'pororo@naver.com', 10),
(2, 'user02', 'pass02', '크롱', '010-9595-9595', null, 20);

SELECT * FROM user_fk_2;

-- 1) 부모 테이블의 컬럼 수정
UPDATE user_level
   SET level_code = null
 WHERE level_code = 10;
 
 SELECT * FROM user_level;
 
 -- 2) 부모 테이블의 컬럼 삭제
 DELETE
   FROM user_level
  WHERE level_code = 20;
  
  
  # CHECK
  DROP TABLE IF EXISTS user_check;
  CREATE TABLE user_check (
	user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(3) CHECK (gender IN ('남', '여')),
    age INT,
    CHECK (age > 19)
  ) ENGINE=INNODB;
  
  INSERT INTO user_check(user_no, user_name, gender, age)
  VALUES
  (null, '김길동', '남', 20),
  (null, '홍길동', '여', 22);
  
  SELECT * FROM user_check;
  
  INSERT INTO user_check(user_no, user_name, gender, age)
  VALUES (null, '유길동', '여성', 29);
  
  INSERT INTO user_check(user_no, user_name, gender, age)
  VALUES (null, '유길동', '여', 19);
  
  
  # DEFAULT
  -- 컬럼 타입이 DATE이면 currrent_date 사용 가능
  -- 컬럼 타입이 DATETIME이면 current_tiem, current)timestamp, now() 모두 사용 가능
  DROP TABLE IF EXISTS tbl_default;
  CREATE TABLE tbl_default (
	country_code INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) DEFAULT '한국',
    population VARCHAR(255) DEFAULT '0명',
    add_day DATE DEFAULT (current_Date),
    add_time DATETIME DEFAULT (current_time)
  ) ENGINE=INNODB;
  
  SELECT * FROM tbl_default;
  
  -- DEFAULT 값을 넣어주기 위해 DEFAULT 사용
  INSERT INTO tbl_default VALUES (null, default, default, default, default);
  
  -- DEFAULT 값이 설정된 컬럼을 INSERT 대상 컬럼에 명시하지 않으면 DEFAULT 값으로 삽입됨
  INSERT INTO tbl_default(country_code) VALUES (null);
  
  -- NULL 입력 시 NULL로 삽입됨(NOT NULL 제약조건이 있는 경우 에러 발생)
  INSERT INTO tbl_default VALUES (null, null, null, null, null);
  
  