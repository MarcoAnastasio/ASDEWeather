insert into User (id,username,password,firstName, lastName,email) values (NULL, 'ciccio','$2a$10$Vg7o.6MLz6NWOnsGlY16T..B7bWY5ybBco9IRGokOx.kMiuN7tL/e','testName','testLastName','email@test.com');

insert into User_City (User_id,preferedCities_id) values (1,2524907), (1,2523630);


insert into City (id,name,latitude,longitude, country_id) values (2022572, 'Khatanga',40.833328,14.25,(	select id from country	where code='RU')	);


insert into User_City (User_id,preferedCities_id) values  (1,2022572);