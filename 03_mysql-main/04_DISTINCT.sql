# DISTINCT

-- 단일 열 DISTINCT
SELECT DISTINCT category_code
  FROM tbl_menu
ORDER BY category_code;

-- 단일 열 DISTINCT (컬럼값에 NULL이 포함된 경우)
SELECT DISTINCT ref_category_code
  FROM tbl_category; 
  
-- 여러 개 열에서의 DISTINCT
SELECT category_code, orderable_status
  FROM tbl_menu
ORDER BY category_code, orderable_status;

SELECT DISTINCT category_code, orderable_status
  FROM tbl_menu
ORDER BY category_code, orderable_status;