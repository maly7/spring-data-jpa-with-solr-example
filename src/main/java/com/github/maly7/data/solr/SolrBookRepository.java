package com.github.maly7.data.solr;

import com.github.maly7.domain.Book;
import org.springframework.data.solr.repository.SolrRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolrBookRepository extends SolrRepository<Book, Long> {
}
