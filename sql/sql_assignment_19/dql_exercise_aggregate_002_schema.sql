-- ============================================================
-- Product & Sales Analysis Schema
-- NOTE: This file is provided solely to supply a working schema
-- and dataset. You do not need to modify it — simply run it to
-- set up your database before attempting the exercise.
-- ============================================================

CREATE TABLE Category (
    category_id   INT PRIMARY KEY,
    category_name VARCHAR(100) NOT NULL
);

CREATE TABLE Product (
    product_id    INT PRIMARY KEY,
    category_id   INT NOT NULL,
    product_name  VARCHAR(100) NOT NULL,
    unit_cost     NUMERIC(10,2) NOT NULL,
    unit_price    NUMERIC(10,2) NOT NULL,
    stock_quantity INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Category(category_id)
);

CREATE TABLE Sale (
    sale_id       INT PRIMARY KEY,
    product_id    INT NOT NULL,
    quantity_sold INT NOT NULL,
    sale_date     DATE NOT NULL,
    FOREIGN KEY (product_id) REFERENCES Product(product_id)
);

-- ------------------------------------------------------------
-- Data
-- ------------------------------------------------------------

INSERT INTO Category VALUES
(1, 'Electronics'),
(2, 'Office Supplies'),
(3, 'Ergonomics'),
(4, 'Storage'),
(5, 'Lighting');

INSERT INTO Product VALUES
-- Electronics
(1,  1, 'Wireless Mouse',              12.00,  29.99, 120),
(2,  1, 'USB-C Hub',                   18.50,  49.99,  85),
(3,  1, 'Mechanical Keyboard',         42.00,  99.99,  60),
(4,  1, 'Webcam HD',                   28.00,  74.99,  45),
(5,  1, 'Bluetooth Numpad',            14.00,  34.99,  70),
-- Office Supplies
(6,  2, 'Gel Pen Set',                  3.50,   9.99, 200),
(7,  2, 'Sticky Notes Multipack',       2.00,   5.99, 300),
(8,  2, 'Desk Organiser',               6.00,  18.99,  90),
(9,  2, 'Whiteboard Markers',           4.00,  11.99, 150),
(10, 2, 'A4 Notebook',                  2.50,   7.49, 250),
-- Ergonomics
(11, 3, 'Ergonomic Wrist Rest',         7.50,  22.99,  80),
(12, 3, 'Laptop Stand',                15.00,  39.99,  75),
(13, 3, 'Monitor Arm',                 32.00,  79.99,  40),
(14, 3, 'Adjustable Footrest',         18.00,  44.99,  55),
-- Storage
(15, 4, 'Portable SSD 1TB',            55.00, 129.99,  30),
(16, 4, 'Cable Management Kit',         4.00,  12.99, 180),
(17, 4, 'USB Flash Drive 64GB',         5.50,  14.99, 220),
(18, 4, 'SD Card Reader',               6.00,  16.99, 140),
-- Lighting
(19, 5, 'Monitor Light Bar',            9.50,  34.99,  95),
(20, 5, 'LED Desk Lamp',               14.00,  38.99,  65);

INSERT INTO Sale VALUES
(1,  1,  12, '2024-01-05'),
(2,  1,   8, '2024-01-18'),
(3,  1,  15, '2024-02-03'),
(4,  1,  10, '2024-02-21'),
(5,  1,   9, '2024-03-14'),
(6,  2,   6, '2024-01-09'),
(7,  2,   4, '2024-02-12'),
(8,  2,   7, '2024-03-08'),
(9,  3,   3, '2024-01-22'),
(10, 3,   5, '2024-02-28'),
(11, 3,   4, '2024-03-19'),
(12, 4,   6, '2024-01-15'),
(13, 4,   8, '2024-02-09'),
(14, 5,  11, '2024-01-28'),
(15, 5,   9, '2024-03-01'),
(16, 6,  40, '2024-01-06'),
(17, 6,  35, '2024-02-14'),
(18, 6,  28, '2024-03-22'),
(19, 7,  55, '2024-01-10'),
(20, 7,  48, '2024-02-05'),
(21, 7,  60, '2024-03-17'),
(22, 8,  14, '2024-01-19'),
(23, 8,  18, '2024-02-26'),
(24, 9,  22, '2024-01-30'),
(25, 9,  19, '2024-03-11'),
(26, 10, 30, '2024-02-08'),
(27, 10, 25, '2024-03-25'),
(28, 11, 16, '2024-01-14'),
(29, 11, 12, '2024-02-20'),
(30, 12,  9, '2024-01-25'),
(31, 12,  7, '2024-03-06'),
(32, 13,  5, '2024-02-17'),
(33, 13,  4, '2024-03-29'),
(34, 14,  8, '2024-01-31'),
(35, 14,  6, '2024-02-22'),
(36, 15,  3, '2024-01-08'),
(37, 15,  2, '2024-02-19'),
(38, 15,  4, '2024-03-13'),
(39, 16, 35, '2024-01-17'),
(40, 16, 42, '2024-02-24'),
(41, 16, 38, '2024-03-20'),
(42, 17, 50, '2024-01-23'),
(43, 17, 45, '2024-02-11'),
(44, 17, 52, '2024-03-04'),
(45, 18, 20, '2024-01-29'),
(46, 18, 17, '2024-03-16'),
(47, 19, 22, '2024-01-07'),
(48, 19, 18, '2024-02-16'),
(49, 19, 25, '2024-03-23'),
(50, 20, 14, '2024-01-12'),
(51, 20, 11, '2024-02-27'),
(52, 20, 16, '2024-03-09');
