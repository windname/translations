package com.vg.translations.domain;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
//import org.springframework.data.annotation.*;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;
import org.springframework.data.couchbase.core.mapping.id.IdPrefix;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.USE_ATTRIBUTES;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/4/2019
 */


@Data
@Document
public class TranslationTemplate {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = USE_ATTRIBUTES, delimiter = ":")
    // couchbase set it automatically idPrefix + IdAttribute
    private String id;

    @Field
    @NotNull
    @IdAttribute
    private String title;

    @IdPrefix(order=0)
    @JsonIgnore
    private String domain;

    @IdPrefix(order=1)
    @JsonIgnore
    private String universe;

    @Field
    List<Translation> translations;

    @CreatedBy
    private String creator;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date lastModification;

    @CreatedDate
    private Date creationDate;

    @Version
    private long version;

}
