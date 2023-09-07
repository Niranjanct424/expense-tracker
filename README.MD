…or create a new repository on the command line
echo "# expense-tracker" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Niranjanct424/expense-tracker.git
git push -u origin main
…or push an existing repository from the command line
git remote add origin https://github.com/Niranjanct424/expense-tracker.git
git branch -M main
git push -u origin main


clone: 
https://github.com/Niranjanct424/expense-tracker.git


db:

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE expenses (
    expense_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    expense_date DATE,
    expense_description VARCHAR(255) NOT NULL,
    expense_title VARCHAR(255) NOT NULL,  -- New column
    amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);





--------------------------------------------------
USE expensetracker;

-- Create 'users' table
CREATE TABLE IF NOT EXISTS users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create 'expenses' table
CREATE TABLE IF NOT EXISTS expenses (
    expense_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    expense_date DATE,
    expense_description VARCHAR(255) NOT NULL,
    expense_title VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);



-------------------------------------------------------
DELIMITER //

-- Procedure: InsertExpense
-- Description: Inserts a new expense record into the expenses table.
-- Parameters:
--   p_user_id INT - The user ID associated with the expense.
--   p_expense_date DATE - The date of the expense.
--   p_expense_description VARCHAR(255) - A brief description of the expense.
--   p_item VARCHAR(255) - The name of the expense item.
--   p_amount DECIMAL(10, 2) - The amount of the expense.
--   p_result INT OUT - Output parameter for success (1) or failure (0).
--
-- Returns: INT - The ID of the newly inserted expense record.
--
CREATE PROCEDURE InsertExpense(
    IN p_user_id INT,
    IN p_expense_date DATE,
    IN p_expense_description VARCHAR(255),
    IN p_item VARCHAR(255),
    IN p_amount DECIMAL(10, 2),
    OUT p_result INT
)
BEGIN
    -- Initialize the result parameter to 0 (failure)
    SET p_result = 0;
    
    -- Insert the expense record
    INSERT INTO expenses (user_id, expense_date, expense_description, expense_title, amount)
    VALUES (p_user_id, p_expense_date, p_expense_description, p_item, p_amount);

    -- Check if the insert was successful (1 row affected)
    IF ROW_COUNT() = 1 THEN
        -- Set the result parameter to 1 (success)
        SET p_result = 1;
    END IF;
END;
//
DELIMITER ;

----------------------------------------------------------------------------------------------