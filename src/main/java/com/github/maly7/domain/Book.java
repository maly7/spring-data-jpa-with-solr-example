package com.github.maly7.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.solr.client.solrj.beans.Field;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.util.Set;

@Entity
@SolrDocument(solrCoreName = "collection1")
//TODO: Why do annotations need to be on fields?
public class Book {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID")
    @Field(value = "id")
    private String id;

    @Basic
    @Column(name = "TITLE")
    @Field(value = "title_s")
    private String title;

    @Field(child = true)
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BookAuthor> authors;

    @ManyToMany
    @JoinTable(name = "book_label",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private Set<Label> labels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<BookAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<BookAuthor> authors) {
        this.authors = authors;
    }

    public Set<Label> getLabels() {
        return labels;
    }

    public void setLabels(Set<Label> labels) {
        this.labels = labels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new EqualsBuilder()
                .append(id, book.id)
                .append(title, book.title)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .toHashCode();
    }
}
