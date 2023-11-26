CREATE TABLE benefits (
  id VARCHAR(255) NOT NULL,
   effect VARCHAR(255),
   CONSTRAINT pk_benefits PRIMARY KEY (id)
);
CREATE TABLE dishes (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255),
   user_id VARCHAR(255),
   CONSTRAINT pk_dishes PRIMARY KEY (id)
);
CREATE TABLE users (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255),
   role VARCHAR(255),
   CONSTRAINT pk_users PRIMARY KEY (id)
);
CREATE TABLE substitutions (
  id VARCHAR(255) NOT NULL,
   source_id VARCHAR(255),
   substitute_id VARCHAR(255),
   CONSTRAINT pk_substitutions PRIMARY KEY (id)
);

ALTER TABLE substitutions ADD CONSTRAINT FK_SUBSTITUTIONS_ON_SOURCE FOREIGN KEY (source_id) REFERENCES ingredient (id);

ALTER TABLE substitutions ADD CONSTRAINT FK_SUBSTITUTIONS_ON_SUBSTITUTE FOREIGN KEY (substitute_id) REFERENCES ingredient (id);
CREATE TABLE recipes (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255),
   method_time INTEGER,
   rest_time INTEGER,
   serves INTEGER,
   method_descr VARCHAR(255),
   dish_id VARCHAR(255),
   recipe_id VARCHAR(255),
   CONSTRAINT pk_recipes PRIMARY KEY (id)
);

ALTER TABLE recipes ADD CONSTRAINT FK_RECIPES_ON_DISH FOREIGN KEY (dish_id) REFERENCES dishes (id);

ALTER TABLE recipes ADD CONSTRAINT FK_RECIPES_ON_RECIPE FOREIGN KEY (recipe_id) REFERENCES ingredient (id);
CREATE TABLE materials (
  id VARCHAR(255) NOT NULL,
   name VARCHAR(255),
   unit SMALLINT,
   CONSTRAINT pk_materials PRIMARY KEY (id)
);
CREATE TABLE ingredient (
  id VARCHAR(255) NOT NULL,
   amount INTEGER,
   prep_descr VARCHAR(255),
   prep_time INTEGER,
   material_id VARCHAR(255),
   CONSTRAINT pk_ingredient PRIMARY KEY (id)
);
CREATE TABLE materials_benefit (
  material_id VARCHAR(255) NOT NULL,
   benefit_id VARCHAR(255) NOT NULL
);

ALTER TABLE materials_benefit ADD CONSTRAINT uc_materials_benefit_benefit UNIQUE (benefit_id);

ALTER TABLE materials_benefit ADD CONSTRAINT fk_matben_on_benefit FOREIGN KEY (benefit_id) REFERENCES benefits (id);

ALTER TABLE materials_benefit ADD CONSTRAINT fk_matben_on_material FOREIGN KEY (material_id) REFERENCES materials (id);
ALTER TABLE ingredient ADD CONSTRAINT FK_INGREDIENT_ON_MATERIAL FOREIGN KEY (material_id) REFERENCES materials (id);

ALTER TABLE dishes ADD CONSTRAINT FK_DISHES_ON_USER FOREIGN KEY (user_id) REFERENCES users (id);