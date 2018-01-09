insert into role(name) VALUES ("ROLE_USER");
insert into role(name) VALUES ("ROLE_ADMIN");

insert into user(login, password, join_date) VALUES ("admin123", "admin123", "1410-07-14");
insert into user_role(user_id, role_id) VALUES ('1', '1');
insert into user_role(user_id, role_id) VALUES ('1', '2');

insert into user(login, password, email, join_date) VALUES ("kijkowski", "12345", "123@123", "1410-07-14");
insert into user_role(user_id, role_id) VALUES ('2', '1');

insert into forum(title, created) VALUES ("Domyślne forum", "1410-07-14");