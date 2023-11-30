ALTER TABLE users ADD COLUMN pwd varchar(255);

UPDATE users SET pwd = 'password';
INSERT INTO users (id, name, role, pwd) VALUES (2, 'user2', 'ROLE_USER', 'password');
INSERT INTO users (id, name, role, pwd) VALUES (3, 'user3', 'ROLE_USER', 'password');
INSERT INTO users (id, name, role, pwd) VALUES (4, 'user4', 'ROLE_USER', 'password');
INSERT INTO users (id, name, role, pwd) VALUES (5, 'user5', 'ROLE_USER', 'password');