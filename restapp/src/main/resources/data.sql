DROP TABLE IF EXISTS client;
 
CREATE TABLE client (
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  lastLogin VARCHAR(250) NOT NULL,
  role VARCHAR(250) NOT NULL
);
 
INSERT INTO client (name, password, lastLogin, role) VALUES
  ('admin', 'admin', '2020-07-28 12:11:10', 'Admin'),
  ('user1', 'user1', '2020-07-27 12:11:20', 'EditorBrowser'),
  ('user2', 'user2', '2020-07-26 12:21:30', 'Editor'),
  ('user3', 'user3', '2020-07-25 12:31:40', 'Browser');