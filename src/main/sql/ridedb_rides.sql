create table rides
(
    id          int          not null
        primary key,
    source      varchar(200) null,
    destination varchar(200) null,
    start_time  timestamp    null,
    end_time    timestamp    null,
    offer_id    int          null,
    ride_status tinyint(1)   null,
    constraint rides_offers_offer_id_fk
        foreign key (offer_id) references offers (offer_id)
);

