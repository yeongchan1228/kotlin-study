DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id bigint NOT NULL AUTO_INCREMENT,
    email varchar(30),
    username varchar(50),
    password varchar(100),
    profile_url varchar(100),
    created_date timestamp default NOW(),
    last_modified_date timestamp default NOW(),
    primary key (id)
)