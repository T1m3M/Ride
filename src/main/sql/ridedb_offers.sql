create table offers
(
    offer_id     int        not null
        primary key,
    ride_id      int        null,
    driver_id    int        null,
    price        int        null,
    accept_time  timestamp  null,
    offer_time   timestamp  null,
    offer_status tinyint(1) null,
    constraint offers_drivers_id_fk
        foreign key (driver_id) references drivers (id),
    constraint offers_rides_id_fk
        foreign key (ride_id) references rides (id)
);

