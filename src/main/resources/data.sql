-- inserting roles
INSERT INTO role(id, `name`)
VALUES (nextval('role_seq'), 'ROLE_DEVELOPER'), (nextval('role_seq'), 'ROLE_MANAGER'), (nextval('role_seq'), 'ROLE_ADMIN');

-- inserting departments
INSERT INTO department(id, name)
VALUES
(nextval('department_seq'), 'Department 1'),
(nextval('department_seq'), 'Department 2'),
(nextval('department_seq'), 'Department 3');

-- inserting users
INSERT INTO `user`(id, first_name, last_name, email, age, department_id)
VALUES
(nextval('user_seq'), 'Heril', 'Muratovic', 'hedzaprog@gmail.com', 31, (SELECT id FROM department WHERE name = 'Department 1' LIMIT 1)),
(nextval('user_seq'), 'John', 'Wick', 'john.wick@test.com', 40, (SELECT id FROM department WHERE name = 'Department 2' LIMIT 1));

-- inserting user roles
INSERT INTO user_role(user_id, role_id)
VALUES
((SELECT id FROM `user` WHERE email = 'hedzaprog@gmail.com'), (SELECT id FROM role WHERE name = 'ROLE_ADMIN')),
((SELECT id FROM `user` WHERE email = 'john.wick@test.com'), (SELECT id FROM role WHERE name = 'ROLE_DEVELOPER'));

