-- login with root to create user, DB and table and provide grants
 
create user 'pankaj'@'localhost' identified by 'pankaj123';

grant all on *.* to 'pankaj'@'localhost' identified by 'pankaj123';

create database UserDB;

use UserDB;

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
