INSERT INTO FLIGHT(flight_id,airline,departure,arrival,flight_type,cost,flight_start,flight_end) VALUES  (1,'Indigo','Delhi','Mumbai','BUSINESS','1200','2023-05-01','2023-05-05');
INSERT INTO FLIGHT(flight_id,airline,departure,arrival,flight_type,cost,flight_start,flight_end) VALUES  (2,'Indigo','Mumbai','Delhi','BUSINESS','1200','2023-05-01','2023-05-05');
INSERT INTO FLIGHT(flight_id,airline,departure,arrival,flight_type,cost,flight_start,flight_end) VALUES  (3,'Indigo','Delhi','Pune','BUSINESS','1200','2023-05-01','2023-05-05');
INSERT INTO FLIGHT(flight_id,airline,departure,arrival,flight_type,cost,flight_start,flight_end) VALUES  (4,'Indigo','Bangalore','Mumbai','BUSINESS','1200','2023-05-01','2023-05-05');

INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (1,true,1,'A1');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (2,true,1,'A2');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (3,false,1,'A3');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (4,true,2,'A1');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (5,true,2,'A2');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (6,false,2,'A3');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (7,true,3,'A1');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (8,true,3,'A2');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (9,false,3,'A3');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (10,true,4,'A1');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (11,true,4,'A2');
INSERT INTO SEAT(seat_id,available,flight_id,seat_name) VALUES (12,false,4,'A3');
