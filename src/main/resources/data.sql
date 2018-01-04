INSERT INTO role(name) VALUES ('ADMIN');
INSERT INTO role(name) VALUES ('USER');

INSERT INTO user(login, password, email) VALUES ('admin123', 'admin123', 'admin@admin.pl');

INSERT INTO user_role(user_id, role_id) VALUES('1', '1');
INSERT INTO user_role(user_id, role_id) VALUES('1', '2');