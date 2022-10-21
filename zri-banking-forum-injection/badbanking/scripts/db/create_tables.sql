-- Author: Berlin Brown

-- Create tables

-- Don't need to drop users

drop table zri_bank_agent_chat

CREATE TABLE users (
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(50) NOT NULL,
	enabled BIT NOT NULL
);

--- banking chat

drop table zri_bank_agent_chat

CREATE TABLE zri_bank_agent_chat (
  id 				int(11) NOT NULL auto_increment PRIMARY KEY,
  user_name			varchar(128) NOT NULL,
  category			varchar(128),
  email				varchar(128),
  location			varchar(255),
  title				varchar(255),
  message 			text NOT NULL,

  ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  dt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


drop table zri_bank_accounts

CREATE TABLE zri_bank_accounts (
  id 				int(11) NOT NULL auto_increment PRIMARY KEY,
  user_name			varchar(128) NOT NULL,
  account			varchar(128) NOT NULL,
  balance			int(11) NOT NULL,
  location			varchar(255),
  title				varchar(255),
  message 			text NOT NULL,

  ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  dt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


--- Forum

drop table zri_user_forum


CREATE TABLE zri_user_forum (
  id 				int(11) NOT NULL auto_increment PRIMARY KEY,
  user_name			varchar(128) NOT NULL,
  category			varchar(128),
  email				varchar(128),
  location			varchar(255),
  title				varchar(255),
  message 			text NOT NULL,

  ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  dt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);



-- Test table
CREATE TABLE t1 (
  ts TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  dt DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


---

