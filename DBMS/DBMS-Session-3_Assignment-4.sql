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