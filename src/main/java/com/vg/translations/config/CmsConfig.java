package com.vg.translations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.Arrays;
import java.util.List;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/17/2019
 */

@Configuration
@EnableCouchbaseAuditing
@EnableCouchbaseRepositories(basePackages = {"com.vg.translations.repository"})
public class CmsConfig  extends AbstractCouchbaseConfiguration {

    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("localhost");
    }

    @Override
    protected String getBucketName() {
        return "cms";
    }

    @Override
    protected String getBucketPassword() {
        return "";
    }

    @Bean
    public CmsAuditorAware testAuditorAware() {
        return new CmsAuditorAware();
    }

}
