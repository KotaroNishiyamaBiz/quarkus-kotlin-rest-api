create table sampledb.users
(
    id         int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name varchar(32) NOT NULL,
    last_name  varchar(32) NOT NULL,
    created    datetime NOT NULL
);