-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2023-09-05 13:21:31.888

-- tables
-- Table: bin
CREATE TABLE bin (
                     id serial  NOT NULL,
                     color_id int  NOT NULL,
                     name varchar(255)  NOT NULL,
                     requiements varchar(255)  NULL,
                     CONSTRAINT bin_pk PRIMARY KEY (id)
);

-- Table: category
CREATE TABLE category (
                          id serial  NOT NULL,
                          name varchar(255)  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: color
CREATE TABLE color (
                       id serial  NOT NULL,
                       name varchar(255)  NOT NULL,
                       CONSTRAINT color_pk PRIMARY KEY (id)
);

-- Table: company
CREATE TABLE company (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         name varchar(255)  NOT NULL,
                         registrationcode int  NOT NULL,
                         CONSTRAINT company_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       data bytea  NOT NULL,
                       CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: material
CREATE TABLE material (
                          id serial  NOT NULL,
                          category_id int  NOT NULL,
                          bin_id int  NOT NULL,
                          name varchar(255)  NOT NULL,
                          CONSTRAINT material_pk PRIMARY KEY (id)
);

-- Table: product
CREATE TABLE product (
                         id serial  NOT NULL,
                         company_id int  NOT NULL,
                         image_id int  NULL,
                         name varchar(255)  NOT NULL,
                         upc varchar(14)  NOT NULL,
                         info varchar(255)  NOT NULL,
                         status char(1)  NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table: product_material
CREATE TABLE product_material (
                                  id serial  NOT NULL,
                                  product_id int  NOT NULL,
                                  material_id int  NOT NULL,
                                  CONSTRAINT product_material_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        company_id int  NOT NULL,
                        email varchar(255)  NOT NULL,
                        password varchar(30)  NOT NULL,
                        status char(1)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: bin_color (table: bin)
ALTER TABLE bin ADD CONSTRAINT bin_color
    FOREIGN KEY (color_id)
        REFERENCES color (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
-- Reference: company_user (table: company)
ALTER TABLE company ADD CONSTRAINT company_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: material_bin (table: material)
ALTER TABLE material ADD CONSTRAINT material_bin
    FOREIGN KEY (bin_id)
        REFERENCES bin (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: material_category (table: material)
ALTER TABLE material ADD CONSTRAINT material_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_company (table: product)
ALTER TABLE product ADD CONSTRAINT product_company
    FOREIGN KEY (company_id)
        REFERENCES company (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_image (table: product)
ALTER TABLE product ADD CONSTRAINT product_image
    FOREIGN KEY (image_id)
        REFERENCES image (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_material_material (table: product_material)
ALTER TABLE product_material ADD CONSTRAINT product_material_material
    FOREIGN KEY (material_id)
        REFERENCES material (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: product_material_product (table: product_material)
ALTER TABLE product_material ADD CONSTRAINT product_material_product
    FOREIGN KEY (product_id)
        REFERENCES product (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;
--kas on vaja?
--ALTER TABLE "user" ADD CONSTRAINT company_id
--    FOREIGN KEY (company_id)
    --    REFERENCES company (id)
   --     NOT DEFERRABLE
   --         INITIALLY IMMEDIATE
;


-- End of file.
