-- file: 10-create-user-and-db.sql
CREATE DATABASE spring_example;
CREATE ROLE program WITH PASSWORD 'test';
GRANT ALL PRIVILEGES ON DATABASE spring_example TO program;
ALTER ROLE program WITH LOGIN;