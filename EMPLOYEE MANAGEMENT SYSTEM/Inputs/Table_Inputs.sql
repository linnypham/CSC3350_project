Employee Table Inputs:
INSERT INTO Employee (empId, name, division, jobTitle, salary, ssn) VALUES
(812122105, 'Viola Davis', 'Marketing', 'Assistant Advisor', 29200.00, '041820983'),
(120884097, 'Julia Roberts', 'Legal', 'Policy Advisor', 27000.00, '489302567'),
(472202073, 'John Wick', 'Security', 'Security Guard', 23000.00, '765849307'),
(386786129, 'Michael Johnson', 'Finance', 'Financial Analyst', 58000.00, '123456789'),
(990783579, 'Sarah Connor', 'Operations', 'Operations Manager', 62000.00, '987654321'),
(170322558, 'Tony Stark', 'Engineering', 'Chief Engineer', 90000.00, '135792468'),
(948053607, 'Diana Prince', 'Human Resources', 'HR Specialist', 45000.00, '246813579'),
(516743903, 'Clark Kent', 'Communications', 'Communications Director', 67000.00, '321654987'),
(601376829, 'Bruce Wayne', 'Security', 'Security Specialist', 75000.00, '789456123'),
(102609667, 'Natasha Romanoff', 'Intelligence', 'Intelligence Analyst', 70000.00, '159753486'),
(374715660, 'Peter Parker', 'IT', 'IT Support Specialist', 41000.00, '456789123'),
(655083760, 'Steve Rogers', 'Public Relations', 'PR Manager', 55000.00, '951753486'),
(487713084, 'Wanda Maximoff', 'Research and Development', 'R&D Scientist', 68000.00, '753951486');


TestTable Table Inputs:
INSERT INTO TestTable (empid, name) VALUES
(1, 'Alice'),
(2, 'Bob'),
(3, 'Charlie'),
(4, 'Diana'),
(5, 'Ethan');


 
PayStatement table inputs:
INSERT INTO PayStatement (transactionID, empId, payDate, amount) VALUES
-- Data for 2023
-- Employee 102609667
(20230101001, 102609667, '2023-01-01', 5833.33),
(20230201001, 102609667, '2023-02-01', 5833.33),
(20230301001, 102609667, '2023-03-01', 5833.33),
(20230401001, 102609667, '2023-04-01', 5833.33),
(20230501001, 102609667, '2023-05-01', 5833.33),
(20230601001, 102609667, '2023-06-01', 5833.33),
(20230701001, 102609667, '2023-07-01', 5833.33),
(20230801001, 102609667, '2023-08-01', 5833.33),
(20230901001, 102609667, '2023-09-01', 5833.33),
(20231001001, 102609667, '2023-10-01', 5833.33),
(20231101001, 102609667, '2023-11-01', 5833.33),
(20231201001, 102609667, '2023-12-01', 5833.33),

-- Employee 120884097
(20230101004, 120884097, '2023-01-01', 2250.00),
(20230201004, 120884097, '2023-02-01', 2250.00),
(20230301004, 120884097, '2023-03-01', 2250.00),
(20230401004, 120884097, '2023-04-01', 2250.00),
(20230501004, 120884097, '2023-05-01', 2250.00),
(20230601004, 120884097, '2023-06-01', 2250.00),
(20230701004, 120884097, '2023-07-01', 2250.00),
(20230801004, 120884097, '2023-08-01', 2250.00),
(20230901004, 120884097, '2023-09-01', 2250.00),
(20231001004, 120884097, '2023-10-01', 2250.00),
(20231101004, 120884097, '2023-11-01', 2250.00),
(20231201004, 120884097, '2023-12-01', 2250.00),

-- Employee 170322558
(20230101007, 170322558, '2023-01-01', 7500.00),
(20230201007, 170322558, '2023-02-01', 7500.00),
(20230301007, 170322558, '2023-03-01', 7500.00),
(20230401007, 170322558, '2023-04-01', 7500.00),
(20230501007, 170322558, '2023-05-01', 7500.00),
(20230601007, 170322558, '2023-06-01', 7500.00),
(20230701007, 170322558, '2023-07-01', 7500.00),
(20230801007, 170322558, '2023-08-01', 7500.00),
(20230901007, 170322558, '2023-09-01', 7500.00),
(20231001007, 170322558, '2023-10-01', 7500.00),
(20231101007, 170322558, '2023-11-01', 7500.00),
(20231201007, 170322558, '2023-12-01', 7500.00),

