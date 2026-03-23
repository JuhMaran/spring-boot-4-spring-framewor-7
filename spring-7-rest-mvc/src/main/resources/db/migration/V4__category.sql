drop table if exists restdb.category;
drop table if exists restdb.beer_category;

create table restdb.category
(
    id                 varchar(36) NOT NULL PRIMARY KEY,
    description        varchar(50),
    created_date       timestamp,
    last_modified_date datetime(6) DEFAULT NULL,
    version            bigint      DEFAULT NULL
) ENGINE = InnoDB;

create table restdb.beer_category
(
    beer_id     varchar(36) NOT NULL,
    category_id varchar(36) NOT NULL,
    primary key (beer_id, category_id),
    constraint pc_beer_id_fk FOREIGN KEY (beer_id) references restdb.beer (id),
    constraint pc_category_id_fk FOREIGN KEY (category_id) references restdb.category (id)
) ENGINE = InnoDB;
