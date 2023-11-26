INSERT INTO materials (name, unit) VALUES ('Tagliatelle pasta', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Parmesan cheese', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Tuna in oil', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Sweetcorn', 'GRAM');
INSERT INTO materials (name, unit) VALUES ('Lemon', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Red onion', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Red chilli', 'PIECE');
INSERT INTO materials (name, unit) VALUES ('Sprigs of parsley', 'PIECE');

INSERT INTO ingredient (amount, material_id) SELECT 125, id FROM materials WHERE name = 'Tagliatelle pasta';
INSERT INTO ingredient (amount, prep_descr, prep_time, material_id) SELECT 10, 'grated', 2, id FROM materials WHERE name = 'Parmesan cheese';
INSERT INTO ingredient (amount, material_id) SELECT 40, id FROM materials WHERE name = 'Tuna in oil';
INSERT INTO ingredient (amount, material_id) SELECT 80, id FROM materials WHERE name = 'Sweetcorn';
INSERT INTO ingredient (amount, material_id) SELECT 0.5, id FROM materials WHERE name = 'Lemon';
INSERT INTO ingredient (amount, material_id) SELECT 0.5, id FROM materials WHERE name = 'Red onion';
INSERT INTO ingredient (amount, material_id) SELECT 0.5, id FROM materials WHERE name = 'Red chilli';
INSERT INTO ingredient (amount, material_id) SELECT 2, id FROM materials WHERE name = 'Sprigs of parsley';

INSERT INTO users (name, role) VALUES ('Lewis', 'ROLE_ADMIN');

INSERT INTO dishes (name, user_id) SELECT 'Tuna sweetcorn tagliatelle', id FROM users WHERE name = 'Lewis';

INSERT INTO recipes (name, method_time, serves, method_descr, dish_id) SELECT 'Tuna sweetcorn tagliatelle', 15, 1, 'Method', id FROM dishes WHERE name = 'Tuna sweetcorn tagliatelle';