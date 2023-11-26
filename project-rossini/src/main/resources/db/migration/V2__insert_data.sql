INSERT INTO materials (name, unit) VALUES ('Tagliatelle pasta', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Parmesan cheese', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Tuna in oil', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Sweetcorn', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Lemon', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Red onion', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Red chilli', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Sprigs of parsley', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Sausages', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Clove of garlic', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Fennel seed', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Tomato puree', 'LITRE');
INSERT INTO materials (name, unit) VALUES ('Chianti', 'LITRE');
INSERT INTO materials (name, unit) VALUES ('Red wine', 'LITRE');

INSERT INTO users (name, role) VALUES ('Lewis', 'ROLE_ADMIN');

INSERT INTO dishes (name, user_id) SELECT 'Tuna sweetcorn tagliatelle', id FROM users WHERE name = 'Lewis';
INSERT INTO dishes (name, user_id) SELECT 'Sausage pappardelle', id FROM users WHERE name = 'Lewis';

INSERT INTO recipes (name, method_time, serves, method_descr, dish_id) SELECT 'Tuna sweetcorn tagliatelle', 15, 1, 'Method', id FROM dishes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO recipes (name, method_time, serves, method_descr, dish_id) SELECT 'Sausage pappardelle', 15, 1, 'Method', id FROM dishes WHERE name = 'Sausage pappardelle';

INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 125, id FROM materials WHERE name = 'Tagliatelle pasta', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, prep_descr, prep_time, material_id, recipe_id) SELECT 10, 'grated', 2, id FROM materials WHERE name = 'Parmesan cheese', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 40, id FROM materials WHERE name = 'Tuna in oil', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 80, id FROM materials WHERE name = 'Sweetcorn', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 0.5, id FROM materials WHERE name = 'Lemon', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 0.5, id FROM materials WHERE name = 'Red onion', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 0.5, id FROM materials WHERE name = 'Red chilli', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 2, id FROM materials WHERE name = 'Sprigs of parsley', id FROM recipes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 125, id FROM materials WHERE name = 'Tagliatelle pasta', id FROM recipes WHERE name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 1, id FROM materials WHERE name = 'Clove of garlic', id FROM recipes WHERE name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 10, id FROM materials WHERE name = 'Fennel seed', id FROM recipes WHERE name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 200, id FROM materials WHERE name = 'Tomato puree', id FROM recipes WHERE name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 100, id FROM materials WHERE name = 'Chianti', id FROM recipes WHERE name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 100, id FROM materials WHERE name = 'Red wine', id FROM recipes WHERE name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 0.5, id FROM materials WHERE name = 'Sprigs of parsley', id FROM recipes WHERE name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id) SELECT 75, id FROM materials WHERE name = 'Saugsages', id FROM recipes WHERE name = 'Sausage pappardelle';

INSERT INTO substitutions (source_id, substitute_id) SELECT id FROM ingredient WHERE name = 'Chianti' AND recipe_id = (SELECT id FROM recipes WHERE name = 'Sausage pappardelle'), id FROM ingredient WHERE name = 'Red wine' AND recipe_id = (SELECT id FROM recipes WHERE name = 'Sausage pappardelle');