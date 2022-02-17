DROP TABLE reply CASCADE CONSTRAINTS;
DROP TABLE post CASCADE CONSTRAINTS;

/**********************************/
/* Table Name: post */
/**********************************/
CREATE TABLE post(
		p_no                          		NUMBER(10)		 NOT NULL,
		p_name                        		VARCHAR2(100)		 NOT NULL,
		p_title                       		VARCHAR2(100)		 NOT NULL,
		p_content                     		VARCHAR2(100)		 NULL ,
		p_date                        		DATE		 DEFAULT sysdate		 NULL 
);

DROP SEQUENCE post_p_no_SEQ;

CREATE SEQUENCE post_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;


/**********************************/
/* Table Name: reply */
/**********************************/
CREATE TABLE reply(
		r_no                          		NUMBER(10)		 NOT NULL,
		r_name                        		VARCHAR2(100)		 NOT NULL,
		r_title                       		VARCHAR2(100)		 NOT NULL,
		r_content                     		VARCHAR2(100)		 NOT NULL,
		r_date                        		DATE		 DEFAULT sysdate		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE reply_r_no_SEQ;

CREATE SEQUENCE reply_r_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



ALTER TABLE post ADD CONSTRAINT IDX_post_PK PRIMARY KEY (p_no);

ALTER TABLE reply ADD CONSTRAINT IDX_reply_PK PRIMARY KEY (r_no);
ALTER TABLE reply ADD CONSTRAINT IDX_reply_FK0 FOREIGN KEY (p_no) REFERENCES post (p_no);

