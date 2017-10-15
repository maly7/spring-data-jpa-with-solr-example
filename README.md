Spring Data JPA with Solr Example
---------------------------------

This project demonstrates how to store solr documents with child documents using spring data solr.

To run the project:
1. Edit application.yml so the database url is something you can use
1. `./gradlew solrStart`
2. `./gradlew bootRun`
3. You can run the child doc query directly (`http://localhost:8983/solr/collection1/select?fl=*,[child parentFilter=title_s:*]&indent=on&q=repositories&wt=json`) or you can go to http://localhost:8983/solr to manually query solr.

Notes & Observations
--------------------
* The various repository types need to be enabled and most likely in separate packages.
```java
@EnableJpaRepositories("com.github.maly7.data.jpa")
@EnableSolrRepositories(value = "com.github.maly7.data.solr", multicoreSupport = true)
```
* For some reason multicoreSupport had to be turned on for solr, might have something to do with the solr instance
* A `SolrTemplate` is no longer autoconfigured so one needs to be provided:
```java
    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
```
* While JPA seems to be happy having annotations on Getters rather than fields (as long as you're consistent), Solr is not. There were exceptions related to missing Setters when `@Field` was applied to Getters. This could be related to using the SolrJConverter however.
* If you rely on looking up repository classes via Repositories or RepositoryInvoker, then consider splitting out domain classes (ie have a separate Document class from your Entity class). This should make it so that you always get the right Repository type from one of these methods.
```java
repositories.getRepositoryFor(Book.class); // This seems to always give a solr repository, maybe because it's the last seen?
```
