drop table if exists member CASCADE;
create table member
(
    id        uuid default random_uuid(),
    name      varchar(50),
    email     varchar(50),
    password  varchar(100),
    create_on timestamp,
    delete_on timestamp,
    primary key (id)
);
