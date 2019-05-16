create table USER (id bigint auto_increment, name varchar(255), password varchar(255));
create table PROJECT (id bigint auto_increment, name varchar(255), lead_id bigint);
create table BACKLOG (id bigint auto_increment, project_id bigint);