package com.vg.translations.repository;

import com.vg.translations.domain.TranslationTemplate;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/4/2019
 */


@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "translation")
@Repository
public interface TranslationRepository extends CouchbasePagingAndSortingRepository<TranslationTemplate, String> {

//        @Query("#{#n1ql.selectEntity} where #{#n1ql.filter} and title = $1 within #{#n1ql.bucket}")

//        @Query("select *, META(cms).id AS _ID, META(cms).cas AS _CAS from CMS cms UNNEST cms.texts t where t.locale = $1") // works ok
        @Query("#{#n1ql.selectEntity} UNNEST translations where translations.locale = $1") // it's a better query with sugar
        List<TranslationTemplate> findByLocale(String locale);

    List<TranslationTemplate> findAll();
}
