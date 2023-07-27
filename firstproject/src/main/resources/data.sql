INSERT INTO article(title, content) values ('dummy1', '1111');
INSERT INTO article(title, content) values ('dummy2', '2222');
INSERT INTO article(title, content) values ('dummy3', '3333');

-- article dummy data
INSERT INTO article(title, content) values ('title1', 'content1');
INSERT INTO article(title, content) values ('title2', 'content2');
INSERT INTO article(title, content) values ('title3', 'content3');

-- comment dummy data
-- article 4
INSERT INTO comment(id, article_id, nickname, body) values(1, 4, 'user1', 'comment4-1');
INSERT INTO comment(id, article_id, nickname, body) values(2, 4, 'user2', 'comment4-2');
INSERT INTO comment(id, article_id, nickname, body) values(3, 4, 'user3', 'comment4-3');

-- article 5
INSERT INTO comment(id, article_id, nickname, body) values(4, 5, 'user1', 'comment5-1');
INSERT INTO comment(id, article_id, nickname, body) values(5, 5, 'user2', 'comment5-2');
INSERT INTO comment(id, article_id, nickname, body) values(6, 5, 'user3', 'comment5-3');

-- article 6
INSERT INTO comment(id, article_id, nickname, body) values(7, 6, 'user1', 'comment6-1');
INSERT INTO comment(id, article_id, nickname, body) values(8, 6, 'user2', 'comment6-2');
INSERT INTO comment(id, article_id, nickname, body) values(9, 6, 'user3', 'comment6-3');