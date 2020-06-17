CREATE TABLE MESSAGE (
  ID serial primary key
  , name VARCHAR NOT NULL
  , text varchar not null
  , remote_addr varchar not null
  , created_at timestamp
);

INSERT INTO MESSAGE (name, text, remote_addr, created_at) VALUES ('joe', 'けものフレンズ', 'example', '2019-01-02 00:00:00');

CREATE TABLE USERS (
    id serial PRIMARY KEY,
    login_id varchar NOT NULL,
    password varchar not null
);

INSERT INTO USERS (login_id, password) VALUES ('example', 'pass');

DROP table message;

DROP TABLE USERS;



