create table login(
username varchar(50) not null,
password varchar(50));


insert into login values("admin", "admin@123"); 
//insert into login values("admin", "admin@123"); 

Create table productdetails(
productname varchar(50), 
price varchar(50),
status varchar(50),
model varchar(50),
quantity varchar(50),
Image varchar(50));

insert into productdetails values("Blazer Girls(7-8)", "3000", "Enabled", "BLG-112", "100", "Enabled");
//insert into productdetails values("Blazer Girls(7-8)", "3000", "Enabled", "BLG-112", "100", "Enabled");

Create table product68(
productname varchar(50), 
metatitle varchar(50),
model varchar(50),
price varchar(50),
quantity varchar(50),
category varchar(50));

insert into product68 values("Red T Shirt", "T Shirt", "RTS - 012", "3000", "2", "Sports");

Create table product69(
productname varchar(50), 
metatitle varchar(50),
model varchar(50),
price varchar(50),
quantity varchar(50),
category varchar(50));

insert into product69 values("Re", "T Shirt", "RTS - 012", "3000", "2", "Sports");
