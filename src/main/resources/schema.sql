DROP TABLE IF EXISTS watches;
DROP TABLE IF EXISTS discount;

CREATE TABLE watches
(
    id         VARCHAR(20) PRIMARY KEY,
    name       VARCHAR(50) NOT NULL,
    unit_price NUMERIC     NOT NULL
);

CREATE TABLE discount
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    watch_id            VARCHAR(20) NOT NULL,
    discounted_quantity INT         NOT NULL,
    discounted_amount   NUMERIC     NOT NULL
);
