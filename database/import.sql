
-- Insert data into the 'role' table
INSERT INTO role (name) VALUES ('Admin');
INSERT INTO role (name) VALUES ('User');

--Insert data into the 'color' table
INSERT INTO color(id, name) VALUES (DEFAULT, 'Kollane');
INSERT INTO color(id, name) VALUES (DEFAULT, 'Must');
INSERT INTO color(id, name) VALUES (DEFAULT, 'Sinine');
INSERT INTO color(id, name) VALUES (DEFAULT, 'Roheline');
INSERT INTO color(id, name) VALUES (DEFAULT, 'Pruun');

--Insert data into the 'category' table. KAS OLMET ON VAJA?
INSERT INTO category (id, name) VALUES (DEFAULT, 'Plast- ja metallpakend, joogikartong');
INSERT INTO category (id, name) VALUES (DEFAULT, 'Olme');
INSERT INTO category (id, name) VALUES (DEFAULT, 'Papp- ja paberpakend');
INSERT INTO category (id, name) VALUES (DEFAULT, 'Klaaspakend');
INSERT INTO category (id, name) VALUES (DEFAULT, 'Biojäätmed');

--Insert data into the 'bin' table KAS OLMET ON VAJA?
INSERT INTO bin (id, color_id, name, requiements) VALUES (DEFAULT, 1, 'Plast- ja metallpakendi konteiner', 'Loputa vajadusel, et ei määriks teisi pakendeid. Jäta korgid ja kaaned peale');
INSERT INTO bin (id, color_id, name, requiements) VALUES (DEFAULT, 2, 'Olmeprügi konteiner', '');
INSERT INTO bin (id, color_id, name, requiements) VALUES (DEFAULT, 3, 'Papp- ja paberpakendi konteiner', 'Voldi suured papist pakendid kokku või rebi tükkideks. Veendu, et materjal on kuiv.');
INSERT INTO bin (id, color_id, name, requiements) VALUES (DEFAULT, 4, 'Klaaspakendi konteiner', 'Loputa vajadusel kergelt, et ei määriks teisi pakendeid. Eemalda korgid ja kaaned, sildid võivad jääda.');
INSERT INTO bin (id, color_id, name, requiements) VALUES (DEFAULT, 5, 'Biojäätmete konteiner', 'Biojäätmed pane konteinerisse lahtiselt, paberkotis või täielikult biolaguneva ja komposteeruva kotiga.');

--Insert data into the 'material' table
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PET 1');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'HDPE 2');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PVC 3');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'LDPE 4');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PP 5');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PS 6');

--Insert data into the 'image' table
INSERT INTO image (id, data) VALUES (DEFAULT, E'\\x89504E470D0A1A0A');


-- Insert data into the 'user' table (siin pole company_id foreign key)
INSERT INTO "user"(id, role_id, company_id, email, password, status) VALUES (DEFAULT, 1, 1, 'valio@valio.ee', 'valio', 'A');

--Insert data into the 'company' table
INSERT INTO company (id, user_id, name, registrationcode) VALUES (DEFAULT, 1, 'Valio Eesti AS', 10261303);

--Insert data into the 'product' table EI TÖÖTA
INSERT INTO product (id, company_id, image_id, name, upc, info, status) VALUES (DEFAULT, 1, 1, 'Alma hapukoor 10% 250g', '133456789012', 'pese ja viska', 'A' );


--Insert data into the 'product_material' table
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 1, 1);
