-- Employee 374715660
(20230101010, 374715660, '2023-01-01', 3416.67),
(20230201010, 374715660, '2023-02-01', 3416.67),
(20230301010, 374715660, '2023-03-01', 3416.67),
(20230401010, 374715660, '2023-04-01', 3416.67),
(20230501010, 374715660, '2023-05-01', 3416.67),
(20230601010, 374715660, '2023-06-01', 3416.67),
(20230701010, 374715660, '2023-07-01', 3416.67),
(20230801010, 374715660, '2023-08-01', 3416.67),
(20230901010, 374715660, '2023-09-01', 3416.67),
(20231001010, 374715660, '2023-10-01', 3416.67),
(20231101010, 374715660, '2023-11-01', 3416.67),
(20231201010, 374715660, '2023-12-01', 3416.67),

-- Employee 386786129
(20230101013, 386786129, '2023-01-01', 4833.33),
(20230201013, 386786129, '2023-02-01', 4833.33),
(20230301013, 386786129, '2023-03-01', 4833.33),
(20230401013, 386786129, '2023-04-01', 4833.33),
(20230501013, 386786129, '2023-05-01', 4833.33),
(20230601013, 386786129, '2023-06-01', 4833.33),
(20230701013, 386786129, '2023-07-01', 4833.33),
(20230801013, 386786129, '2023-08-01', 4833.33),
(20230901013, 386786129, '2023-09-01', 4833.33),
(20231001013, 386786129, '2023-10-01', 4833.33),
(20231101013, 386786129, '2023-11-01', 4833.33),
(20231201013, 386786129, '2023-12-01', 4833.33),

-- Employee 472202073
(20230101016, 472202073, '2023-01-01', 1916.67),
(20230201016, 472202073, '2023-02-01', 1916.67),
(20230301016, 472202073, '2023-03-01', 1916.67),
(20230401016, 472202073, '2023-04-01', 1916.67),
(20230501016, 472202073, '2023-05-01', 1916.67),
(20230601016, 472202073, '2023-06-01', 1916.67),
(20230701016, 472202073, '2023-07-01', 1916.67),
(20230801016, 472202073, '2023-08-01', 1916.67),
(20230901016, 472202073, '2023-09-01', 1916.67),
(20231001016, 472202073, '2023-10-01', 1916.67),
(20231101016, 472202073, '2023-11-01', 1916.67),
(20231201016, 472202073, '2023-12-01', 1916.67),

-- Employee 487713084
(20230101019, 487713084, '2023-01-01', 5666.67),
(20230201019, 487713084, '2023-02-01', 5666.67),
(20230301019, 487713084, '2023-03-01', 5666.67),
(20230401019, 487713084, '2023-04-01', 5666.67),
(20230501019, 487713084, '2023-05-01', 5666.67),
(20230601019, 487713084, '2023-06-01', 5666.67),
(20230701019, 487713084, '2023-07-01', 5666.67),
(20230801019, 487713084, '2023-08-01', 5666.67),
(20230901019, 487713084, '2023-09-01', 5666.67),
(20231001019, 487713084, '2023-10-01', 5666.67),
(20231101019, 487713084, '2023-11-01', 5666.67),
(20231201019, 487713084, '2023-12-01', 5666.67),

-- Employee 516743903
(20230101022, 516743903, '2023-01-01', 5583.33),
(20230201022, 516743903, '2023-02-01', 5583.33),
(20230301022, 516743903, '2023-03-01', 5583.33),
(20230401022, 516743903, '2023-04-01', 5583.33),
(20230501022, 516743903, '2023-05-01', 5583.33),
(20230601022, 516743903, '2023-06-01', 5583.33),
(20230701022, 516743903, '2023-07-01', 5583.33),
(20230801022, 516743903, '2023-08-01', 5583.33),
(20230901022, 516743903, '2023-09-01', 5583.33),
(20231001022, 516743903, '2023-10-01', 5583.33),
(20231101022, 516743903, '2023-11-01', 5583.33),
(20231201022, 516743903, '2023-12-01', 5583.33),

