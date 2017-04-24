INSERT INTO function_category (id,name,description,create_date)VALUES(1,'Logical functions','', now());
INSERT INTO function_category (id,name,description,create_date)VALUES(2,'Basic functions','', now());

INSERT INTO function (id,name,description,create_date, function_category_id)VALUES(1,'SUM','Use this function to add the values in cells.', now(), 1);
INSERT INTO function (id,name,description,create_date, function_category_id)VALUES(2,'IF','Use this function to return one value if a condition is true and another value if it''s false.', now(), 2);
INSERT INTO function (id,name,description,create_date, function_category_id)VALUES(3,'AND','Returns TRUE if all of its arguments are TRUE.', now(), 2);
INSERT INTO function (id,name,description,create_date, function_category_id)VALUES(4,'FALSE','Returns the logical value FALSE.', now(), 2);

INSERT INTO spreadsheet (id,name,create_date)VALUES(1,'First test spreadsheet', now());
INSERT INTO spreadsheet (id,name,create_date)VALUES(2,'Second empty test spreadsheet', now());
INSERT INTO spreadsheet (id,name,create_date)VALUES(3,'Third empty test spreadsheet', now());

INSERT INTO spreadsheet_cell (id,row,col,create_date,spreadsheet_id,`value`,function_id)VALUES(1,0,0,now(),1,33,1);
INSERT INTO spreadsheet_cell (id,row,col,create_date,spreadsheet_id,`value`,function_id)VALUES(2,0,1,now(),1,44,1);
INSERT INTO spreadsheet_cell (id,row,col,create_date,spreadsheet_id,`value`,function_id)VALUES(3,0,2,now(),1,55,1);
