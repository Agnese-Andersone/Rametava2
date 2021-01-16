drop database if exists rametava_warehouse;
create database rametava_warehouse;
use rametava_warehouse;

create table frame_profile (
   frame_id bigint auto_increment PRIMARY KEY,
   frame_name varchar(8) NOT NULL,
   frame_bar_std_length int NOT NULL,
   frame_price_eur_m decimal(10, 2) NOT NULL
);

insert into frame_profile (frame_name, frame_bar_std_length, frame_price_eur_m)
                    values('W1050', '3000', '10.47'),
						  ('3800-01', '3000', '12.85'),
						  ('3800-02', '3000', '12.85'),
						  ('3800-03', '3000', '12.85'),
						  ('3800-04', '3000', '12.85'),
						  ('169GR', '3000', '11.00'),
						  ('37GR', '3000', '9.59'),
						  ('5820GR', '3000', '7.25'),
						  ('6330GR', '3000', '10.59'),
						  ('GALGR', '3000', '19.70'),
						  ('2580OO', '3000', '27.00'),
						  ('6570-01', '2000', '17.80'),
						  ('6570-02', '2000', '16.95'),
						  ('6570-03', '2000', '16.95'),
						  ('6570-04', '2000', '16.95'),
						  ('6570-05', '2000', '16.95'),
						  ('6140-03', '3000', '23.00'),
						  ('6130-01', '3000', '22.80'),
						  ('6130-03', '3000', '22.80');

create table frame_profile_warehouse_balance (
				id bigint auto_increment primary key NOT NULL,
                frame_id bigint NOT NULL,
                frame_bar_count varchar(10) NOT NULL,
                frame_total_length varchar(20) NOT NULL,
                FOREIGN KEY (frame_id) REFERENCES frame_profile(frame_id)
                );
insert into frame_profile_warehouse_balance (frame_id, frame_bar_count, frame_total_length)
									values 	('1','12', '36000'),
											('2', '8', '26000'),
											('3','10', '33500'),
											('4','20', '56000'),
											('5','15', '42000'),
											('6','14', '31000'),
											('7','10', '39000'),
											('8','12', '35000'),
											('9','2', '31000'),
											('10','5', '19000'),
											('11','13', '26000'),
											('12','2', '1000'),
											('13','6', '31110'),
											('14','9', '31000'),
											('15','14', '33600'),
											('16','22', '44000'),
											('17','16', '10000'),
											('18','10', '33000'),
											('19','3', '12000');

create table glass (
   glass_id int auto_increment PRIMARY KEY,
   glass_name enum('none', 'museum', 'common', 'plexiglass') NOT NULL,
   glass_price_eur_m decimal(10, 2) NOT NULL
);
insert into glass (glass_name, glass_price_eur_m)
			values('museum', '300.00'),
				  ('common', '9.50'),
			      ('plexiglass', '12.70');

create table matt (
   matt_id int auto_increment PRIMARY KEY,
   matt_name varchar(8) NOT NULL,
   matt_board_std_height int NOT NULL,
   matt_board_std_width int NOT NULL,
   matt_price_eur_m decimal(10, 2) NOT NULL
);
insert into matt(matt_name, matt_board_std_height, matt_board_std_width, matt_price_eur_m)
		 values ('BW12345', '1000', '1400', '9.50'),
				('324702', '1000', '1500', '13.50'),
				('324456', '800', '1200', '9.00'),
				('324459', '800', '1200', '9.00'),
				('324465', '800', '1200', '9.00'),
				('324701', '1000', '1500', '13.50'),
				('334452', '800', '1200', '9.80'),
				('324344', '600', '800', '11.00');

create table matt_warehouse_balance (
				id int auto_increment primary key NOT NULL,
                matt_id int NOT NULL,
                board_count int NOT NULL,
                FOREIGN KEY (matt_id) REFERENCES matt(matt_id)
                );
insert into matt_warehouse_balance (matt_id, board_count)
                            values ('1', '7'),
								   ('2', '8'),
								   ('3', '3'),
								   ('4', '4'),
								   ('5', '3'),
								   ('6', '6'),
								   ('7', '9'),
								   ('8', '7');

create table cardboard (
   cardboard_id bigint auto_increment PRIMARY KEY,
   cardboard_name varchar(8) NOT NULL,
   cardboard_std_height int NOT NULL,
   cardboard_std_width int NOT NULL,
   cardboard_price_eur_m decimal(10, 2) NOT NULL
);
insert into cardboard(cardboard_name, cardboard_std_height, cardboard_std_width, cardboard_price_eur_m)
	  values('G2.5', '1000', '1400', '1.90'),
			('G1.0S', '500', '700', '1.05'),
			('G1.0', '1000', '1400', '0.85'),
			('G1.5', '1000', '1400', '1.15'),
			('G2.0', '1000', '1400', '1.60'),
			('W1.5', '800', '1200', '2.20'),
			('W1.5S', '400', '600', '2.60');

create table cardboard_warehouse_balance (
				id bigint auto_increment primary key NOT NULL,
                cardboard_id bigint NOT NULL,
                board_count int NOT NULL,
                FOREIGN KEY (cardboard_id) REFERENCES cardboard(cardboard_id)
                );

insert into cardboard_warehouse_balance (cardboard_id, board_count) values ('1', '52'),
																			('2', '56'),
																			('3', '63'),
																			('4', '44'),
																			('5', '60'),
																			('6', '28'),
																			('7', '40');

