
/* Drop Triggers */

DROP TRIGGER TRI_board_bid;
DROP TRIGGER TRI_reply_rid;



/* Drop Tables */

DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE board CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_board_bid;
DROP SEQUENCE SEQ_reply_rid;




/* Create Sequences */

CREATE SEQUENCE SEQ_board_bid INCREMENT BY 1 START WITH 1001;
CREATE SEQUENCE SEQ_reply_rid INCREMENT BY 1 START WITH 1001;



/* Create Tables */

CREATE TABLE board
(
	bid number(10,0) NOT NULL,
	"uid" varchar2(16) NOT NULL,
	title varchar2(128) NOT NULL,
	content varchar2(4000),
	modTime timestamp DEFAULT CURRENT_TIMESTAMP,
	viewCount number(10,0) DEFAULT 0,
	replyCount number(10,0) DEFAULT 0,
	isDeleted number(10,0) DEFAULT 0,
	files varchar2(400),
	PRIMARY KEY (bid)
);


CREATE TABLE reply
(
	rid number(10,0) NOT NULL,
	"comment" varchar2(128) NOT NULL,
	regTime timestamp DEFAULT CURRENT_TIMESTAMP,
	isMine number(10,0) DEFAULT 0,
	"uid" varchar2(16) NOT NULL,
	bid number(10,0) NOT NULL,
	PRIMARY KEY (rid)
);


CREATE TABLE users
(
	"uid" varchar2(16) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar2(20) NOT NULL,
	email varchar2(32) NOT NULL,
	regDate date DEFAULT (CURRENT_DATE),
	isDeleted number(10,0) DEFAULT 0,
	"profile" varchar2(32),
	addr varchar2(32),
	PRIMARY KEY ("uid")
);



/* Create Foreign Keys */

ALTER TABLE reply
	ADD FOREIGN KEY (bid)
	REFERENCES board (bid)
;


ALTER TABLE board
	ADD FOREIGN KEY ("uid")
	REFERENCES users ("uid")
;


ALTER TABLE reply
	ADD FOREIGN KEY ("uid")
	REFERENCES users ("uid")
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_board_bid BEFORE INSERT ON board
FOR EACH ROW
BEGIN
	SELECT SEQ_board_bid.nextval
	INTO :new.bid
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_reply_rid BEFORE INSERT ON reply
FOR EACH ROW
BEGIN
	SELECT SEQ_reply_rid.nextval
	INTO :new.rid
	FROM dual;
END;

/




