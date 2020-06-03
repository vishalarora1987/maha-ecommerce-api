INSERT INTO watches (id, name, unit_price)
VALUES ('001', 'Rolex', 100),
       ('002', 'Michael Kors', 80),
       ('003', 'Swatch', 50),
       ('004', 'Casio', 30);

INSERT INTO discount (watch_id, discounted_quantity, discounted_amount)
VALUES ('001', 3, 200),
       ('002', 2, 120);
