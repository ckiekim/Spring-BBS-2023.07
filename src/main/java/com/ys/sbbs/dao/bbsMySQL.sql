SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE board
(
	bid int NOT NULL AUTO_INCREMENT,
	uid varchar(16) NOT NULL,
	title varchar(128) NOT NULL,
	content varchar(4000),
	modTime datetime DEFAULT CURRENT_TIMESTAMP,
	viewCount int DEFAULT 0,
	replyCount int DEFAULT 0,
	isDeleted int DEFAULT 0,
	files varchar(400),
	PRIMARY KEY (bid)
);


CREATE TABLE reply
(
	rid int NOT NULL AUTO_INCREMENT,
	comment varchar(128) NOT NULL,
	regTime datetime DEFAULT CURRENT_TIMESTAMP,
	isMine int DEFAULT 0,
	uid varchar(16) NOT NULL,
	bid int NOT NULL,
	PRIMARY KEY (rid)
);


CREATE TABLE users
(
	uid varchar(16) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar(20) NOT NULL,
	email varchar(32) NOT NULL,
	regDate date DEFAULT (CURRENT_DATE),
	isDeleted int DEFAULT 0,
	profile varchar(32),
	addr varchar(32),
	PRIMARY KEY (uid)
);



/* Create Foreign Keys */

ALTER TABLE reply
	ADD FOREIGN KEY (bid)
	REFERENCES board (bid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE reply
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



