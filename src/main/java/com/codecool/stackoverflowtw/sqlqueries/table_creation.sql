CREATE TABLE questions (
                           id SERIAL PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           description VARCHAR(255) NOT NULL,
                           created TIMESTAMP
);