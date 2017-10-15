package com.github.maly7.data.jpa;

import com.github.maly7.domain.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
}
