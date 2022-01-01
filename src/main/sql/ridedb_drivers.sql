create table drivers
(
    id                  int          not null
        primary key,
    username            varchar(200) null,
    mobile              varchar(200) null,
    password            varchar(200) null,
    account_status      tinyint(1)   null,
    national_id         varchar(200) null,
    driver_license      varchar(200) null,
    average_rating      float        null,
    verification_status tinyint(1)   null
);

INSERT INTO ridedb.drivers (id, username, mobile, password, account_status, national_id, driver_license, average_rating, verification_status) VALUES (1, 'tawaty', '999', '999', 1, '888', '777', 0, 0);
INSERT INTO ridedb.drivers (id, username, mobile, password, account_status, national_id, driver_license, average_rating, verification_status) VALUES (2, 'omar', '1001', '999', 1, '888', '888', 0, 0);
