create table offers
(
    id           int        not null
        primary key,
    ride_id      int        null,
    driver_id    int        null,
    price        float      null,
    offer_time   timestamp  null,
    accept_time  timestamp  null,
    offer_status tinyint(1) null,
    constraint offers_drivers_id_fk
        foreign key (driver_id) references drivers (id),
    constraint offers_rides_id_fk
        foreign key (ride_id) references rides (id)
);

INSERT INTO ridedb.offers (id, ride_id, driver_id, price, offer_time, accept_time, offer_status) VALUES (1, 1, 1, 100, '2022-01-02 12:43:00', '2022-01-02 14:20:26', 0);
