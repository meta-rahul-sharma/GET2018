USE storefront;

/*
Consider a form where providing a Zip Code populates associated City and
State
Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/
SELECT City, State, Pincode
FROM address
ORDER BY State AND City;
/*
+-------------+--------------+---------+
| City        | State        | Pincode |
+-------------+--------------+---------+
| Jaipur      | Rajasthan    | 302039  |
| Jodhpur     | Rajasthan    | 342011  |
| Goa         | Goa          | 393231  |
| Jaipur      | Rajasthan    | 302031  |
| Jaipur      | Rajasthan    | 302001  |
| Udaipur     | Rajasthan    | 382001  |
| Jaisalmer   | Rajasthan    | 339401  |
| Haldi Ghati | Pratap Nagar | 339401  |
| Jaipur      | Rajasthan    | 302013  |
+-------------+--------------+---------+
*/