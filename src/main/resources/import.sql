INSERT INTO productos (id , nombre , precio) VALUES ((SELECT next_val FROM productos_seq),'Camara Nikon',1000);
INSERT INTO productos (id , nombre , precio) VALUES ((SELECT next_val+1 FROM productos_seq),'Mac',2000);
INSERT INTO productos (id , nombre , precio) VALUES ((SELECT next_val+2 FROM productos_seq),'Smart Tv',1000);
INSERT INTO productos (id , nombre , precio) VALUES ((SELECT next_val+3 FROM productos_seq),'Gps',1000);
INSERT INTO productos (id , nombre , precio) VALUES ((SELECT next_val+4 FROM productos_seq),'bike',3000);