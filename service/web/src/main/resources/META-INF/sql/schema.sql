create table admin (id integer generated by default as identity, password varchar(255), username varchar(255), primary key (id))
create table bank_account (account varchar(255) not null, bankname varchar(255) not null, swift varchar(255) not null, id bigint not null, primary key (id))
create table bid (id bigint generated by default as identity, amount decimal(19,2), created_on timestamp, item_id bigint, bid_position integer not null, primary key (id))
create table billing_details (id bigint not null, owner varchar(255) not null, user bigint, primary key (id))
create table categorized_item (category_id bigint not null, item_id bigint not null, added_by varchar(255) not null, added_on timestamp not null, primary key (category_id, item_id))
create table category (id bigint generated by default as identity, name varchar(255), primary key (id))
create table credit_card (exp_month varchar(255) not null, exp_year varchar(255) not null, number varchar(255) not null, id bigint not null, primary key (id))
create table image (item_id bigint not null, filename varchar(255) not null, height integer, title varchar(255) not null, width integer, primary key (item_id, filename, title))
create table item (id bigint generated by default as identity, auction_end timestamp, price varchar(63) not null, created_on timestamp, depth decimal(19,2), height decimal(19,2), width decimal(19,2), dimensions_name varchar(255), dimensions_symbol varchar(255), initial_price decimal(19,2) default 1.00, last_modified timestamp, name varchar(255), weight decimal(19,2) not null, weight_name varchar(255), weight_symbol varchar(255), primary key (id))
create table item_buyer (buyer_id bigint not null, item_id bigint not null, primary key (item_id))
create table item_shipment (item_id bigint not null, shipment_id bigint not null, primary key (shipment_id))
create table shipment (id bigint generated by default as identity, delivery_address_user_id bigint not null, primary key (id))
create table user (id bigint not null, firstname varchar(255), lastname varchar(255), city varchar(255) not null, street varchar(255) not null, zipcode varchar(255) not null, username varchar(255), default_billing bigint, primary key (id))
alter table admin add constraint UK_gfn44sntic2k93auag97juyij  unique (username)
alter table item_shipment add constraint UK_bt2bpyol0qyhcdyjqm1t35phi  unique (item_id)
alter table bank_account add constraint FK_asjgaeteungo7k3ub3pde5gbm foreign key (id) references billing_details
alter table bid add constraint FK_g7j35pfilox0c542cw6le4upk foreign key (item_id) references item
alter table billing_details add constraint FK_4c363oh2w7vdlkie6emg19usf foreign key (user) references user
alter table categorized_item add constraint FK_si3lwmehqnw7rj4upixjspdt foreign key (category_id) references category
alter table categorized_item add constraint FK_fy4doe66n9rjt7rr3931ibcha foreign key (item_id) references item
alter table credit_card add constraint FK_oqqdl3e6yrg8pnva76rtrbhbb foreign key (id) references billing_details
alter table image add constraint FK_2mbwmeojrp1yj19pyxy3ccaur foreign key (item_id) references item
alter table item_buyer add constraint FK_qagbgkqwbr1xyol63g8vkapys foreign key (buyer_id) references user
alter table item_buyer add constraint FK_5na5hy8llbyi39bwolay6pn2h foreign key (item_id) references item
alter table item_shipment add constraint FK_bt2bpyol0qyhcdyjqm1t35phi foreign key (item_id) references item
alter table item_shipment add constraint FK_2dqatlh8juxefqukv2we8kkf8 foreign key (shipment_id) references shipment
alter table shipment add constraint FK_c8nn12odvelv2b40xq6rnejex foreign key (delivery_address_user_id) references user
alter table user add constraint FK_n51ya2s97njw5bl24lx27sklt foreign key (default_billing) references billing_details
create sequence JPWH_SEQUENCE start with 1000 increment by 1