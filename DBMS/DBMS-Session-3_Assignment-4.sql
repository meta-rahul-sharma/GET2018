USE storefront;

/*
Consider a form where providing a Zip Code populates associated City and
State
Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing (Zip Code, City Names ,
         States) ordered by State Name and City Name.
*/

SELECT pincode, city, state
FROM address
ORDER BY state AND city;
/*
+---------+-------------+--------------+
| pincode | city        | state        |
+---------+-------------+--------------+
| 302039  | jaipur      | rajasthan    |
| 342011  | JODHPUR     | rajasthan    |
| 393231  | GOA         | GOA          |
| 302031  | jaipur      | rajasthan    |
| 302001  | jaipur      | rajasthan    |
| 382001  | UDAIPUR     | rajasthan    |
| 339401  | JAISALMAIR  | rajasthan    |
| 339401  | HALDI GHATI | PRATAP NAGAR |
| 302013  | JAIPUR      | rajasthan    |
+---------+-------------+--------------+
*/