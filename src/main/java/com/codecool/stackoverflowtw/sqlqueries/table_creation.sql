CREATE TABLE questions (
                           id SERIAL PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           description VARCHAR(255) NOT NULL,
                           created TIMESTAMP
);

CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       created TIMESTAMP
);