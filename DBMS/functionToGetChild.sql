USE storefront;
DROP FUNCTION IF EXISTS count_children;


DELIMITER |
CREATE FUNCTION count_children(parent_id INTEGER) 
RETURNS INTEGER 
NOT DETERMINISTIC 
READS SQL DATA
BEGIN 
DECLARE count INTEGER; 
SELECT count(category_id) 
INTO count 
FROM (SELECT * 
	  FROM categories 
      ORDER BY parent_id, category_id) category_sorted, (SELECT @pv := parent_id) initialisation 
	  WHERE find_in_set(parent_id, @pv) AND length(@pv := concat(@pv, ',', category_id)); 
RETURN count; 
END |