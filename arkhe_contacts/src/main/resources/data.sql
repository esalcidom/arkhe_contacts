
-- INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_ADMIN');
INSERT INTO AUTHORITY (NAME) VALUES ('ROLE_USER');

INSERT INTO TABLE_CONTACT (FIRST_NAME, LAST_NAME, OTHER_NAME, PHONE, EMAIL, ADDRESS_ID, BIRTHDATE, GENDER, TAX_REGIME, DOCUMENT_TYPE, DOCUMENT_NUMBER, LAST_UPDATE) VALUES ('EMMANUEL', 'SALCIDO', 'EL COMPA', '3314261518', 'beco@hotmail.com', 1, TO_DATE('12-07-1989','DD-MM-YYYY'), 1, 1, 2, '12345', TO_DATE('26-05-2019','DD-MM-YYYY'));

INSERT INTO TABLE_CONTACT (FIRST_NAME, LAST_NAME, OTHER_NAME, PHONE, EMAIL, ADDRESS_ID, BIRTHDATE, GENDER, TAX_REGIME, DOCUMENT_TYPE, DOCUMENT_NUMBER, LAST_UPDATE) VALUES ('ANA YATZIKURI', 'TORRES', 'Amorcito', '3319953558', 'yatzikuri@hotmail.com', 3, TO_DATE('07-05-1991','DD-MM-YYYY'), 2, 1, 2, '12345', TO_DATE('26-05-2019','DD-MM-YYYY'));

INSERT INTO TABLE_CONTACT (FIRST_NAME, LAST_NAME, OTHER_NAME, PHONE, EMAIL, ADDRESS_ID, BIRTHDATE, GENDER, TAX_REGIME, DOCUMENT_TYPE, DOCUMENT_NUMBER, LAST_UPDATE) VALUES ('PAVEL', 'ANGULO', 'PASHA', '3318152614', 'pasha@hotmail.com', 2, TO_DATE('10-07-1989','DD-MM-YYYY'), 1, 2, 2, '12345', TO_DATE('26-05-2019','DD-MM-YYYY'));

INSERT INTO TABLE_CONTACT (FIRST_NAME, LAST_NAME, OTHER_NAME, PHONE, EMAIL, ADDRESS_ID, BIRTHDATE, GENDER, TAX_REGIME, DOCUMENT_TYPE, DOCUMENT_NUMBER, LAST_UPDATE) VALUES ('EMMANUEL', 'CUEVAZ', null, '3311223344', 'beco@hotmail.com', 1, TO_DATE('12-07-1989','DD-MM-YYYY'), 1, 1, 2, '12345', TO_DATE('26-05-2019','DD-MM-YYYY'));

INSERT INTO TABLE_ADDRESS (STREET, EXT_NUM, INT_NUM, NEIGHBORHOOD, CITY_ID, STATE_ID, ZIPCODE) VALUES ('UXMAL', '256', NULL, 'MONUMENTAL', 1, 1,'44320');
INSERT INTO TABLE_ADDRESS (STREET, EXT_NUM, INT_NUM, NEIGHBORHOOD, CITY_ID, STATE_ID, ZIPCODE) VALUES ('UXMAL', '1142', NULL, 'MONUMENTAL', 1, 1,'44320');INSERT INTO TABLE_ADDRESS (STREET, EXT_NUM, INT_NUM, NEIGHBORHOOD, CITY_ID, STATE_ID, ZIPCODE) VALUES ('Antiguo Camino a Copalita', '2711', NULL, 'Valle Imperial', 1, 1,'44320');

INSERT INTO TABLE_GENDER (GENDER_NAME) VALUES ('MALE');
INSERT INTO TABLE_GENDER (GENDER_NAME) VALUES ('FEMALE');

INSERT INTO TABLE_TAX_REG (TAX_NAME) VALUES ('PERSONA FISICA');
INSERT INTO TABLE_TAX_REG (TAX_NAME) VALUES ('PERSONA MORAL');

INSERT INTO TABLE_CONTACT_IDENT (DOCUMENT_NAME) VALUES ('INE');
INSERT INTO TABLE_CONTACT_IDENT (DOCUMENT_NAME) VALUES ('PASSPORT');

INSERT INTO TABLE_CITY (CITY_NAME) VALUES ('GUADALAJARA');

INSERT INTO TABLE_STATE (STATE_NAME) VALUES ('JALISCO');