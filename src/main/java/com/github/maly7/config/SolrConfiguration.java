package com.github.maly7.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.SolrJConverter;

@Configuration
public class SolrConfiguration {

    @Bean
    public SolrJConverter solrConverter() {
        return new SolrJConverter();
    }

    //NOTE: it looks like spring data/boot doesn't provide a SolrTemplate out of the box when you use both jpa and solr
    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
}
