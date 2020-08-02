DROP TABLE IF EXISTS client;
 
CREATE TABLE client (
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  lastLogin VARCHAR(250) NOT NULL,
  roles VARCHAR(250) NOT NULL
);
 
INSERT INTO client (name, password, lastLogin, roles) VALUES ('admin', 'admin', '06-27-2019 11:10:09', 'Admin');
INSERT INTO client (name, password, lastLogin, roles) VALUES ('admin', 'admin', '07-28-2019 12:11:10', 'Admin');
INSERT INTO client (name, password, lastLogin, roles) VALUES ('user1', 'user1', '06-26-2019 11:10:19', 'Editor,Browser');
INSERT INTO client (name, password, lastLogin, roles) VALUES ('user1', 'user1', '07-27-2020 12:11:20', 'Editor,Browser');
INSERT INTO client (name, password, lastLogin, roles) VALUES ('user2', 'user2', '06-25-2019 11:20:29', 'Editor');
INSERT INTO client (name, password, lastLogin, roles) VALUES ('user2', 'user2', '07-26-2020 12:21:30', 'Editor');
INSERT INTO client (name, password, lastLogin, roles) VALUES ('user3', 'user3', '06-24-2019 11:30:39', 'Browser');
INSERT INTO client (name, password, lastLogin, roles) VALUES ('user3', 'user3', '07-25-2020 12:31:40', 'Browser');