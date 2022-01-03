create table offers
(
    id             int        not null
        primary key,
    ride_id        int        null,
    driver_id      int        null,
    price          float      null,
    after_discount float      null,
    offer_time     timestamp  null,
    accept_time    timestamp  null,
    offer_status   tinyint(1) null,
    constraint offers_drivers_id_fk
        foreign key (driver_id) references drivers (id),
    constraint offers_rides_id_fk
        foreign key (ride_id) references rides (id)
);

INSERT INTO ridedb.offers (id, ride_id, driver_id, price, after_discount, offer_time, accept_time, offer_status) VALUES (1, 1, 1, 100, null, '2022-01-02 12:43:00', '2022-01-02 14:20:26', 0);
INSERT INTO ridedb.offers (id, ride_id, driver_id, price, after_discount, offer_time, accept_time, offer_status) VALUES (2, 3, 3, 200, null, '2022-01-03 06:44:09', '2022-01-03 06:44:09', 0);
INSERT INTO ridedb.offers (id, ride_id, driver_id, price, after_discount, offer_time, accept_time, offer_status) VALUES (3, 2, 4, 120, null, '2022-01-03 07:28:57', '2022-01-03 07:28:57', 0);
INSERT INTO ridedb.offers (id, ride_id, driver_id, price, after_discount, offer_time, accept_time, offer_status) VALUES (4, 4, 3, 100, 60, '2022-01-03 12:16:19', null, 1);
