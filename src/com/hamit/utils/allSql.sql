CREATE SCHEMA `hastane_otomasyonu` DEFAULT CHARACTER SET utf8 ;

use hastane_otomasyonu;

CREATE TABLE `hastane_otomasyonu`.`admin9` (
  `admin_id` INT NOT NULL AUTO_INCREMENT,
  `admin_name` VARCHAR(150) NULL,
  `admin_surname` VARCHAR(150) NULL,
  `admin_email` VARCHAR(150) NULL,
  `admin_password` VARCHAR(150) NULL,
  `creation_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`admin_id`))
ENGINE = InnoDB;

-- CRUD
-- create
insert admin9 (admin_name,admin_surname,admin_email,admin_password)  values ("Hamit","Mızrak","hamitmizrak@gmail.com","123456");

-- delete
delete from admin9 where admin_id=3;


-- update
update admin9 set admin_name="ad",admin_surname="soyad",admin_email="email",admin_password="şifre" where admin_id=5;


-- select
select * from admin9;
