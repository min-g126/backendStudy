# INDEX

CREATE TABLE phone (
	phone_code INT PRIMARY KEY,
	phone_name VARCHAR(100) NOT NULL,
    phone_price DECIMAL(10, 2) NOT NULL
);

INSERT INTO phone (phone_code, phone_name, phone_price)
VALUES
(1, 'iphone 31 pro', 1700000),
(2, 'galaxyS300', 1900000),
(3, '샤오미 2050', 210000);

SELECT * FROM phone;

EXPLAIN
SELECT * 
  FROM phone
 WHERE phone_name = 'iphone 31 pro';
  -- AND phone_price = 17000000;
 
 -- INDEX 생성
 CREATE INDEX idx_name
 ON phone (phone_name);
 
 -- INDEX 확인
 SHOW INDEX FROM phone;
 
 -- 복합 INDEX 생성
 CREATE INDEX idx_name_price
 ON phone (phone_name, phone_price);
 
 -- INDEX 최적화(재구성)
 ALTER TABLE phone DROP INDEX idx_name;
 ALTER TABLE phone ADD INDEX idx_name (phone_name);
 
-- MySQL의 InnoDB 엔진을 사용하는 경우
-- OPTIMIZE TABLE 명령을 사용하여 테이블과 인덱스를 최적화할 수도 있다.
OPTIMIZE TABLE phone;

-- INDEX 삭제
DROP INDEX idx_name
ON phone;
