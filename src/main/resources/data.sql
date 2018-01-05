INSERT INTO ROLE(name) VALUES ('USER');
INSERT INTO ROLE(name) VALUES ('ADMIN');

INSERT INTO USER(login, password) VALUES ('admin123', 'admin123');

INSERT INTO USER_ROLE(user_id, role_id) VALUES ('1', '1');
INSERT INTO USER_ROLE(user_id, role_id) VALUES ('1', '2');