# zri-banking-forum-injection

Zri System Banking Forum SQL Injection

For WIT workshop

A SQL injection attack consists of insertion or “injection” of a SQL query via 
the input data from the client to the application. A successful SQL injection 
exploit can read sensitive data from the database, modify database data 
(Insert/Update/Delete), execute administration operations on the database 
(such as shutdown the DBMS), recover the content of a given file present 
on the DBMS file system and in some cases issue commands to the operating system. 

SQL is a standard language for accessing and manipulating databases. 
SQL lets you access and manipulate databases. 
A database is an organized collection of structured information, or data, 
typically stored electronically in a computer system.  
Databases are used in all types of modern applications including for banking, 
shopping and more.

# Check out the project

git clone <repo>

# Build the project

Start with mvn clean package

# Run the full build script to deploy to tomcat

Once you have tomcat setup, see more of the SETUP.MD

You can use ./build.sh to use maven to deploy to tomcat

# Example attack

http://localhost:8080/badbanking/forum-home-servlet?action=FILTER&accounttype=Florida%27%20or%201=1--%27