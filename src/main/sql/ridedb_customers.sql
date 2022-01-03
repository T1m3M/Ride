create table customers
(
    id             int          not null
        primary key,
    username       varchar(200) null,
    mobile         varchar(200) null,
    password       varchar(200) null,
    account_status tinyint(1)   null,
    birthdate      date         null
);

INSERT INTO ridedb.customers (id, username, mobile, password, account_status, birthdate) VALUES (1, 'bahaa', '111', '111', 1, '1999-04-20');
INSERT INTO ridedb.customers (id, username, mobile, password, account_status, birthdate) VALUES (2, 'mohamed', '112', '112', 0, '1999-05-20');
INSERT INTO ridedb.customers (id, username, mobile, password, account_status, birthdate) VALUES (3, 'tamer', '113', '113', 1, '1999-07-13');
INSERT INTO ridedb.customers (id, username, mobile, password, account_status, birthdate) VALUES (4, 'Hassan', '555', '555', 1, '2002-01-03');
