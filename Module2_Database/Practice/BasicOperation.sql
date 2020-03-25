use classicmodels;

SELECT * FROM customers;

UPDATE customers SET addressLine2='Level 2'
WHERE customerNumber = '103';

DELETE FROM `customers` WHERE `customerNumber`='103';