-- DROP TABLE public."admin";

CREATE TABLE public."admin" (
	username varchar(20) NOT NULL,
	"password" varchar(20) NOT NULL,
	CONSTRAINT admin_pk PRIMARY KEY (username)
);

INSERT INTO public."admin"
(username, "password")
VALUES('abc', '123');

-- DROP TABLE public.banking_account;

CREATE TABLE public.banking_account (
	acct_id serial NOT NULL,
	cust_id int4 NOT NULL,
	balance numeric(15, 2) NOT NULL,
	is_approve bool NOT NULL,
	CONSTRAINT banking_account_pk PRIMARY KEY (acct_id)
);

-- DROP TABLE public.customer;

CREATE TABLE public.customer (
	cust_id serial NOT NULL,
	fname varchar(50) NOT NULL,
	lname varchar(50) NOT NULL,
	username varchar(20) NOT NULL,
	"password" varchar(20) NOT NULL,
	CONSTRAINT customer_pk PRIMARY KEY (cust_id)
);

-- DROP TABLE public.pending_transfer;

CREATE TABLE public.pending_transfer (
	ptrans_id serial NOT NULL,
	sender_id int4 NOT NULL,
	receiver_id int4 NOT NULL,
	amount numeric(15, 2) NOT NULL,
	"time_stamp" information_schema."time_stamp" NOT NULL,
	CONSTRAINT ptrans_id PRIMARY KEY (ptrans_id)
);


-- public.pending_transfer foreign keys

ALTER TABLE public.pending_transfer ADD CONSTRAINT pending_transfer_fk FOREIGN KEY (sender_id) REFERENCES public.banking_account(acct_id);
ALTER TABLE public.pending_transfer ADD CONSTRAINT pending_transfer_fk_1 FOREIGN KEY (receiver_id) REFERENCES public.banking_account(acct_id);

-- DROP TABLE public."transaction";

CREATE TABLE public."transaction" (
	trans_id serial NOT NULL,
	acct_id int4 NOT NULL,
	amount numeric(15, 2) NOT NULL,
	trans_type varchar(10) NOT NULL,
	"time_stamp" information_schema."time_stamp" NOT NULL,
	CONSTRAINT transaction_pk PRIMARY KEY (trans_id)
);


-- public."transaction" foreign keys

ALTER TABLE public."transaction" ADD CONSTRAINT transaction_fk FOREIGN KEY (acct_id) REFERENCES public.banking_account(acct_id);