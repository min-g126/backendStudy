# CAST FUNCTIONS

# 명시적 형변환 (Explicit Conversion)
-- CAST(expression AS 데이터형식 [(길이)]
-- CONVERT(expression, 데이터형식 [(길이)]
-- 데이터 형식으로 가능한 것에는 BINARY, CHAR, DATE, DECIMAL, JSON, 
-- SIGNED, INTEGER, UNSIGNED INTEGER 등이 있음

SELECT AVG(menu_price) FROM tbl_menu;
SELECT CAST(AVG(menu_price) AS SIGNED INTEGER) AS '메뉴 평균 가격' FROM tbl_menu;
SELECT CONVERT(AVG(menu_price), SIGNED INTEGER) AS '메뉴 평균 가격' FROM tbl_menu;

SELECT CAST('2024/4/5' AS DATE);

SELECT menu_name, CONCAT(CAST(menu_price AS CHAR(5)), '원') AS '메뉴가격'
  FROM tbl_menu;



# 암시적 형변환(Implicit Conversion)

-- 각 문자가 정수로 변환됨
SELECT '1' + '2';   -- 3

-- menu_price가 문자로 변환됨
SELECT menu_name, CONCAT(menu_price, '원')
  FROM tbl_menu;

-- 문자는 0으로 변환됨
SELECT 3 > 'MAY';    -- 1

-- 문자에서 첫 번째로 나온 숫자는 정수로 변환됨
SELECT 5 > '6MAY';   -- 0

-- 숫자가 뒤에 나오면 문자로 인식되어 0으로 변환됨
SELECT 5 > 'M6AY';   -- 1

