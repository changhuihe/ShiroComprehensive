DELIMITER ;
delete from sys_user;
delete from sys_role;
delete from sys_resource;
delete from sys_organization;

insert into sys_user values(1,1,'admin','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f', '1', false);
insert into sys_organization values(1, '�ܹ�˾', 0, '0/', true);
insert into sys_organization values(2, '�ֹ�˾1', 1, '0/1/', true);
insert into sys_organization values(3, '�ֹ�˾2', 1, '0/1/', true);
insert into sys_organization values(4, '�ֹ�˾11', 2, '0/1/2/', true);

insert into sys_resource values(1, '��Դ', 'menu', '', 0, '0/', '', true);

insert into sys_resource values(11, '��֯��������', 'menu', '/organization', 1, '0/1/', 'organization:*', true);
insert into sys_resource values(12, '��֯��������', 'button', '', 11, '0/1/11/', 'organization:create', true);
insert into sys_resource values(13, '��֯�����޸�', 'button', '', 11, '0/1/11/', 'organization:update', true);
insert into sys_resource values(14, '��֯����ɾ��', 'button', '', 11, '0/1/11/', 'organization:delete', true);
insert into sys_resource values(15, '��֯�����鿴', 'button', '', 11, '0/1/11/', 'organization:view', true);

insert into sys_resource values(21, '�û�����', 'menu', '/user', 1, '0/1/', 'user:*', true);
insert into sys_resource values(22, '�û�����', 'button', '', 21, '0/1/21/', 'user:create', true);
insert into sys_resource values(23, '�û��޸�', 'button', '', 21, '0/1/21/', 'user:update', true);
insert into sys_resource values(24, '�û�ɾ��', 'button', '', 21, '0/1/21/', 'user:delete', true);
insert into sys_resource values(25, '�û��鿴', 'button', '', 21, '0/1/21/', 'user:view', true);

insert into sys_resource values(31, '��Դ����', 'menu', '/resource', 1, '0/1/', 'resource:*', true);
insert into sys_resource values(32, '��Դ����', 'button', '', 31, '0/1/31/', 'resource:create', true);
insert into sys_resource values(33, '��Դ�޸�', 'button', '', 31, '0/1/31/', 'resource:update', true);
insert into sys_resource values(34, '��Դɾ��', 'button', '', 31, '0/1/31/', 'resource:delete', true);
insert into sys_resource values(35, '��Դ�鿴', 'button', '', 31, '0/1/31/', 'resource:view', true);

insert into sys_resource values(41, '��ɫ����', 'menu', '/role', 1, '0/1/', 'role:*', true);
insert into sys_resource values(42, '��ɫ����', 'button', '', 41, '0/1/41/', 'role:create', true);
insert into sys_resource values(43, '��ɫ�޸�', 'button', '', 41, '0/1/41/', 'role:update', true);
insert into sys_resource values(44, '��ɫɾ��', 'button', '', 41, '0/1/41/', 'role:delete', true);
insert into sys_resource values(45, '��ɫ�鿴', 'button', '', 41, '0/1/41/', 'role:view', true);

insert into sys_role values(1, 'admin', '��������Ա', '11,21,31,41', true);