# TRANSACTION

-- autocommit 비활성화
SET autocommit = 0;
-- or
SET autocommit = OFF;

-- autocommit 활성화
SET autocommit = 1;
-- or
SET autocommit = ON;


-- 트랜잭션 시작
START TRANSACTION;

-- 트랜잭션 진행
SELECT * FROM tbl_menu;
INSERT INTO tbl_menu VALUES (null, '오삼불고기', 10000, 4, 'Y');
UPDATE tbl_menu SET menu_name = '삼오불고기' WHERE menu_code = 20;
DELETE FROM tbl_menu WHERE menu_code = 200;

-- 트랜잭션 종료
COMMIT;
ROLLBACK;