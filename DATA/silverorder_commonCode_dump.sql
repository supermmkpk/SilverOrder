 
 
 INSERT INTO T_CODE_GROUP(GROUP_ID, GROUP_NAME, INSERT_DATE) VALUES
 (10, '���� ����', GETDATE()),
 (11, '�޴� ����', GETDATE()),
 (12, '�ֹ� ����', GETDATE()),
 (21, '�������� ����', GETDATE()),
 (22, '���� ī�װ�', GETDATE());

INSERT INTO T_COMMON_CODE(CODE_ID, GROUP_ID, CODE_VALUE, INSERT_DATE) VALUES
(1, 10, '������', GETDATE()),
(2, 10, '��������', GETDATE()),
(3, 10, '�غ���', GETDATE()),
(4, 10, '�ӽ� ����', GETDATE()),
(5, 10, '��� ����', GETDATE()),
(6, 11, '�Ǹ���', GETDATE()),
(7, 11, '����', GETDATE()),
(8, 12, '�ֹ� ���', GETDATE()),
(9, 12, '�غ���', GETDATE()),
(10, 12, '�޴� �ϼ�', GETDATE()),
(11, 12, '�ֹ� �Ϸ�', GETDATE()),
(12, 21, 'ī�� ����', GETDATE()),
(13, 21, '������ �Ա�', GETDATE())