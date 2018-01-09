insert into role(name) VALUES ("ROLE_USER");
insert into role(name) VALUES ("ROLE_ADMIN");

insert into user(login, password, join_date) VALUES ("admin123", "admin123", "1410-07-14");
insert into user_role(user_id, role_id) VALUES ('1', '1');
insert into user_role(user_id, role_id) VALUES ('1', '2');

