package com.github.maly7.data.jpa;

import com.github.maly7.domain.Book;
import com.github.maly7.domain.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public interface BookRepository extends JpaRepository<Book, String> {

    Set<Book> findAllByLabelsContaining(Label label);
}
