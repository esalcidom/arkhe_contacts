CREATE TABLE TABLE_USER(
    USER_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME VARCHAR(30) NOT NULL,
    LAST_NAME VARCHAR(30) NOT NULL,
    LOGIN_NAME VARCHAR(30) NOT NULL,
    PASS VARCHAR(30) NOT NULL,
    IS_BLOQUED INT,
    LAST_LOGIN DATE,
    LAST_BAD_LOGIN DATE,
    BAD_LOGIN_COUNT INT
);

CREATE TABLE TABLE_CONTACT(
    CONTACT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FIRST_NAME VARCHAR(30) NOT NULL,
    LAST_NAME VARCHAR(30) NOT NULL,
    OTHER_NAME VARCHAR(30),
    PHONE VARCHAR(30),
    EMAIL VARCHAR(30),
    ADDRESS_ID BIGINT,
    BIRTHDATE DATE NOT NULL,
    GENDER INT,
    TAX_REGIME INT NOT NULL,
    DOCUMENT_TYPE INT,
    DOCUMENT_NUMBER VARCHAR(30),
    LAST_UPDATE DATE
);

CREATE TABLE TABLE_ADDRESS(
    ADDRESS_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    STREET VARCHAR(50) NOT NULL,
    EXT_NUM VARCHAR(10) NOT NULL,
    INT_NUM VARCHAR(10),
    NEIGHBORHOOD VARCHAR(30),
    CITY_ID BIGINT NOT NULL,
    STATE_ID INT NOT NULL,
    ZIPCODE VARCHAR(10),
);

CREATE TABLE TABLE_GENDER(
    GENDER_ID INT AUTO_INCREMENT PRIMARY KEY,
    GENDER_NAME VARCHAR(20) NOT NULL
);

CREATE TABLE TABLE_TAX_REG(
    TAX_ID INT AUTO_INCREMENT PRIMARY KEY,
    TAX_NAME VARCHAR(20) NOT NULL
);

CREATE TABLE TABLE_ROLE(
    ROLE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(20) NOT NULL,
    IS_ACTIVE INT
);

CREATE TABLE TABLE_CONTACT_IDENT(
    DOCUMENT_ID INT AUTO_INCREMENT PRIMARY KEY,
    DOCUMENT_NAME VARCHAR(20) NOT NULL
);

CREATE TABLE TABLE_CITY(
    CITY_ID INT AUTO_INCREMENT PRIMARY KEY,
    CITY_NAME VARCHAR(30) NOT NULL
);

CREATE TABLE TABLE_STATE(
    STATE_ID INT AUTO_INCREMENT PRIMARY KEY,
    STATE_NAME VARCHAR(30) NOT NULL
);

CREATE TABLE TABLE_USER_X_ROLE(
    X_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT NOT NULL,
    ROLE_ID BIGINT NOT NULL
);