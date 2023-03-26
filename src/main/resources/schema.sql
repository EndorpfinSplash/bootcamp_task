CREATE TABLE IF NOT EXISTS users
(
    id         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    surname    varchar(40) NOT NULL,
    name       varchar(20) NOT NULL,
    patronymic varchar(40) NOT NULL,
    email      varchar(50) NOT NULL unique ,
    role       varchar(50) NOT NULL
    );
