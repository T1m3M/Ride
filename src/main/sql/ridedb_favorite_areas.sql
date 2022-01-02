create table favorite_areas
(
    id        int          not null
        primary key,
    area_name varchar(200) null,
    driver_id int          null,
    constraint favorite_areas_drivers_id_fk
        foreign key (driver_id) references drivers (id)
);

INSERT INTO ridedb.favorite_areas (id, area_name, driver_id) VALUES (1, 'Dokki', 1);
INSERT INTO ridedb.favorite_areas (id, area_name, driver_id) VALUES (2, 'Dokki', 3);
