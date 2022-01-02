create table rides
(
    id                   int          not null
        primary key,
    customer_id          int          null,
    source               varchar(200) null,
    destination          varchar(200) null,
    number_of_passengers int          null,
    start_time           timestamp    null,
    end_time             timestamp    null,
    offer_id             int          null,
    ride_status          tinyint(1)   null,
    constraint rides_customers_id_fk
        foreign key (customer_id) references customers (id),
    constraint rides_offers_offer_id_fk
        foreign key (offer_id) references offers (offer_id)
);

INSERT INTO ridedb.rides (id, customer_id, source, destination, number_of_passengers, start_time, end_time, offer_id, ride_status) VALUES (1, 1, 'Dokki', 'Haram', 2, null, null, null, 1);
