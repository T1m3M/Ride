create table admins
(
    id       int          not null
        primary key,
    username varchar(200) null,
    mobile   varchar(200) null,
    password varchar(200) null
);

INSERT INTO ridedb.admins (id, username, mobile, password) VALUES (1, 'abdelrahman', '123', '123');
INSERT INTO ridedb.admins (id, username, mobile, password) VALUES (2, 'admin', '456', '456');
INSERT INTO ridedb.admins (id, username, mobile, password) VALUES (3, 'admin', '457', '457');
