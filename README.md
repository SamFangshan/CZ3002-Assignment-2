# CZ3002-Assignment-2
### Set up MySQL (Using Docker)
```
docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password -d mysql
```
And then import the dump file `database_dumpfile.sql` to the MySQL database.
