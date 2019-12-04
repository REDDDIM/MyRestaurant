/*Запускать скрипты только при первом запуске, когда в базе еще нет ничего*/
INSERT INTO public.role(
	id, description, name)
	VALUES (1, 'Администратор', 'ROLE_admin');
INSERT INTO public.role(
	id, description, name)
	VALUES (2, 'Клиент', 'ROLE_client');
INSERT INTO public.users(
	id, address, login, name, password, phone_number, surname, role_id)
	VALUES (3, 'admin_address', 'admin', 'admin_name', 'v/kxXM/rPPfbR0h6EYt6obU1KiBrUzMcMQk+agL73evWVNelld4Oic1e5WVNl3L0', 0123456789, 'admin_surname', 1);
INSERT INTO public.users(
	id, address, login, name, password, phone_number, surname, role_id)
	VALUES (4, 'client_address', 'client', 'client_name', 'OFDe6NPf28BWIKXLdPBUIDY8MeoLDLtosTFCgfB89GW+j0btbEQXGViFz0pVX/iW', 9876543210, 'client_surname', 2);
INSERT INTO public.menu(
	id, ingredients, price, title, unit, weight)
	VALUES (5, 'some ingredients', 150.00, 'salad', 1, 100);
INSERT INTO public.order_type(
	id, description, name)
	VALUES (6, 'Самовывоз', 'self-delivery');
INSERT INTO public.order_type(
	id, description, name)
	VALUES (7, 'Доставка', 'delivery');
INSERT INTO public.order_type(
	id, description, name)
	VALUES (8, 'Самовывоз', 'self_delivery');
INSERT INTO public.order_type(
	id, description, name)
	VALUES (9, 'Доставка', 'courier_delivery');
INSERT INTO public.order_status(
	id, description, name)
	VALUES (10, 'Новый', 'new');
INSERT INTO public.order_status(
	id, description, name)
	VALUES (11, 'Передан курьеру', 'transferred_to_the_courier');
INSERT INTO public.order_status(
	id, description, name)
	VALUES (12, 'Завершен', 'completed');
INSERT INTO public.role(
	id, description, name)
	VALUES (13, 'Курьер', 'ROLE_courier');
INSERT INTO public.users(
	id, address, login, name, password, phone_number, surname, role_id)
	VALUES (14, 'courier_address', 'courier', 'courier_name', 'lm2P5UhgPcJ8djmG2HnJWgG56mGzgz3x73BgN5QTVT4kwkVoiGzMgLoVI0ip2kB/', 0000000000, 'courier_surname', 13);
select setval('hibernate_sequence', 15);
ALTER TABLE public.users ADD CONSTRAINT user_login_unique UNIQUE (login);