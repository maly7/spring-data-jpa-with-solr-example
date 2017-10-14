package com.github.maly7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.convert.SolrJConverter;

@Configuration
public class SolrConfiguration {

    @Bean
    public SolrJConverter solrConverter() {
        return new SolrJConverter();
    }
}
