-- login with root to create user, DB and table and provide grants
 


create database DigitalMarket;

use DigitalMarket;

create table login(
					email varchar(30),
                    pass varchar(20)
                    );

insert into login(email,pass) values('rahul@gmail.com',123456);  
                    
                    
drop table if exists `Users`;
CREATE TABLE `Users` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL ,
  `email` varchar(20) NOT NULL UNIQUE,
  `mobile` varchar(20) NOT NULL UNIQUE,
  `country` varchar(20) DEFAULT 'INDIA',
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
