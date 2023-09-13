
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

--Insert data into the 'bin' table

INSERT INTO bin (id, color_id, name, requirements) VALUES (DEFAULT, 1, 'Plast- ja metallpakendi konteiner', 'Loputa vajadusel, et ei määriks teisi pakendeid. Jäta korgid ja kaaned peale');
INSERT INTO bin (id, color_id, name, requirements) VALUES (DEFAULT, 2, 'Olmeprügi konteiner', '');
INSERT INTO bin (id, color_id, name, requirements) VALUES (DEFAULT, 3, 'Papp- ja paberpakendi konteiner', 'Voldi suured papist pakendid kokku või rebi tükkideks. Veendu, et materjal on kuiv.');
INSERT INTO bin (id, color_id, name, requirements) VALUES (DEFAULT, 4, 'Klaaspakendi konteiner', 'Loputa vajadusel kergelt, et ei määriks teisi pakendeid. Eemalda korgid ja kaaned, sildid võivad jääda.');
INSERT INTO bin (id, color_id, name, requirements) VALUES (DEFAULT, 5, 'Biojäätmete konteiner', 'Biojäätmed pane konteinerisse lahtiselt, paberkotis või täielikult biolaguneva ja komposteeruva kotiga.');

--Insert data into the 'material' table
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PET 1');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'HDPE 2');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PVC 3');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'LDPE 4');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PP 5');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'PS 6');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 3, 3, 'PAP-20');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 3, 3, 'PAP-21');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 3, 3, 'PAP-22');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 4, 4, 'GL-70');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 4, 4, 'GL-71');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 4, 4, 'GL-72');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'FE');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 1, 1, 'ALU');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 2, 2, 'materjal, mida pole võimalik taaskasutada');
INSERT INTO material(id, category_id, bin_id, name) VALUES (DEFAULT, 5, 5, 'biolagunev');




--Insert data into the 'image' table
INSERT INTO image (id, data) VALUES (DEFAULT, E'\\x89504E470D0A1A0A');
INSERT INTO image (id, data) VALUES (DEFAULT, E'\\x89504E470D0A1A0A');

INSERT INTO "user"(id, role_id, email, password, status) VALUES (DEFAULT, 2, 'tairi', '123', 'A');
INSERT INTO "user"(id, role_id, email, password, status) VALUES (DEFAULT, 1, 'admin ', '123', 'A');
INSERT INTO "user"(id, role_id, email, password, status) VALUES (DEFAULT, 2, 'valio', '123', 'A');

--Insert data into the 'company' table
INSERT INTO company (id, user_id, name, registrationcode) VALUES (DEFAULT, 1, 'EU DIRECTIVE', 20000001);
INSERT INTO company (id, user_id, name, registrationcode) VALUES (DEFAULT, 2, 'Lipton Llc.', 30261303);
INSERT INTO company (id, user_id, name, registrationcode) VALUES (DEFAULT, 3, 'Valio Eesti AS', 10261303);

--Insert data into the 'product' table

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'ALU', 'ALU', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'biolagunev', 'biolagunev', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'FE', 'FE', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'GL-70', 'GL-70', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'GL-71', 'GL-71', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'GL-72', 'GL-72', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'HDPE 2', 'HDPE 2', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'LDPE 4', 'LDPE 4', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'PAP-20', 'PAP-20', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'PAP-21', 'PAP-21', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'PAP-22', 'PAP-22', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'PET 1', 'PET 1', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'PP 5', 'PP 5', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'PS 6', 'PS 6', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 1, 'PVC 3', 'PVC 3', 'pese ja viska', 'A' );

INSERT INTO product (id, company_id, image_id, name, upc, info, status)
VALUES (DEFAULT, 1, 2, 'Alma hapukoor 10% 250g', '133456789012', 'pese ja viska', 'A' );

--Insert data into the 'product_material' table
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 1, 1);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 2, 2);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 3, 3);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 4, 4);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 5, 5);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 6, 6);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 7, 7);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 8, 8);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 9, 9);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 10, 10);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 11, 11);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 12, 12);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 13, 13);
INSERT INTO product_material (id, product_id, material_id)  VALUES (DEFAULT, 14, 14);
















