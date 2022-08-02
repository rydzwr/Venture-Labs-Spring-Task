CREATE TABLE `offer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `camper` varchar(45) NOT NULL,
  `price_eur` decimal(19,4),
  `price_usd` decimal(19,4),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`city_id`) REFERENCES cities_local(id),
  FOREIGN KEY (`country_id`) REFERENCES countries_local(id),
  constraint chk_null check (price_eur is not null or price_usd is not null)
) ENGINE=InnoDB AUTO_INCREMENT=131071 DEFAULT CHARSET=utf8;

CREATE TABLE `cities_local` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `city_en` varchar(50) NOT NULL,
    `city_fr` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131071 DEFAULT CHARSET=utf8;

CREATE TABLE `countries_local` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `country_en` varchar(50) NOT NULL,
    `country_fr` varchar(50) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131071 DEFAULT CHARSET=utf8;

CREATE TABLE `extras` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `offer_id` int(11) NOT NULL,
    `name` varchar(50) NOT NULL,
    `price_eur` decimal(19,4),
    `price_usd` decimal(19,4),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`offer_id`) REFERENCES offer(id),
	constraint chk_null check (price_eur is not null or price_usd is not null)
) ENGINE=InnoDB AUTO_INCREMENT=131071 DEFAULT CHARSET=utf8;

CREATE TABLE `insurance` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `offer_id` int(11) NOT NULL,
    `name` varchar(50) NOT NULL,
    `price_eur` decimal(19,4),
    `price_usd` decimal(19,4),
    PRIMARY KEY (`id`),
    FOREIGN KEY (`offer_id`) REFERENCES offer(id),
    constraint chk_null check (price_eur is not null or price_usd is not null)
) ENGINE=InnoDB AUTO_INCREMENT=131071 DEFAULT CHARSET=utf8;
