CREATE TABLE IF NOT EXISTS user (
	id IDENTITY NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS car (
	id  INT IDENTITY NOT NULL PRIMARY KEY AUTO_INCREMENT,
	producer VARCHAR(20) NOT NULL,
	model VARCHAR(20) NOT NULL, 
	number_plate VARCHAR(6) NOT NULL UNIQUE,
	user_id INT,

	FOREIGN KEY (user_id) REFERENCES user(id)
);