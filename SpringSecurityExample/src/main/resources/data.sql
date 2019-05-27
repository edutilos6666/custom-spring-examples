insert into users (username, password, enabled) values ('foo', '$2a$10$K/75c7I9XhGzwlnppE1hE.j0b6awmiBaBCxiTg/1KdfMANXGQXiPW', true);
insert into authorities (username, authority) values ('foo', 'ROLE_USER');

insert into users (username, password, enabled) values ('leo', '$2a$10$LYtz/MwlIUdUcS/QtqD36.v3gEC3DP1Dp3WGTcvBLLkO85Xfm7pTy', true);
insert into authorities (username, authority) values ('leo', 'ROLE_ADMIN');