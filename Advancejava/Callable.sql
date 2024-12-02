/*
DELIMITER $

CREATE PROCEDURE getcnt(IN age_threshold INT, OUT user_count INT)
BEGIN
    SELECT COUNT(*) INTO user_count
    FROM my_table
    WHERE age >= age_threshold;
END $

DELIMITER ;
*/

DELIMITER $

CREATE PROCEDURE GetUser (IN p_uname VARCHAR(50), IN p_password VARCHAR(50))
BEGIN
    SELECT * FROM user WHERE uname = p_uname AND password = p_password;
END $

DELIMITER ;