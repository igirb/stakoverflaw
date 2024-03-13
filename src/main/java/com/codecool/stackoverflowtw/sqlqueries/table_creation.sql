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
)

