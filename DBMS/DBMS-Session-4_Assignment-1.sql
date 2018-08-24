DROP FUNCTION IF EXISTS number_of_order_in_month;
DROP FUNCTION IF EXISTS month_with_max_orders;
/*
Function to calculate number of orders in a month.
Month and year will be input parameter to function.
*/
DELIMITER |
CREATE FUNCTION number_of_order_in_month(month int, year int) 
	RETURNS int
		DETERMINISTIC
			BEGIN
				DECLARE number_of_order INT;
					SELECT COUNT(order_id)
					INTO number_of_order
					FROM order_details
					WHERE MONTH(date_of_order) = month
					AND YEAR(date_of_order) = year;
					RETURN number_of_order;
			END |


/*
Function to return month in a year having maximum orders.
Year will be input parameter.
*/
DELIMITER |
CREATE FUNCTION month_with_max_orders(year int) 
	RETURNS int
		DETERMINISTIC
			BEGIN
				DECLARE month INT;
					SELECT MONTH(date_of_order)
					INTO month
					FROM order_details
					WHERE YEAR(date_of_order) = year
					GROUP BY MONTH(date_of_order)
					ORDER BY COUNT(order_id)
					LIMIT 1;
                    RETURN month;
                END |
