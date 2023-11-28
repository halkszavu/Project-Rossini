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

INSERT INTO recipes (name, method_time, rest_time, serves, method_descr, dish_id) SELECT 'Tuna sweetcorn tagliatelle', 15, 0, 1, 'Method', id FROM dishes WHERE name = 'Tuna sweetcorn tagliatelle';
INSERT INTO recipes (name, method_time, rest_time, serves, method_descr, dish_id) SELECT 'Sausage pappardelle', 15, 0, 1, 'Method', id FROM dishes WHERE name = 'Sausage pappardelle';

INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 125, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Tagliatelle pasta' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, prep_descr, prep_time, material_id, recipe_id, is_substitute)
    SELECT 10, 'grated', 2, m.id, r.id, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Parmesan cheese' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 40, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Tuna in oil' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 80, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Sweetcorn' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 0.5, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Lemon' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 0.5, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Red onion' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 0.5, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Red chilli' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 2, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Sprigs of parsley' AND r.name = 'Tuna sweetcorn tagliatelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 125, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Tagliatelle pasta' AND r.name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 1, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Clove of garlic' AND r.name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 10, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Fennel seed' AND r.name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 200, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Tomato puree' AND r.name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 100, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Chianti' AND r.name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 100, m.id, r.id, 0, TRUE
    FROM materials m, recipes r
    WHERE m.name = 'Red wine' AND r.name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 0.5, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Red onion' AND r.name = 'Sausage pappardelle';
INSERT INTO ingredient (amount, material_id, recipe_id, prep_time, is_substitute)
    SELECT 75, m.id, r.id, 0, FALSE
    FROM materials m, recipes r
    WHERE m.name = 'Sausages' AND r.name = 'Sausage pappardelle';

INSERT INTO substitutions (source_id, substitute_id)
    SELECT i1.id, i2.id
    FROM ingredient i1, ingredient i2
    WHERE (i1.material_id = (SELECT id FROM materials WHERE name = 'Chianti') AND i1.recipe_id = (SELECT id FROM recipes WHERE name = 'Sausage pappardelle'))
    AND (i2.material_id = (SELECT id FROM materials WHERE name = 'Red wine') AND i2.recipe_id = (SELECT id FROM recipes WHERE name = 'Sausage pappardelle'));
