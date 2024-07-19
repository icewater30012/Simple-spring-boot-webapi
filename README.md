# Simple-spring-boot-webapi
This is a simple CRUD Web API building with spring-boot framework to retrieve covid-19 information from MySQL database.

## System Requirement
JDK: openjdk-8-jdk

Maven: Apache Maven 3.6.0+

MySQL Server: 5.7.39+

## Setting Up the MySQL Database and Import Data
1. Update package from source list. 
 
`sudo apt update`

2. Install MySQL Server and press y to continue the installation. 

`sudo apt install mysql-server`

3. Check the operation status of MySQL is active.

`sudo service mysql status`

4. Login into command line of MySQL server with root

`sudo mysql -u root`

5. Set default password for root@localhost and enable it to be identified as native password

`mysql> ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password by '<your_root_password>';`

(Optional) 6. Create a new user and grant the privileges for this user.

`mysql> CREATE USER '<your_username>'@'%' IDENTIFIED BY '<your_user_password>';`

`mysql> GRANT ALL PRIVILEGES ON *.* TO '<your_username>'@'%' WITH GRANT OPTION;`

7. Reload the user privileges

 `mysql> FLUSH PRIVILEGES;`
 
8. Enable import csv into MySQL Database

`mysql> SET GLOBAL local_infile=1;`

9. Create Database and change database.

`mysql> CREATE DATABASE <your_db_name>;`

`mysql> USE <your_db_name>;`

10. Create `covid_report` table

`create table covid_report (id bigint not null auto_increment, city varchar(255), daily_vaccinations_az integer, daily_vaccinations_bottle integer, daily_vaccinations_moderna integer, date date, delivery_az integer, delivery_bottle integer, delivery_moderna integer, percentage_az float, percentage_bottle varchar(255), percentage_moderna float, population integer, remaining_az integer, remaining_bottle integer, remaining_moderna integer, remaining_percentage_az float, remaining_percentage_bottle varchar(255), remaining_percentage_moderna float, total_vaccinations_az integer, total_vaccinations_bottle integer, total_vaccinations_moderna integer, primary key (id)) engine=InnoDB;`

11. Exit the mysql command line

 `mysql > exit;`
 
12. Navigate to the project directory and import data from `covid_report.csv` into MySQL Database.

`cd /<path_of_project>/Simple-spring-boot-webapi`

`sudo mysqlimport --ignore-lines=1 --fields-terminated-by=, --columns='Id,date,city,population,daily_vaccinations_bottle,total_vaccinations_bottle,percentage_bottle,delivery_bottle,remaining_bottle,remaining_percentage_bottle,daily_vaccinations_az,total_vaccinations_az,percentage_az,delivery_az,remaining_az,remaining_percentage_az,daily_vaccinations_moderna,total_vaccinations_moderna,percentage_moderna,delivery_moderna,remaining_moderna,remaining_percentage_moderna' --local -u root -p <your_db_name> covid_report.csv`

13. Configure security for MySQL server, login with the password as above set and answer the following questions:
   - Would you like to setup VALIDATE PASSWORD component? ((Press y|Y for Yes, any other key for No) : y
   - There are three levels of password validation policy : 1
   - Change the password for root ? ((Press y|Y for Yes, any other key for No) : n
   - Remove anonymous users? (Press y|Y for Yes, any other key for No) : y
   - Disallow root login remotely? (Press y|Y for Yes, any other key for No) : y
   - Remove test database and access to it? (Press y|Y for Yes, any other key for No) : y 
   - Reload privilege tables now? (Press y|Y for Yes, any other key for No) : y

`sudo mysql_secure_installation`


## Configure Project
1. Navigate into the project and edit `application.properties`

`sudo vim /<path_of_the_project>/Simple-spring-boot-webapi/src/main/resources/application.properties`

2. Modify the below attributes with your database name, username and password.

`spring.datasource.url=jdbc:mysql://localhost:3306/<your_db_name>`

`spring.datasource.username=<your_user_name>`

`spring.datasource.password=<your_password>`


## Build Project
Build and run the project

`mvn spring-boot:run`

Build and run the project in background

`nohup mvn spring-boot:run &`

The Swagger url of this project :http://<your_ip_address>:8080/swagger-ui/index.html


## Some Trouble Shooting

#### If your MySQL DB is not as same VM as this project

You need to modify `mysqld.cnf` file.

`vim /etc/mysql/mysql.conf.d/mysqld.cnf`

Change the IP of attribute `bind-address` to `0.0.0.0` to allow all IP to access your MySQL database

`bind-address            = 0.0.0.0`

Restart mysql 

`sudo service mysql restart`

