create table areas
(
    id        int          not null
        primary key,
    area_name varchar(200) null,
    discount  float        null
);

INSERT INTO ridedb.areas (id, area_name, discount) VALUES (1, 'Dokki', 0);
INSERT INTO ridedb.areas (id, area_name, discount) VALUES (2, 'Haram', 0);
