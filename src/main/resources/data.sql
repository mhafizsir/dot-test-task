drop table if exists provinces;

create table provinces
(
    id            int auto_increment primary key,
    province_id   clob      not null,
    province_name clob      not null,
    created_at    timestamp not null,
    modified_at   timestamp,
    deleted_at    timestamp
);

drop table if exists cities;

create table cities
(
    id            int auto_increment primary key,
    city_id       clob      not null,
    province_id   clob      not null,
    province_name clob      not null,
    type          clob      not null,
    city_name     clob      not null,
    postal_code   clob      not null,
    created_at    timestamp not null,
    modified_at   timestamp,
    deleted_at    timestamp
);