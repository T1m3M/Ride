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
    verification_status tinyint(1)   null,
    available_status    tinyint(1)   null,
    seats_number        int          null
);

INSERT INTO ridedb.drivers (id, username, mobile, password, account_status, national_id, driver_license, average_rating, verification_status, available_status, seats_number) VALUES (1, 'tawaty', '999', '999', 1, '888', '777', 0, 1, 1, 2);
INSERT INTO ridedb.drivers (id, username, mobile, password, account_status, national_id, driver_license, average_rating, verification_status, available_status, seats_number) VALUES (2, 'omar', '1001', '1001', 0, '888', '888', 0, 0, 1, 4);
INSERT INTO ridedb.drivers (id, username, mobile, password, account_status, national_id, driver_license, average_rating, verification_status, available_status, seats_number) VALUES (3, 'hecker', '1337', '1337', 1, '1313', '1313', 0, 0, 1, 2);
INSERT INTO ridedb.drivers (id, username, mobile, password, account_status, national_id, driver_license, average_rating, verification_status, available_status, seats_number) VALUES (4, 'beluga', '1515', '1515', 1, '1515', '1515', 0, 0, 1, 6);
