package com.github.maly7;

import com.github.maly7.data.jpa.BookRepository;
import com.github.maly7.data.solr.SolrBookRepository;
import com.github.maly7.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.github.maly7.data.jpa")
@EnableSolrRepositories(value = "com.github.maly7.data.solr", multicoreSupport = true)
//TODO: figure out why we need to turn on multicore support for this
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(BookRepository bookRepository, SolrBookRepository solrBookRepository) {
        return args -> {
            solrBookRepository.deleteAll();
            bookRepository.deleteAll();

            Book book = new Book();
            book.setTitle("A Tale of Two Repositories");

            Book savedBook = bookRepository.save(book);
            solrBookRepository.save(savedBook);
        };
    }
}
