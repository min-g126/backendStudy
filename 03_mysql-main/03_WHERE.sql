# WHERE

-- 1) 비교 연산자와 WHERE절
-- = : 같음
SELECT menu_name, menu_price, orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'Y';
 
 SELECT menu_name, menu_price, orderable_status
   FROM tbl_menu
  WHERE menu_price = 10000;
  
-- !=, <> : 같지 않음
SELECT menu_name, menu_price, orderable_status
  FROM tbl_menu
-- WHERE orderable_status != 'Y';
 WHERE orderable_status <> 'Y';
 
-- 대소 비교 연산자
SELECT menu_name, menu_price, orderable_status
  FROM tbl_menu
 WHERE menu_price > 10000;
 
SELECT menu_name, menu_price, orderable_status
  FROM tbl_menu
 WHERE menu_price <= 20000;

-- 아래처럼 쓰면 에러는 발생하지 않지만, 원하는 값을 추출하지 않음
-- SELECT menu_name, menu_price, orderable_status
--   FROM tbl_menu
--  WHERE 10000 < menu_price <= 20000;

-- 2) AND
SELECT 1 AND 1;
SELECT 1 AND 0, 0 AND 1, 0 AND 0, 0 AND NULL;
SELECT 1 AND NULL, NULL AND NULL;

SELECT menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE menu_price > 10000
   AND menu_price <= 20000;

SELECT menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'Y'
   AND category_code = 10;

-- 3) OR
SELECT 1 OR 1, 1 OR 0, 0 OR 1, 0 OR 0;
SELECT 1 OR NULL, 0 OR NULL, NULL OR NULL;

SELECT menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu
 WHERE orderable_status = 'Y'
    OR category_code = 6;
    
SELECT menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu
 WHERE menu_price > 15000
    OR category_code = 10;
    
-- < AND와 OR의 우선순위 >
SELECT 1 OR 0 AND 0;
SELECT (1 OR 0) AND 0;

SELECT menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu
 WHERE category_code = 4
    OR menu_price = 9000
   AND menu_code > 10;

-- 4) BETWEEN
SELECT menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE menu_price BETWEEN 10000 AND 20000;
 
-- NOT : 부정 표현
SELECT menu_name, menu_price, category_code
  FROM tbl_menu
 WHERE menu_price NOT BETWEEN 10000 AND 20000;

-- 5) LIKE
SELECT menu_name, menu_price
  FROM tbl_menu
 WHERE menu_name LIKE '%마늘%'
ORDER BY menu_name;
 
-- 메뉴명에 민트를 포함하고, 
-- 금액이 10000원 이상이며, 
-- category_code가 4인 
-- 메뉴의 모든 컬럼을 조회하세요
SELECT menu_code, menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu
 WHERE menu_name LIKE '%민트%'
   AND menu_price >= 10000
   AND category_code = 4;
   
-- NOT
SELECT menu_name, menu_price
  FROM tbl_menu
 WHERE menu_name NOT LIKE '%마늘%'
ORDER BY menu_name;

-- 6) IN
SELECT menu_name, category_code
  FROM tbl_menu
 WHERE category_code = 4
    OR category_code = 5
	OR category_code = 6
ORDER BY category_code;

SELECT menu_name, category_code
  FROM tbl_menu
 WHERE category_code IN (4, 5, 6)
ORDER BY category_code;

-- NOT
SELECT menu_name, category_code
  FROM tbl_menu
 WHERE category_code NOT IN (4, 5, 6)
ORDER BY category_code;

-- 7) IS NULL
SELECT category_code, category_name, ref_category_code
  FROM tbl_category
 WHERE ref_category_code IS NULL;

-- NOT (IS NOT NULL)
SELECT category_code, category_name, ref_category_code
  FROM tbl_category
 WHERE ref_category_code IS NOT NULL;
 