-- Employee 601376829
(20230101025, 601376829, '2023-01-01', 6250.00),
(20230201025, 601376829, '2023-02-01', 6250.00),
(20230301025, 601376829, '2023-03-01', 6250.00),
(20230401025, 601376829, '2023-04-01', 6250.00),
(20230501025, 601376829, '2023-05-01', 6250.00),
(20230601025, 601376829, '2023-06-01', 6250.00),
(20230701025, 601376829, '2023-07-01', 6250.00),
(20230801025, 601376829, '2023-08-01', 6250.00),
(20230901025, 601376829, '2023-09-01', 6250.00),
(20231001025, 601376829, '2023-10-01', 6250.00),
(20231101025, 601376829, '2023-11-01', 6250.00),
(20231201025, 601376829, '2023-12-01', 6250.00),

-- Employee 655083760
(20230101028, 655083760, '2023-01-01', 4583.33),
(20230201028, 655083760, '2023-02-01', 4583.33),
(20230301028, 655083760, '2023-03-01', 4583.33),
(20230401028, 655083760, '2023-04-01', 4583.33),
(20230501028, 655083760, '2023-05-01', 4583.33),
(20230601028, 655083760, '2023-06-01', 4583.33),
(20230701028, 655083760, '2023-07-01', 4583.33),
(20230801028, 655083760, '2023-08-01', 4583.33),
(20230901028, 655083760, '2023-09-01', 4583.33),
(20231001028, 655083760, '2023-10-01', 4583.33),
(20231101028, 655083760, '2023-11-01', 4583.33),
(20231201028, 655083760, '2023-12-01', 4583.33),

-- Employee 812122105
(20230101031, 812122105, '2023-01-01', 2433.33),
(20230201031, 812122105, '2023-02-01', 2433.33),
(20230301031, 812122105, '2023-03-01', 2433.33),
(20230401031, 812122105, '2023-04-01', 2433.33),
(20230501031, 812122105, '2023-05-01', 2433.33),
(20230601031, 812122105, '2023-06-01', 2433.33),
(20230701031, 812122105, '2023-07-01', 2433.33),
(20230801031, 812122105, '2023-08-01', 2433.33),
(20230901031, 812122105, '2023-09-01', 2433.33),
(20231001031, 812122105, '2023-10-01', 2433.33),
(20231101031, 812122105, '2023-11-01', 2433.33),
(20231201031, 812122105, '2023-12-01', 2433.33),

-- Employee 948053607
(20230101034, 948053607, '2023-01-01', 3750.00),
(20230201034, 948053607, '2023-02-01', 3750.00),
(20230301034, 948053607, '2023-03-01', 3750.00),
(20230401034, 948053607, '2023-04-01', 3750.00),
(20230501034, 948053607, '2023-05-01', 3750.00),
(20230601034, 948053607, '2023-06-01', 3750.00),
(20230701034, 948053607, '2023-07-01', 3750.00),
(20230801034, 948053607, '2023-08-01', 3750.00),
(20230901034, 948053607, '2023-09-01', 3750.00),
(20231001034, 948053607, '2023-10-01', 3750.00),
(20231101034, 948053607, '2023-11-01', 3750.00),
(20231201034, 948053607, '2023-12-01', 3750.00),

-- Employee 990783579
(20230101037, 990783579, '2023-01-01', 5166.67),
(20230201037, 990783579, '2023-02-01', 5166.67),
(20230301037, 990783579, '2023-03-01', 5166.67),
(20230401037, 990783579, '2023-04-01', 5166.67),
(20230501037, 990783579, '2023-05-01', 5166.67),
(20230601037, 990783579, '2023-06-01', 5166.67),
(20230701037, 990783579, '2023-07-01', 5166.67),
(20230801037, 990783579, '2023-08-01', 5166.67),
(20230901037, 990783579, '2023-09-01', 5166.67),
(20231001037, 990783579, '2023-10-01', 5166.67),
(20231101037, 990783579, '2023-11-01', 5166.67),
(20231201037, 990783579, '2023-12-01', 5166.67);
