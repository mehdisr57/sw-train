-- PRODUCT --------------------------------------------------------------
INSERT INTO product (id, name) VALUES ('#1', 'Monitor');
INSERT INTO product (id, name) VALUES ('#2', 'CPU');
INSERT INTO product (id, name) VALUES ('#3', 'HDD');
INSERT INTO product (id, name) VALUES ('#4', 'Main Board');
-- PRODUCT_PRICE --------------------------------------------------------
INSERT INTO product_price (id, product_id, price_date, price, active) VALUES ('#1', '#3', '2023-05-15 10:49', '1000', null);
INSERT INTO product_price (id, product_id, price_date, price, active) VALUES ('#2', '#3', '2023-05-16 10:49', '1001', null);
INSERT INTO product_price (id, product_id, price_date, price, active) VALUES ('#3', '#3', '2023-05-17 10:49', '1002', true);
INSERT INTO product_price (id, product_id, price_date, price, active) VALUES ('#4', '#4', '2023-05-15 10:49', '2000', null);
INSERT INTO product_price (id, product_id, price_date, price, active) VALUES ('#5', '#4', '2023-05-16 10:49', '3000', null);
INSERT INTO product_price (id, product_id, price_date, price, active) VALUES ('#6', '#4', '2023-05-17 10:49', '4000', true);
