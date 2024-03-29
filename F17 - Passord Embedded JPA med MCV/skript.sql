DROP SCHEMA IF EXISTS f17pwd CASCADE;
CREATE SCHEMA f17pwd;
SET search_path = f17pwd;

CREATE TABLE bruker 
(
   brukernavn CHARACTER VARYING (20),
   pwd_hash CHARACTER (64),
   pwd_salt CHARACTER (32),
   PRIMARY KEY (brukernavn)
);

INSERT INTO bruker VALUES 
	('Per', -- passord: qwerty
		'DF32FB5C3D132F276CA0E9B582ADA7E7B72CA1E5DE58C35D86C378A9446EE005',
		'38943AF5CA14AE5C1B9438FBB20233CA'), 
	('Paal', -- passord: pass123
		'2C8700BDBD964E483E98BF371D8810D47F10C539B508D0ACCCC4416282873F49',
		'A8EEEB37FAAC34B399D8E4CE4C1DC72B');