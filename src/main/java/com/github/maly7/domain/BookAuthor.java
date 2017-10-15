package com.github.maly7.domain;

import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;

@SolrDocument(solrCoreName = "collection1")
@Entity
@Table(name = "BOOK_AUTHOR")
@PrimaryKeyJoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
public class BookAuthor extends Writer {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book bookByBookId) {
        this.book = bookByBookId;
    }

}
