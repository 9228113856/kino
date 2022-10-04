CREATE TABLE films (id serial AUTO_INCREMENT PRIMARY KEY,
                    kinopoiskId INT NOT NULL,
                    nameRu VARCHAR(500),
                    year VARCHAR(50),
                    ratingKinopoisk INT,
                    ratingImdb INT,
                    description VARCHAR(1000));