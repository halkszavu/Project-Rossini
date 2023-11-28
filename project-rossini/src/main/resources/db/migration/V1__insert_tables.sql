CREATE TYPE UNIT AS ENUM ('GRAM', 'LITRE', 'PIECE');

CREATE TABLE benefits (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   effect VARCHAR(255) NOT NULL
);
CREATE TABLE dishes (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   name VARCHAR(255) NOT NULL,
   user_id VARCHAR(255)
);
CREATE TABLE users (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   name VARCHAR(255) NOT NULL,
   role VARCHAR(255) NOT NULL,
   CONSTRAINT unique_name UNIQUE (name)
);
CREATE TABLE substitutions (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   source_id VARCHAR(255),
   substitute_id VARCHAR(255)
);
CREATE TABLE recipes (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   name VARCHAR(255) NOT NULL,
   method_time INTEGER NOT NULL,
   rest_time INTEGER NOT NULL,
   serves INTEGER NOT NULL,
   method_descr TEXT NOT NULL,
   dish_id INTEGER
);
CREATE TABLE materials (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   name VARCHAR(255) NOT NULL,
   unit UNIT NOT NULL
);
CREATE TABLE ingredient (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   amount FLOAT(24) NOT NULL,
   prep_descr VARCHAR(255),
   prep_time INTEGER NOT NULL,
   material_id INTEGER NOT NULL,
   recipe_id INTEGER NOT NULL,
   isSubstitution BOOLEAN NOT NULL
);
CREATE TABLE materials_benefit (
  id INTEGER NOT NULL PRIMARY KEY auto_increment,
   material_id VARCHAR(255) NOT NULL,
   benefit_id VARCHAR(255) NOT NULL
);

ALTER TABLE materials_benefit ADD CONSTRAINT uc_materials_benefit_benefit UNIQUE (benefit_id);
ALTER TABLE materials_benefit ADD CONSTRAINT fk_matben_on_benefit FOREIGN KEY (benefit_id) REFERENCES benefits (id);
ALTER TABLE materials_benefit ADD CONSTRAINT fk_matben_on_material FOREIGN KEY (material_id) REFERENCES materials (id);
ALTER TABLE ingredient ADD CONSTRAINT FK_INGREDIENT_ON_MATERIAL FOREIGN KEY (material_id) REFERENCES materials (id);
ALTER TABLE dishes ADD CONSTRAINT FK_DISHES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE ingredient ADD CONSTRAINT FK_INGREDIENT_ON_RECIPE FOREIGN KEY (recipe_id) REFERENCES recipes (id);
ALTER TABLE substitutions ADD CONSTRAINT FK_SUBSTITUTIONS_ON_SOURCE FOREIGN KEY (source_id) REFERENCES ingredient (id);
ALTER TABLE substitutions ADD CONSTRAINT FK_SUBSTITUTIONS_ON_SUBSTITUTE FOREIGN KEY (substitute_id) REFERENCES ingredient (id);
ALTER TABLE recipes ADD CONSTRAINT FK_RECIPES_ON_DISH FOREIGN KEY (dish_id) REFERENCES dishes (id);