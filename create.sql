create table brand (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table category (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table order (price float(53) not null, quantity integer not null, date datetime(6), id bigint not null auto_increment, product_id bigint, user_id bigint, primary key (id)) engine=InnoDB;
create table product (discount float(53) not null, is_available bit not null, is_bestseller bit not null, is_coming_soon bit not null, is_discounted bit not null, is_limited bit not null, is_new bit not null, is_on_sale bit not null, is_popular bit not null, is_recommended bit not null, is_sold_out bit not null, price float(53) not null, quantity integer not null check (quantity>=0), rating integer not null check ((rating>=0) and (rating<=5)), added_at datetime(6) not null, brand_id bigint not null, category_id bigint not null, id bigint not null auto_increment, name varchar(100) not null, description varchar(500), image varchar(255) not null, primary key (id)) engine=InnoDB;
create table review (rating integer not null, date datetime(6), id bigint not null auto_increment, product_id bigint, user_id bigint, author varchar(255), description varchar(255), primary key (id)) engine=InnoDB;
create table user (active bit not null, id bigint not null auto_increment, email varchar(255) not null, name varchar(255) not null, password varchar(255) not null, role varchar(255) not null, primary key (id)) engine=InnoDB;
alter table if exists order add constraint FK3b51sphq5i3qy7iai0o5lmu7l foreign key (product_id) references product (id);
alter table if exists order add constraint FKt7abetueht6dd1gs9jyl3o4t7 foreign key (user_id) references user (id);
alter table if exists product add constraint FKs6cydsualtsrprvlf2bb3lcam foreign key (brand_id) references brand (id);
alter table if exists product add constraint FK1mtsbur82frn64de7balymq9s foreign key (category_id) references category (id);
alter table if exists review add constraint FKiyof1sindb9qiqr9o8npj8klt foreign key (product_id) references product (id);
alter table if exists review add constraint FKiyf57dy48lyiftdrf7y87rnxi foreign key (user_id) references user (id);
