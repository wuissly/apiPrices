create table grupo (
id BIGINT not null,
description VARCHAR(250) not null,
PRIMARY KEY (id)
);

create table prices (
id BIGINT not null,
brand_id BIGINT not null,
start_date TimeStamp,
end_date TimeStamp,
price_list BIGINT not null,
product_id BIGINT not null,
priority Integer not null,
price NUMERIC(20, 2) not null,
curr CHAR(5) not null,
PRIMARY KEY (id),
FOREIGN KEY (brand_id) REFERENCES grupo(id)
);

