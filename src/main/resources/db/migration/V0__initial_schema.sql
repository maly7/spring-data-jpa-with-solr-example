CREATE TABLE book (
  id    VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (id)
);

CREATE TABLE writer (
  id   VARCHAR(255) NOT NULL,
  name VARCHAR(36)  NOT NULL
);

CREATE TABLE book_author (
  author_id VARCHAR(255) NOT NULL,
  book_id   VARCHAR(255) NOT NULL,
  PRIMARY KEY (author_id),
  CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES writer (id),
  CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES book (id)
);