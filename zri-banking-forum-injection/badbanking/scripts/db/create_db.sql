--
-- Create the database (fake bank)
-- CREATE USER 'botlistfriend'@'localhost' identified by 'b80t1st';
create database zribankdb_development;
create database zribankdb_test;
create database zribankdb_production;

grant all on zribankdb_development.* to 'botlistfriend'@'localhost';
grant all on zribankdb_test.* to 'botlistfriend'@'localhost';
grant all on zribankdb_production.* to 'botlistfriend'@'localhost';

--grant all on zribankdb_development.* to 'botlistfriend'@'*';
--grant all on zribankdb_test.* to 'botlistfriend'@'*';
--grant all on zribankdb_production.* to 'botlistfriend'@'*';

FLUSH PRIVILEGES;FLUSH PRIVILEGES;

-- End of the File