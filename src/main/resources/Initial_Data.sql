INSERT INTO age (age) VALUES ('antique');
INSERT INTO age (age) VALUES ('classic');
INSERT INTO age (age) VALUES ('retro');
INSERT INTO age (age) VALUES ('contemporary');
INSERT INTO age (age) VALUES ('paleolithic');
INSERT INTO category (category) VALUES ('arrowhead');
INSERT INTO category (category) VALUES ('coins');
INSERT INTO category (category) VALUES ('cards');
INSERT INTO category (category) VALUES ('stamps');
INSERT INTO category (category) VALUES ('ornaments');
INSERT INTO category (category) VALUES ('books');
INSERT INTO color (color) VALUES ('blue');
INSERT INTO color (color) VALUES ('red');
INSERT INTO color (color) VALUES ('green');
INSERT INTO color (color) VALUES ('yellow');
INSERT INTO color (color) VALUES ('purple');
INSERT INTO color (color) VALUES ('orange');
INSERT INTO condition (condition) VALUES ('new');
INSERT INTO condition (condition) VALUES ('mint');
INSERT INTO condition (condition) VALUES ('used');
INSERT INTO condition (condition) VALUES ('fair');
INSERT INTO condition (condition) VALUES ('poor');
INSERT INTO condition (condition) VALUES ('stained');
INSERT INTO keyword (keyword) VALUES ('shiny');
INSERT INTO keyword (keyword) VALUES ('large');
INSERT INTO keyword (keyword) VALUES ('fancy');
INSERT INTO keyword (keyword) VALUES ('expensive');
INSERT INTO keyword (keyword) VALUES ('counterfeit');
INSERT INTO keyword (keyword) VALUES ('tiny');
INSERT INTO keyword (keyword) VALUES ('massachusettsian');
INSERT INTO keyword (keyword) VALUES ('frigid');
INSERT INTO keyword (keyword) VALUES ('bearded');
INSERT INTO keyword (keyword) VALUES ('fungal');
INSERT INTO keyword (keyword) VALUES ('swiveling');
INSERT INTO keyword (keyword) VALUES ('annoying');
INSERT INTO keyword (keyword) VALUES ('genuine');
INSERT INTO keyword (keyword) VALUES ('speedy');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('AAA-123456789101', 'swiss nuclear war has begun in a long battle running for many years and has to stop before time runs out -- type of clock', 'clock', TRUE, 1, 1, 1, '5/12/2012', '7/17/2014');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate) VALUES ('BBB-223456789101', 'so comfortable', 'chair', FALSE, 2, 2, 2, '6/16/1993');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate) VALUES ('CCC-323456789101', 'extremely plastic', 'cup', FALSE, 3, 3, 3, '3/29/1981');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('DDD-423456789101', 'lava', 'lamp', TRUE, 4, 4, 4, '7/2/2014', '2/16/2015');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('EEE-523456789101', 'the first magazine i ever read', 'magazine', TRUE, 5, 5, 5, '11/10/1922', '2/29/1984');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('FFF-623456789101', 'a diamond encrusted pen', 'pen', TRUE, 1, 6, 6, '10/19/1958', '1/4/1978');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('ABC-723456789101', 'money', 'baseball', TRUE, 5, 3, 6, '4/22/2005', '6/10/2006');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('DEF-823456789101', 'hello...hello? HELLO???', 'phone', TRUE, 5, 4, 6, '4/22/2008', '5/23/2009');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate ) VALUES ('GZZ-923456789101', 'We ARE strangers to love.', 'settler', FALSE, 2, 1, 4, '5/12/2015');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('ZIE-103456789101', 'Do not leave children unattended with this...unless you want some new art on your walls.', 'marker', FALSE, 1, 2, 1, '4/22/2008', '5/23/2009');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate) VALUES ('WET-113456789101', 'It looks like you are trying to do something. Would you like some help?', 'paperclip', FALSE, 3, 6, 3, '4/22/2008');
INSERT INTO collectible (cataloguenumber, description, name, sold, age_id, category_id, condition_id, purchaseDate, sellDate) VALUES ('LWE-123456789101', 'I am a banana', 'banana', TRUE, 4, 5, 5, '4/22/2008', '3/13/2042');
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (1,1);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (1,2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (1,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (2,4);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (2,5);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (2,6);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (3,7);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (3,8);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (3,9);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (4,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (4,10);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (4,11);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (4,12);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (5,13);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (5,14);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (5,5);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,6);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,8);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,9);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (6,11);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (7,1);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (7,5);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (7,9);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (7,13);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (7,12);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (8,12);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (8,2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (8,6);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (9,10);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (9,9);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (9,8);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (10,7);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (10,3);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (10,6);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (11,2);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (11,9);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (11,12);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (12,13);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (12,4);
INSERT INTO collectible_keyword (collectibleid, keywordid) VALUES (12,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (1,1);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (1,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (1,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (2,1);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (2,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (3,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (3,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (3,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (4,6);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (5,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (6,6);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (6,4);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (6,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (7,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (7,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (7,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (8,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (8,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (9,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (10,1);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (10,3);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (11,2);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (11,5);
INSERT INTO collectible_color (collectibleid, colorid) VALUES (12,4);

