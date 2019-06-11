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

CREATE TABLE TABLE_ROLE(
    ROLE_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    TITLE VARCHAR(20) NOT NULL,
    IS_ACTIVE INT
);

CREATE TABLE TABLE_USER_X_ROLE(
    X_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USER_ID BIGINT NOT NULL,
    ROLE_ID BIGINT NOT NULL
);