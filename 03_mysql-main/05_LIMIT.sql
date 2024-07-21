# LIMIT

SELECT menu_code, menu_name, menu_price
  FROM tbl_menu
ORDER BY menu_price DESC;

-- offset, row count
SELECT menu_code, menu_name, menu_price
  FROM tbl_menu
ORDER BY menu_price DESC
 LIMIT 2, 5;
 
 -- row count
 SELECT menu_code, menu_name, menu_price
   FROM tbl_menu
 ORDER BY menu_price DESC
  LIMIT 7;