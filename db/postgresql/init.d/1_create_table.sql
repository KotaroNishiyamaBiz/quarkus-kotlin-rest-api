create table users
(
    id         serial PRIMARY KEY NOT NULL,
    first_name varchar(32) NOT NULL,
    last_name  varchar(32) NOT NULL,
    created    timestamp NOT NULL
);