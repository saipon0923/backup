set names utf8;
set foerign_key_checks=0;
drop database if exists ecsite;
/*もし、すでにecsiteというデータベースがあれば削除する*/

create database if not exists ecsite;/*データベース名がecsite*/
use ecsite;/*ecsiteというデータベースを利用する*/

drop table if exists login_user_transaction;
/*login_user_transactionがテーブル名*/

create table login_user_transaction(
	id int not null primary key auto_increment,
	login_id varchar(16) unique,
	login_pass varchar(16),
	user_name varchar(50),
	insert_date datetime,
	updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
	id int not null primary key auto_increment,
	ltem_name varchar(30),
	item_price int,
	item_stock int,
	insert_date datetime,
	update_date datatime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
	id int not null primary key auto_increment,
	item_transaction_id int,
	total_price int,
	total_count int,
	user_master_id varchar(16),
	pay varchar(30),
	insert_date datetime,
	delete_date datetime
);

/*以下の文で各テーブルに情報を格納する*/
INSERT INTO item_info_transaction(item_name,item_price,item_stock)
	VALUES("ノートBook",100,50);

INSERT INTO login_user_transaction(login_id,login_pass,user_name)
	VALUES("internous","internous01","test");


