DROP TYPE IF EXISTS status;
CREATE TYPE status AS ENUM ('open', 'assign','done');

DROP TYPE IF EXISTS tag;
CREATE TYPE tag AS ENUM ('electrician');

DROP TABLE IF EXISTS image;
CREATE TABLE image
(
    id       BIGSERIAL PRIMARY KEY,
    url      VARCHAR NOT NULL,
    alt_text VARCHAR NOT NULL
);

DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id          BIGSERIAL PRIMARY KEY,
    email       VARCHAR   NOT NULL,
    password    VARCHAR   NOT NULL,
    firstname   VARCHAR   NOT NULL,
    lastname    VARCHAR   NOT NULL,
    description TEXT      NOT NULL,
    verified    BOOLEAN   NOT NULL,
    created     TIMESTAMP NOT NULL,
    image_id    BIGINT REFERENCES image (id)
);

DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR                        NOT NULL,
    description TEXT                           NOT NULL,
    status      STATUS                         NOT NULL,
    created     TIMESTAMP                      NOT NULL,
    account_id  BIGINT REFERENCES account (id) NOT NULL,
    assigned_to BIGINT REFERENCES account (id)
);

DROP TABLE IF EXISTS ticket_image;
CREATE TABLE ticket_image
(
    ticket_id BIGINT REFERENCES ticket (id) NOT NULL,
    image_id  BIGINT REFERENCES image (id)  NOT NULL,
    PRIMARY KEY (ticket_id, image_id)
);

DROP TABLE IF EXISTS account_tag;
CREATE TABLE account_tag
(
    account_id BIGINT REFERENCES account (id) NOT NULL,
    tag        TAG                            NOT NULL,
    PRIMARY KEY (account_id, tag)
);

DROP TABLE IF EXISTS ticket_tag;
CREATE TABLE ticket_tag
(
    ticket_id BIGINT REFERENCES ticket (id) NOT NULL,
    tag       TAG                           NOT NULL,
    PRIMARY KEY (ticket_id, tag)
);