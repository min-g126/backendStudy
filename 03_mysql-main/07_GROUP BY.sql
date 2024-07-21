# GROUP BY

-- COUNT 함수 활용 (카테고리별 메뉴 갯수 카운트)
SELECT category_code, COUNT(*)
  FROM tbl_menu
GROUP BY category_code;

-- SUM 함수 활용 (카테고리별 메뉴 가격 합계)
SELECT category_code, SUM(menu_price)
FROM tbl_menu
GROUP BY category_code;

-- AVG 함수 활용 (카테고리별 메뉴 가격 평균)
SELECT category_code, AVG(menu_price)
  FROM tbl_menu
GROUP BY category_code;

-- 2개 컬럼으로 그룹 생성
SELECT category_code, menu_price, COUNT(*)
  FROM tbl_menu
GROUP BY category_code, menu_price;


# HAVING
SELECT category_code, COUNT(*)
  FROM tbl_menu
GROUP BY category_code
HAVING category_code BETWEEN 5 AND 8;


# ROLLUP
-- 컬럼 한 개를 활용해 GROUP BY 후, ROLLUP -> 총계
-- (카테고리별 가격의 총합 = 메뉴 가격의 총합)
SELECT category_code, SUM(menu_price)
  FROM tbl_menu
GROUP BY category_code
WITH ROLLUP;

-- 컬럼 두 개를 활용해 GROUP BY 후, ROLLUP -> 중계 + 총계
-- 먼저 나온 컬럼의 총합을 구하고, 이후에 나오는 컬럼의 총합까지도 구하는 방식
SELECT category_code, menu_price, COUNT(menu_price)
  FROM tbl_menu
GROUP BY category_code, menu_price
WITH ROLLUP;