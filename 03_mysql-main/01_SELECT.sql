# SELECT FROM

-- 단일 열 데이터 검색
SELECT menu_name
  FROM tbl_menu;

-- 다중 열 데이터 검색
SELECT menu_code, menu_name, menu_price
  FROM tbl_menu;

-- 모든 열 데이터 검색
SELECT 
	menu_code
    , menu_name
    , menu_price
    , category_code
    , orderable_status
  FROM
	tbl_menu;
    
SELECT * FROM tbl_menu;



# 연산자

SELECT 6 + 3; -- FROM DUAL;
SELECT 6 - 3;
SELECT 6 * 3;
SELECT 6 / 3;
SELECT 6 % 3;



# 내장함수 (이후 챕터에서 다룰 내용)
SELECT NOW();
SELECT CONCAT('홍', ' ', '길동');



# 컬럼 별칭
SELECT CONCAT('다', '-', '람쥐') AS name;
SELECT CONCAT('원', '-', '숭이') AS 'Character name';
