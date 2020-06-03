INSERT INTO discount (id, discounted_quantity, discounted_amount)
VALUES ('D01', 3, 200),
       ('D02', 2, 120);

INSERT INTO watches (id, name, unit_price, discount_id)
VALUES ('001', 'Rolex', 100, 'D01'),
       ('002', 'Michael Kors', 80, 'D02'),
       ('003', 'Swatch', 50, null),
       ('004', 'Casio', 30, null);
