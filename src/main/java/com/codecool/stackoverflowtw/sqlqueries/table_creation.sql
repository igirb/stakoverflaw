
CREATE TABLE IF NOT EXISTS questions
(
    id          SERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created     TIMESTAMP
);

CREATE TABLE IF NOT EXISTS answers
(
    id          SERIAL PRIMARY KEY,
    message     VARCHAR(255) NOT NULL,
    submission  TIMESTAMP,
    question_id INT REFERENCES questions (id)
);


CREATE TABLE IF NOT EXISTS users (
                       user_id SERIAL PRIMARY KEY,
                       username VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       created TIMESTAMP
);

ALTER TABLE questions
ADD answer_count int DEFAULT 0;


UPDATE questions SET answer_count = answer_count + 1 WHERE id = 15

UPDATE questions SET answer_count = answer_count + 1 WHERE id = 14;
ALTER SEQUENCE answers_id_seq RESTART WITH 1;

