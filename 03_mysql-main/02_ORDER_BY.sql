# ORDER BY

-- 결과 집합을 하나의 열 기준으로 정렬 (오름차순)
SELECT 
	menu_code
	, menu_name
    , menu_price
  FROM 
	tbl_menu
ORDER BY 
	menu_price ASC;	-- ASC는 오름차순 정렬로, 생략할 수 있음

-- 역순(내림차순) 정렬
SELECT 
	menu_code
    , menu_name
    , menu_price
  FROM 
	tbl_menu
ORDER BY 
	menu_price DESC;	-- DESC는 내림차순 정렬로, 명시해야 함

-- 결과 집합을 여러 개의 열로 정렬
SELECT 
	menu_code
    , menu_name
    , menu_price
  FROM 
	tbl_menu
ORDER BY 
	menu_price DESC
    , menu_name ASC;

-- 결과 집합을 연산 결과로 정렬 (별칭 지정 가능)
SELECT 
	menu_code
    , menu_name
    , menu_price
    , menu_code * menu_price
  FROM 
	tbl_menu
ORDER BY 
	menu_code * menu_price DESC;

SELECT 
	menu_code
    , menu_name
    , menu_price
    , menu_code * menu_price AS '연산결과'
  FROM 
	tbl_menu
ORDER BY 
	연산결과 DESC;

-- 사용자 지정 목록을 사용하여 정렬
SELECT FIELD('A', 'A', 'B', 'C');
SELECT FIELD('B', 'A', 'B', 'C');

SELECT 
	menu_name
    , orderable_status
	, FIELD(orderable_status, 'Y', 'N')
  FROM 
	tbl_menu;
    
SELECT 
	menu_name
    , orderable_status
  FROM 
	tbl_menu
ORDER BY 
	FIELD(orderable_status, 'N', 'Y');

-- NULL
-- 오름차순(ASC) 정렬 시 NULL이 맨처음 (default)
SELECT 
	category_code
    , category_name
    , ref_category_code
  FROM 
	tbl_category
ORDER BY 
	ref_category_code;

-- 오름차순(ASC) 정렬 시 NULL을 맨끝으로 (IS NULL ASC) : ASC 생략 가능
SELECT 
	category_code
    , category_name
    , ref_category_code
  FROM 
	tbl_category
ORDER BY 
	ref_category_code IS NULL;

-- 내림차순(DESC) 정렬 시 NULL이 맨끝 (default)
SELECT 
	category_code
    , category_name
    , ref_category_code
  FROM 
	tbl_category
ORDER BY 
	ref_category_code DESC;

-- 내림차순(DESC) 정렬 시 NULL을 맨처음으로 (IS NULL DESC) : DESC 생략 불가
SELECT 
	category_code
    , category_name
    , ref_category_code
  FROM 
	tbl_category
ORDER BY 
	ref_category_code IS NULL DESC
	, ref_category_code DESC;
