# 서브쿼리

-- 서브쿼리1
SELECT category_code
  FROM tbl_menu
 WHERE menu_name = '붕어빵초밥';
 
 -- 메인쿼리1
 SELECT menu_code, menu_name, menu_price, category_code, orderable_status
   FROM tbl_menu;


-- (WHERE절에 서브쿼리 사용)
-- 서브쿼리1를 활용한 메인쿼리1 : 메뉴명이 붕어빵초밥인 메뉴의 카테고리 코드와 동일한 카테고리 코드를 가진 메뉴 출력
 SELECT menu_code, menu_name, menu_price, category_code, orderable_status
   FROM tbl_menu
  WHERE category_code = (SELECT category_code
						  FROM tbl_menu
						 WHERE menu_name = '붕어빵초밥');
                         
-- (참고) 서브쿼리를 대상으로 IN 연산 등도 사용 가능
 SELECT menu_code, menu_name, menu_price, category_code, orderable_status
   FROM tbl_menu
  WHERE category_code IN (SELECT category_code
						  FROM tbl_menu
						 WHERE menu_name LIKE '%김치%');
                         
                         
-- 서브쿼리2
SELECT COUNT(*) AS 'count'
  FROM tbl_menu
GROUP BY category_code;

-- 메인쿼리2
-- SELECT MAX(count)
-- FROM ();


SELECT MAX(count)
FROM (SELECT COUNT(*) AS 'count'
        FROM tbl_menu
      GROUP BY category_code) AS countmenu;
               
               
# 상관 서브쿼리
-- 메인쿼리가 서브쿼리의 결과에 영향을 주는 경우

-- 서브쿼리
SELECT AVG(menu_price)
  FROM tbl_menu
GROUP BY category_code;

-- 메인쿼리
SELECT menu_code, menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu;
  
  

SELECT menu_code, menu_name, menu_price, category_code, orderable_status
  FROM tbl_menu a
 WHERE menu_price > (SELECT AVG(menu_price)
					   FROM tbl_menu
					  WHERE category_code = a.category_code
					 GROUP BY category_code);

-- 상관 서브쿼리는 단독 동작 불가 (에러 발생)
SELECT AVG(menu_price)
  FROM tbl_menu
 WHERE category_code = a.category_code
GROUP BY category_code;


# EXISTS
-- 조회 결과가 있을 때 true, 아니면 false

-- 메뉴가 있는 카테고리명만 조회
SELECT category_name
  FROM tbl_category a
 WHERE EXISTS(
				SELECT 1
				  FROM tbl_menu b
				 WHERE b.category_code = a.category_code
			 );
             
             
# CTE (Common Table Expressions)
-- 파생 테이블과 비슷한 개념이며 코드의 가독성과 재사용성을 위해 파생 테이블 대신 사용
-- FROM 절에서만 사용 (JOIN이면 JOIN구문에서도 가능)

WITH menucate AS (
	SELECT a.menu_name, b.category_name
      FROM tbl_menu a
	  JOIN tbl_category b ON a.category_code = b.category_code
)
SELECT *
  FROM menucate
ORDER BY menu_name;

