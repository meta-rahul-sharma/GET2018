DELIMITER |
CREATE FUNCTION count_children(parent INTEGER) 
RETURNS INTEGER 
DETERMINISTIC 

BEGIN 
DECLARE count INTEGER; 
SELECT count(category_id)
INTO count 
FROM (SELECT * 
	  FROM categories 
    ORDER BY parent_id, category_id) category_sorted, (SELECT @pv := parent) initialisation 
	  WHERE find_in_set(parent_id, @pv) AND length(@pv := concat(@pv, ',', category_id)); 
RETURN count; 
END |