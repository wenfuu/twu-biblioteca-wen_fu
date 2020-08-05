### Q1: Who checked out the book 'The Hobbit’?
```
SELECT member.name FROM member, book, checkout_item WHERE member.id = checkout_item.member_id AND checkout_item.book_id = book.id AND book.title = 'The Hobbit';
```

*Output: Anand Beck*

### Q2: How many people have not checked out anything?
```
SELECT (SELECT count(id) FROM member) - (SELECT count(DISTINCT) member_id) FROM checkout_item);
```

*Output: 37*

### Q3: What books and movies aren't checked out?
```
SELECT title FROM book WHERE id NOT IN (SELECT book_id FROM checkout_item WHERE book_id IS NOT NULL) union SELECT title FROM movie WHERE id NOT IN (SELECT movie_id FROM checkout_item WHERE movie_id IS NOT NULL);
```

*Output:<br>
1984<br>
Catcher in the Rye<br>
Crouching Tiger, Hidden Dragon<br>
Domain Driven Design<br>
Fellowship of the Ring<br>
Lawrence of Arabia<br>
Office Space<br>
Thin Red Line<br>
To Kill a Mockingbird<br>
Tom Sawyer*

### Q4: Add the book 'The Pragmatic Programmer', and add yourself as a member. Check out 'The Pragmatic Programmer'. Use your query from question 1 to verify that you have checked it out. Also, provide the SQL used to update the database.
```
INSERT INTO book (id, title) VALUES (11, "The Pragmatic Programmer");
INSERT INTO member (id, name) VALUES (43, "Wen Fu");
INSERT INTO checkout_item (book_id, member_id) VALUES (11, 43);
SELECT member.name FROM member, book, checkout_item WHERE member.id = checkout_item.member_id AND checkout_item.book_id = book.id AND book.title = 'The Pragmatic Programmer';
```

*Output: Wen Fu*

### Q5: Who has checked out more than 1 item? 
```
SELECT name FROM member WHERE member.id IN (SELECT member_id FROM checkout_item GROUP BY member_id HAVING COUNT(member_id) >= 2);
```

*Output:<br>
Anand Beck<br>
Frank Smith*