USE storefront;
DROP PROCEDURE IF EXISTS monthly_average_sales;
DROP PROCEDURE IF EXISTS order_detail_with_status;
DROP FUNCTION IF EXISTS get_total_sales;

/*
Procedure to retrieve average sales of each product in a month.
Month and year will be input parameter to procedure.
*/

DELIMITER |
CREATE FUNCTION get_total_sales(month INT, year INT)
	RETURNS INT
		DETERMINISTIC
			BEGIN
				DECLARE sales INT;
				SELECT SUM(items_ordered.quantity)
                INTO sales
				FROM order_details 
				INNER JOIN items_ordered ON order_details.order_id = items_ordered.order_id
				INNER JOIN products ON products.product_id = items_ordered.product_id
				WHERE MONTH(date_of_order) = month
				AND YEAR(date_of_order) = year;
                RETURN sales;
			END |


DELIMITER |
CREATE PROCEDURE monthly_average_sales(IN month INT, IN year INT)
	BEGIN
		SELECT products.product_id, product_name, AVG(items_ordered.quantity)/get_total_sales(month, year)
        FROM order_details 
        INNER JOIN items_ordered ON order_details.order_id = items_ordered.order_id
        INNER JOIN products ON products.product_id = items_ordered.product_id
        WHERE MONTH(date_of_order) = month
        AND YEAR(date_of_order) = year
        GROUP BY products.product_id;
	END |
    
CALL monthly_average_sales(8, 2018);
    

/*
Stored procedure to retrieve table having order detail with status for a given period. Start date and 
end date will be input parameter. Put validation on input dates like start date is less than end date.
If start date is greater than end date take first date of month as start date.
*/

DELIMITER |
CREATE PROCEDURE order_detail_with_status(IN start_date DATE, IN end_date DATE)
	BEGIN
		IF(start_date > end_date)
			THEN
				SET start_date = CONCAT(DATE_FORMAT(start_date, '%Y-%m-'), '01');
		END IF;
        SELECT order_details.order_id, date_of_order, order_status
        FROM order_details
        INNER JOIN items_ordered ON order_details.order_id = items_ordered.order_id
        WHERE date_of_order BETWEEN real_start_date AND end_date;
	END |
    
CALL order_detail_with_status('2018-02-01', '2018-10-12');
