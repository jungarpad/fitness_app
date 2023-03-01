DROP TABLE IF EXISTS workout;
DROP TABLE IF EXISTS exercise;
CREATE TABLE workout (
        id SERIAL PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        duration INT NOT NULL,
        difficulty VARCHAR(20) NOT NULL
    );

    CREATE TABLE exercise (
        id SERIAL PRIMARY KEY,
        name VARCHAR(50) NOT NULL,
        calories_burned INT NOT NULL,
        muscle_group VARCHAR(10) NOT NULL
    );