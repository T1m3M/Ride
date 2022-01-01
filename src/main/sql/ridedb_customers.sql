create table customers
(
    id             int          not null
        primary key,
    username       varchar(200) null,
    mobile         varchar(200) null,
    password       varchar(200) null,
    account_status tinyint(1)   null
);

INSERT INTO ridedb.customers (id, username, mobile, password, account_status) VALUES (1, 'bahaa', '111', '111', 1);
INSERT INTO ridedb.customers (id, username, mobile, password, account_status) VALUES (2, 'mohamed', '112', '112', 1);
