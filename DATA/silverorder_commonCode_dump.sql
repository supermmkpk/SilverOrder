 
 
 INSERT INTO T_CODE_GROUP(GROUP_ID, GROUP_NAME, INSERT_DATE) VALUES
 (10, '가게 상태', GETDATE()),
 (11, '메뉴 상태', GETDATE()),
 (12, '주문 상태', GETDATE()),
 (21, '결제수단 유형', GETDATE()),
 (22, '할인 카테고리', GETDATE());

INSERT INTO T_COMMON_CODE(CODE_ID, GROUP_ID, CODE_VALUE, INSERT_DATE) VALUES
(1, 10, '영업중', GETDATE()),
(2, 10, '영업종료', GETDATE()),
(3, 10, '준비중', GETDATE()),
(4, 10, '임시 휴일', GETDATE()),
(5, 10, '재료 소진', GETDATE()),
(6, 11, '판매중', GETDATE()),
(7, 11, '매진', GETDATE()),
(8, 12, '주문 대기', GETDATE()),
(9, 12, '준비중', GETDATE()),
(10, 12, '메뉴 완성', GETDATE()),
(11, 12, '주문 완료', GETDATE()),
(12, 21, '카드 결제', GETDATE()),
(13, 21, '무통장 입금', GETDATE())