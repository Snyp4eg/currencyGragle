DROP TABLE banks IF EXISTS;
DROP TABLE currency IF EXISTS;
DROP TABLE operations IF EXISTS;

CREATE TABLE banks
(
    bank_id int NOT NULL PRIMARY KEY,
    bank_name varchar(255)
);
CREATE TABLE currency
(
    currency_id int NOT NULL PRIMARY KEY,
    currency_name varchar(255)
);
CREATE TABLE operations (
    operations_id varchar(255) NOT NULL PRIMARY KEY,
	buy_price int not null,
	sell_price int not null
)
