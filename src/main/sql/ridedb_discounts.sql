create table discounts
(
    id        int          not null
        primary key,
    area_name varchar(200) null,
    rate      float        null
);

INSERT INTO ridedb.discounts (id, area_name, rate) VALUES (1, 'Dokki', 10);
INSERT INTO ridedb.discounts (id, area_name, rate) VALUES (2, 'Haram', 10);
