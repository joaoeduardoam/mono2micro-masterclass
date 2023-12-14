-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

create sequence flight_sequence start with 1 increment by 1;
INSERT INTO Flight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('flight_sequence'), 1, 'THE', 'AAA');
--INSERT INTO Flight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('flight_sequence'), 2, 'THE', 'BBB');
--INSERT INTO Flight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('flight_sequence'), 3, 'THE', 'CCC');
ALTER SEQUENCE flight_sequence RESTART WITH 10;