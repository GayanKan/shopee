INSERT INTO COUPON VALUES(1, 'Ten Euro', 10);
INSERT INTO COUPON VALUES(2, 'Twenty Euro', 20);
INSERT INTO COUPON VALUES(3, 'Fifty Euro', 50);
INSERT INTO COUPON VALUES(4, 'Hundrard Euro', 100);
commit;


select * from coupon;


INSERT INTO PROFILE  (PROFILE_ID, AGE, CATEGORY, EMAIL, FIRST_NAME, LANGUAGE, LAST_NAME, MOBILE_NUMBER, USER_NAME) values (1000, 30, 'PARTNER', 'test@shoppe.com', 'K Market', 'fi', 'K-Market Oy' , '+358 41 567 987', 'kmarket');
INSERT INTO PROFILE  (PROFILE_ID, AGE, CATEGORY, EMAIL, FIRST_NAME, LANGUAGE, LAST_NAME, MOBILE_NUMBER, USER_NAME) values (1001, 30, 'PARTNER', 'test1@shoppe.com', 'S Market', 'fi', 'S-Market Oy' , '+358 41 567 000', 'smarket');
commit;

INSERT INTO PARTNER (ID, ADDRESS, LEGAL_NAME, MARKETING_NAME, PROFILE_ID) VALUES (100, 'K-Market Turku', 'K-Market', 'K-Market', 1000);
INSERT INTO PARTNER (ID, ADDRESS, LEGAL_NAME, MARKETING_NAME, PROFILE_ID) VALUES  (101, 'S-Market Turku', 'S-Market', 'S-Market', 1001);

commit;


select * from PROFILE;

select * from PARTNER;
