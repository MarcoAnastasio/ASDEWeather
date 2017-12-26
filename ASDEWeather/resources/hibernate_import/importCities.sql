insert into City (id,name,latitude,longitude, country_id) values (6541467, 'Cosenza',39.30999,16.250191,(	select id from country	where code='IT')	);
