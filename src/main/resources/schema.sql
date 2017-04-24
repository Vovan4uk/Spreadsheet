DROP TABLE IF EXISTS spreadsheet_cell;
DROP TABLE IF EXISTS function;
DROP TABLE IF EXISTS function_category;
DROP TABLE IF EXISTS spreadsheet;

CREATE TABLE function_category (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  create_date DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE function (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1000) NOT NULL,
  create_date DATE NOT NULL,
  function_category_id INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (function_category_id) REFERENCES function_category(id)
);

CREATE TABLE spreadsheet (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  create_date DATE NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE spreadsheet_cell (
  id INT NOT NULL AUTO_INCREMENT,
  row INT NOT NULL,
  col INT NOT NULL,
  create_date DATE NOT NULL,
  spreadsheet_id INT NOT NULL,
  value VARCHAR(255) DEFAULT NULL,
  function_id INT DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (spreadsheet_id) REFERENCES spreadsheet(id),
  FOREIGN KEY (function_id) REFERENCES function(id),
  UNIQUE KEY unique_cell (row, col, spreadsheet_id)
);