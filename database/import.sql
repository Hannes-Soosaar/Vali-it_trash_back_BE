INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rain', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'mitteaktiivne', '123', 'D');

INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');

INSERT INTO public.location (id, city_id, name, number_of_atms, image_id, status) VALUES (DEFAULT, 2, 'Mustamäe Prisma', 5, null, 'A');
INSERT INTO public.location (id, city_id, name, number_of_atms, image_id, status) VALUES (DEFAULT, 3, 'Jõe Prisma', 2, null, 'A');
INSERT INTO public.location (id, city_id, name, number_of_atms, image_id, status) VALUES (DEFAULT, 2, 'Sikupilli Prisma', 4, null, 'A');


INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'raha sisse');
INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'raha välja');
INSERT INTO public.transaction_type (id, name) VALUES (DEFAULT, 'maksed');

INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 1, 1, true);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 2, 1, true);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 3, 1, true);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 1, 2, true);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 2, 2, true);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 3, 2, false);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 1, 3, true);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 2, 3, false);
INSERT INTO public.location_transaction_type (id, transaction_type_id, location_id, is_selected) VALUES (DEFAULT, 3, 3, false);