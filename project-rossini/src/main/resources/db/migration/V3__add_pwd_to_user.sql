ALTER TABLE users ADD COLUMN password varchar(255);

UPDATE users SET password = 'password';
INSERT INTO users (id, name, role, password) VALUES (2, 'user2', 'ROLE_USER', 'password');
INSERT INTO users (id, name, role, password) VALUES (3, 'user3', 'ROLE_USER', 'password');
INSERT INTO users (id, name, role, password) VALUES (4, 'user4', 'ROLE_USER', 'password');
INSERT INTO users (id, name, role, password) VALUES (5, 'user5', 'ROLE_USER', 'password');