# Setup

Download tomcat to:

/Users/Downloads/apache-tomcat-8.5.83/

cd:

/Users/Downloads/apache-tomcat-8.5.83/bin
./startup.sh

Visit:

http://localhost:8080/badbanking/

To build and deploy:

mvn tomcat7:deploy

# MySQL Setup

brew services start mysql

mysql -u root

# Additional Tools

Tomcat

MySQL

MySQL workbench

Visual Studio Code

## dbeaver setup

Right click your connection, choose "Edit Connection"

On the "Connection settings" screen (main screen) click on "Edit Driver Settings"
Click on "Connection properties", (In recent versions it named "Driver properties")
Right click the "user properties" area and choose "Add new property"
Add two properties: "useSSL" and "allowPublicKeyRetrieval"
Set their values to "false" and "true" by double clicking on the "value" column

## Starting MySQL

mysql start
### Additional Notes

Removing: /Users/Library/Logs/Homebrew/node@14... (64B)
Removing: /usr/local/lib/python3.8/site-packages/__pycache__/sitecustomize.cpython-38.pyc... (1.4KB)
Removing: /usr/local/lib/python3.7/site-packages/__pycache__/delegator.cpython-37.pyc... (7.2KB)
Removing: /usr/local/lib/python3.7/site-packages/__pycache__/easy_install.cpython-37.pyc... (283B)
Removing: /usr/local/lib/python3.7/site-packages/__pycache__/sitecustomize.cpython-37.pyc... (1.3KB)
Removing: /usr/local/lib/python3.7/site-packages/__pycache__/six.cpython-37.pyc... (25.8KB)
Removing: /usr/local/lib/python3.7/site-packages/__pycache__/tabulate.cpython-37.pyc... (42.4KB)
Pruned 0 symbolic links and 3 directories from /usr/local
==> Caveats
==> mysql
We've installed your MySQL database without a root password. To secure it run:
    mysql_secure_installation

MySQL is configured to only allow connections from localhost by default

To connect run:
    mysql -u root

To restart mysql after an upgrade:
  brew services restart mysql
Or, if you don't want/need a background service you can just run:
  /usr/local/opt/mysql/bin/mysqld_safe --datadir=/usr/local/var/mysql
==> httpd
DocumentRoot is /usr/local/var/www.

The default ports have been set in /usr/local/etc/httpd/httpd.conf to 8080 and in
/usr/local/etc/httpd/extra/httpd-ssl.conf to 8443 so that httpd can run without sudo.

To restart httpd after an upgrade:
  brew services restart httpd
Or, if you don't want/need a background service you can just run:
  /usr/local/opt/httpd/bin/httpd -D FOREGROUND
