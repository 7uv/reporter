-- drop table stock_inventory;

CREATE TABLE `stock_inventory` (
  `id` bigint(20) NOT NULL,
  `from_date` DATETIME NOT NULL,
  `to_date` DATETIME NOT NULL,
  `dept` varchar(12) NOT NULL,
  `item_type` varchar(255) NOT NULL,
  `item_form` varchar(255) NOT NULL,
  `isbn` varchar(255) NOT NULL,
  `price` NUMERIC NOT NULL,
  `curr` varchar(3),
  `qnty` INTEGER(12) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9qv6yhjqm8iafto8qk452gx8h` (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into stock_inventory values(5, '2016-01-05', '2019-01-28', 'IT', 'PC Hardware', 'Rack Mount Server', 'A0EE3C98-9C0B-4EF8-BB6D-6BB9BD380C10', '9999.999', 'USD', 2);

select * FROM stock_inventory;