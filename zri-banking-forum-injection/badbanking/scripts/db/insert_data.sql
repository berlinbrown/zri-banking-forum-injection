---
INSERT INTO users(username, password, enabled) VALUES('suzyhacker', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('janegood', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('bobgood', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('bobjohn', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('littlejohn', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('amygood', 'admin', true);

--


--- Add data
--

INSERT INTO users(username, password, enabled) VALUES('suzyhacker', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('janegood', 'admin', true);


-- bobgood is admin
INSERT INTO users(username, password, enabled) VALUES('bobgood', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('bobjohn', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('littlejohn', 'admin', true);

INSERT INTO users(username, password, enabled) VALUES('amygood', 'admin', true);

---

---

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('amygood', 'fa911d71b19af603c0f8a10455a670ef', 'checking', 5000, 'Atlanta', 'My Account', 'My Account');


INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('amygood', 'fdsfa911d71b19af603c0f8a10455a670ef', 'checking', 6000, 'Atlanta', 'My Account', 'My Account');

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('amygood', 'fdadfsdfsfa911d71b19af603c0f8a10455a670ef', 'savings', 10000, 'Atlanta', 'My Account', 'My Account');

----
--- suzyhacker, janegood, bobgood, littlejohn, amygood

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('suzyhacker', 'fa911d71b190003c0f8a10455a670ef', 'checking', 15000, 'Atlanta', 'My Account', 'My Account');


INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('suzyhacker', 'fdsfa90000af603c0f8a10455a670ef', 'checking', 16000, 'Atlanta', 'My Account', 'My Account');

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('suzyhacker', 'fdadfs9000071b999af603c0f8a10455a670ef', 'savings', 110000, 'Atlanta', 'My Account', 'My Account');
---

-- jane


INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('janegood', 'fa911d71b54t60455a670ef', 'checking', 15640, 'Atlanta', 'My Account', 'My Account');


INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('janegood', 'fdsfa90234230f8a10455a670ef', 'checking', 16450, 'Atlanta', 'My Account', 'My Account');

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('janegood', 'fdadfs9234233f8a10455a670ef', 'savings', 110540, 'Atlanta', 'My Account', 'My Account');
---


--- bobgood

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('bobgood', 'fa911d71b56556t60455a670ef', 'checking', 15740, 'Atlanta', 'My Account', 'My Account');


INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('bobgood', 'fdsfa902342312a10455a670ef', 'checking', 17450, 'Atlanta', 'My Account', 'My Account');

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('bobgood', 'fdadfs92342321a10455a670ef', 'savings', 113540, 'Atlanta', 'My Account', 'My Account');
---

--- littlejohn

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('littlejohn', 'fa911d71b56556120455a670ef', 'checking', 19740, 'Atlanta', 'My Account', 'My Account');


INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('littlejohn', 'fdsfa902342311210455a670ef', 'checking', 19450, 'Atlanta', 'My Account', 'My Account');

INSERT INTO zri_bank_accounts(user_name, account, account_type, balance, location,title, message)
      VALUES('littlejohn', 'fdadfs92342321210455a670ef', 'savings', 113541, 'Atlanta', 'My Account', 'My Account');
---


---




--- suzyhacker, janegood,  littlejohn (student), amygood (teacher), bobgood(teacher, admin),

INSERT INTO zri_user_forum(user_name, category, email, location, title, message)
      VALUES('littlejohn', 'Students', 'testjohn@test.com', 'Atlanta', 'My Account', 'I cant wait to see my grades, I did good');


 INSERT INTO zri_user_forum(user_name, category, email, location, title, message)
      VALUES('littlejohn', 'Students', 'testjohn@test.com', 'Atlanta', 'My Account', 'This is it, good school day');


   INSERT INTO zri_user_forum(user_name, category, email, location, title, message)
     VALUES('suzyhacker', 'Students', 'testjohn@test.com', 'Atlanta', 'My Account', 'Cant wait for game today');


       INSERT INTO zri_user_forum(user_name, category, email, location, title, message)
     VALUES('suzyhacker', 'Students', 'suzy@test.com', 'Atlanta', 'My Account', 'Wohoo go dawgs!!!');



INSERT INTO zri_user_forum(user_name, category, email, location, title, message)
     VALUES('janegood', 'Students', 'jane@test.com', 'Atlanta', 'My Account', 'Yep Alabama all the way');
     ---

INSERT INTO zri_user_forum(user_name, category, email, location, title, message)
     VALUES('bobgood', 'Teacher', 'bobgood@test.com', 'Atlanta', 'These Students', 'Hope students do a little better on next test');


    INSERT INTO zri_user_forum(user_name, category, email, location, title, message)
     VALUES('bobgood', 'Teacher', 'bobgood@test.com', 'Atlanta', 'These Students', 'May have to give suzy a bad grade, plus I am tired, dont want to grade today');
