create table users (
    USERNO INT GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1) NOT NULL,
    USERID VARCHAR(45) NOT NULL,
    USERNAME VARCHAR(45) NOT NULL,
    PASSWORD VARCHAR(45) NOT NULL,
    PRIMARY KEY (USERID)
);