create table holidays
(
    id           int  not null
        primary key,
    holiday_date date null
);

INSERT INTO ridedb.holidays (id, holiday_date) VALUES (1, '2022-01-03');
