/*Запускать скрипты только при первом запуске, когда в базе еще нет ничего*/
INSERT INTO public.role(
	id, description, name)
	VALUES (1, 'Администратор', 'admin');
INSERT INTO public.role(
	id, description, name)
	VALUES (2, 'Клиент', 'client');
INSERT INTO public.users(
	id, address, login, name, password, phone_number, surname)
	VALUES (3, 'admin_address', 'admin', 'admin_name', 'eXjiPZIUTvaV7UyBr5E0Y6gf6yioPGdSOJx3l7EW/dE7CE59AUn1D1S35oKDtv+F', 0123456789, 'admin_surname');
INSERT INTO public.users(
	id, address, login, name, password, phone_number, surname)
	VALUES (4, 'client_address', 'client', 'client_name', 'jxiWTvx9se2lU/0y+DtGv8NoHH3q6epp3QooZ7ZADAXHlg1ilS/R70uPDYXMzOnA', 9876543210, 'client_surname');
INSERT INTO public.users_roles(
	user_id, roles_id)
	VALUES (3, 1);
INSERT INTO public.users_roles(
	user_id, roles_id)
	VALUES (4, 2);
INSERT INTO public.role_users(
	role_id, users_id)
	VALUES (1, 3);
INSERT INTO public.role_users(
	role_id, users_id)
	VALUES (2, 4);