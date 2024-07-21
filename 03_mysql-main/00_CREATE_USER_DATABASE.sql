# 계정 생성 후 데이터베이스 활용

# 1) 새로운 계정 생성
CREATE USER 'sahmyook'@'%' IDENTIFIED BY 'sahmyook';
-- @'%' : 외부 ip로 접속 가능
-- @'localhost' : 외부 ip로 접속 불가능

-- 현재 존재하는 데이터베이스(스키마) 확인
SHOW databases;

-- 기본적으로 제공되는 mysql database를 사용
USE mysql;

-- mysql 데이터베이스의 전체 테이블 목록 확인
SHOW tables;

-- mysql 데이터베이스의 user테이블을 확인해 계정이 추가된 것 볼 수 있음
SELECT * FROM user;

# 2) 데이터베이스(스키마) 생성 및 계정에 권한 부여
CREATE DATABASE menu;
-- CREATE SCHEMA menu;

-- menu에 대한 모든 권한을 sahmyook에게 부여
GRANT ALL PRIVILEGES ON menu.* TO 'sahmyook'@'%';

-- sahmyook에게 부여된 권한 확인
SHOW GRANTS FOR 'sahmyook'@'%';