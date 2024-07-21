# VIEW 
-- SELECT 쿼리문을 저장한 객체로 '가상 테이블'이라고 불린다.
-- 실질적인 데이터를 물리적으로 저장하고 있지는 않으나, 테이블을 사용하는 것과 동일하게 사용할 수 있다.

-- VIEW 생성
CREATE VIEW hansik
AS
SELECT menu_code, menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu
 WHERE category_code = 4;
 
 -- VIEW 조회
 SELECT * FROM hansik;
 
 -- 베이스 테이블의 정보가 변경되면 VIEW의 결과도 같이 변경된다.
 INSERT INTO tbl_menu(menu_code, menu_name, menu_price, category_code, orderable_status)
 VALUES (null, '세상에서제일맛있는국밥', 198789, 4, 'Y');
 
 SELECT * FROM tbl_menu;
 
 -- VIEW를 통한 DML
 -- 1) INSERT
 INSERT INTO hansik
 VALUES (null, '세상에서제일행복한비빔밥', 123812, 4, 'Y');
 
 -- 2) UPDATE
 UPDATE hansik
    SET menu_name = '오색찬란 비빔밥'
        , menu_price = 12000
  WHERE menu_code = 204;
  
  -- 3) DELETE
  DELETE
    FROM hansik
   WHERE menu_code = 204;
 
 SELECT * FROM hansik;
 SELECT * FROM tbl_menu;
 
 
 -- VIEW 삭제
 DROP VIEW hansik;
 
 -- SUBQUERY, JOIN, 연산 결과 컬럼 등 사용 가능
CREATE VIEW hansik
AS
SELECT m.menu_name AS '메뉴명'
        , TRUNCATE(m.menu_price / 1000, 1) AS '가격(천원)'
		, c.category_name AS '카테고리명'
  FROM tbl_menu m
  JOIN tbl_category c ON m.category_code = c.category_code
 WHERE c.category_name = '한식';

SELECT * FROM hansik;

-- OR REPLACE 옵션
-- DROP하지 않고 기존 VIEW를 새로운 VIEW로 대체할 수 있다.
CREATE OR REPLACE VIEW hansik
AS
SELECT menu_code AS '메뉴 코드'
       , menu_name AS '메뉴명'
       , category_name AS '카테고리명'
FROM (
	  SELECT CONCAT(m.menu_code, '번') AS 'menu_code'
             , m.menu_name
             , CONCAT(c.category_name, '류') AS 'category_name'
        FROM tbl_menu m
        JOIN tbl_category c ON m.category_code = c.category_code
       WHERE c.category_name = '중식'
     ) AS sub_tbl;
     
     SELECT * FROM hansik;