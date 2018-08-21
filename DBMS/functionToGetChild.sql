DROP FUNCTION IF EXISTS get_child_category_count;
DROP FUNCTION IF EXISTS count_children;

DELIMITER |
CREATE FUNCTION get_child_category_count(parent_id INT)
    RETURNS INT
        NOT DETERMINISTIC
            BEGIN
                DECLARE count_child INT DEFAULT 0;
                
                SELECT COUNT(child.category_id)
                INTO count_child
                FROM categories child
                WHERE child.parent_id = parent_id;
                
                IF(count_child > 0)
                    THEN
                    SELECT @child = @child + get_child_category_count(child.category_id)
                    FROM categories child
                    WHERE child.parent_id = parent_id;
                    
                    SET count_child = count_child + SUM(@child);
                END IF;
                
                RETURN count_child;
            END |
            
CREATE FUNCTION count_children(parent_id INTEGER) 
    RETURNS INTEGER NOT DETERMINISTIC 
        BEGIN 
        DECLARE count INTEGER; 
            SELECT count(category_id) INTO count 
            FROM (SELECT * FROM categories 
                  ORDER BY parent_id, category_id) category_sorted, 
            (SELECT @pv := parent_id) initialisation 
            WHERE find_in_set(parent_id, @pv) 
            AND length(@pv := concat(@pv, ',', category_id)); 
        RETURN count; 
        END |
        
SELECT count_children(category_id), category_name
FROM categories;
