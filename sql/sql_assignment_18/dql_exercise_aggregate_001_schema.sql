-- ============================================================
-- Sales & Inventory Schema
-- NOTE: This file is provided solely to supply a working schema
-- and dataset. Associates should focus on the query exercises
-- in the accompanying instructions file.
-- ============================================================

CREATE TABLE Region (
    region_id   INT PRIMARY KEY,
    region_name VARCHAR(100) NOT NULL
);

CREATE TABLE Salesperson (
    salesperson_id   INT PRIMARY KEY,
    region_id        INT NOT NULL,
    salesperson_name VARCHAR(100) NOT NULL,
    FOREIGN KEY (region_id) REFERENCES Region(region_id)
);

CREATE TABLE Product (
    product_id   INT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    unit_cost    NUMERIC(10,2) NOT NULL,
    unit_price   NUMERIC(10,2) NOT NULL
);

CREATE TABLE Sale (
    sale_id        INT PRIMARY KEY,
    salesperson_id INT NOT NULL,
    product_id     INT NOT NULL,
    quantity       INT NOT NULL,
    sale_date      DATE NOT NULL,
    FOREIGN KEY (salesperson_id) REFERENCES Salesperson(salesperson_id),
    FOREIGN KEY (product_id)     REFERENCES Product(product_id)
);

-- ------------------------------------------------------------
-- Data
-- ------------------------------------------------------------

INSERT INTO Region VALUES
(1, 'North'),
(2, 'South'),
(3, 'East'),
(4, 'West');

INSERT INTO Salesperson VALUES
(1, 1, 'Dana Reeves'),
(2, 1, 'Leo Marsh'),
(3, 2, 'Priya Anand'),
(4, 2, 'Sam Okafor'),
(5, 3, 'Cleo Vance'),
(6, 3, 'Jordan Hale'),
(7, 4, 'Mia Sorrel'),
(8, 4, 'Finn Calloway');

INSERT INTO Product VALUES
(1,  'Wireless Mouse',       12.00,  29.99),
(2,  'USB-C Hub',            18.50,  49.99),
(3,  'Mechanical Keyboard',  42.00,  99.99),
(4,  'Laptop Stand',         15.00,  39.99),
(5,  'Webcam HD',            28.00,  74.99),
(6,  'Monitor Light Bar',     9.50,  34.99),
(7,  'Desk Organiser',        6.00,  18.99),
(8,  'Cable Management Kit',  4.00,  12.99),
(9,  'Ergonomic Wrist Rest',  7.50,  22.99),
(10, 'Portable SSD 1TB',     55.00, 129.99);

INSERT INTO Sale VALUES
(1,  1, 1,  3, '2024-01-05'),
(2,  1, 2,  2, '2024-01-08'),
(3,  1, 6,  5, '2024-01-12'),
(4,  2, 1,  4, '2024-01-15'),
(5,  2, 7,  6, '2024-01-18'),
(6,  2, 8,  8, '2024-01-22'),
(7,  3, 3,  2, '2024-01-25'),
(8,  3, 1,  5, '2024-01-28'),
(9,  3, 6,  4, '2024-02-01'),
(10, 4, 4,  3, '2024-02-03'),
(11, 4, 7,  7, '2024-02-06'),
(12, 4, 2,  2, '2024-02-09'),
(13, 5, 1,  6, '2024-02-12'),
(14, 5, 3,  1, '2024-02-14'),
(15, 5, 9,  4, '2024-02-17'),
(16, 6, 6,  6, '2024-02-20'),
(17, 6, 8,  9, '2024-02-23'),
(18, 6, 1,  4, '2024-02-26'),
(19, 7, 2,  3, '2024-03-01'),
(20, 7, 4,  5, '2024-03-04'),
(21, 7, 7,  8, '2024-03-07'),
(22, 8, 3,  2, '2024-03-10'),
(23, 8, 1,  5, '2024-03-13'),
(24, 8, 6,  3, '2024-03-16'),
(25, 1, 4,  4, '2024-03-19'),
(26, 1, 1,  6, '2024-03-22'),
(27, 2, 3,  1, '2024-03-25'),
(28, 2, 9,  5, '2024-03-28'),
(29, 3, 7,  9, '2024-04-01'),
(30, 3, 2,  3, '2024-04-04'),
(31, 4, 1,  7, '2024-04-07'),
(32, 4, 6,  5, '2024-04-10'),
(33, 5, 4,  3, '2024-04-13'),
(34, 5, 8,  6, '2024-04-16'),
(35, 6, 3,  2, '2024-04-19'),
(36, 6, 7,  7, '2024-04-22'),
(37, 7, 1,  4, '2024-04-25'),
(38, 7, 10, 1, '2024-04-28'),
(39, 8, 2,  2, '2024-05-01'),
(40, 8, 9,  4, '2024-05-04'),
(41, 1, 7,  5, '2024-05-07'),
(42, 2, 1,  3, '2024-05-10'),
(43, 3, 6,  6, '2024-05-13'),
(44, 4, 3,  2, '2024-05-16'),
(45, 5, 1,  7, '2024-05-19'),
(46, 6, 4,  4, '2024-05-22'),
(47, 7, 8,  5, '2024-05-25'),
(48, 8, 7,  6, '2024-05-28'),
(49, 1, 10, 1, '2024-06-01'),
(50, 2, 6,  4, '2024-06-04'),
(51, 3, 1,  5, '2024-06-07'),
(52, 4, 9,  3, '2024-06-10'),
(53, 5, 2,  2, '2024-06-13'),
(54, 6, 10, 1, '2024-06-16'),
(55, 7, 3,  3, '2024-06-19'),
(56, 8, 1,  4, '2024-06-22'),
(57, 1, 8,  7, '2024-06-25'),
(58, 2, 4,  3, '2024-06-28');
