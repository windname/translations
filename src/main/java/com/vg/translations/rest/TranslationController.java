package com.vg.translations.rest;

import com.vg.translations.repository.TranslationRepository;
import com.vg.translations.domain.TranslationTemplate;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/4/2019
 */

@Log
@RestController
public class TranslationController {

    @Autowired
    TranslationRepository repository;

    @Autowired
    CouchbaseTemplate couchbaseTemplate;

    @RequestMapping(value = "/translation/{title}", method = RequestMethod.GET)
    public ResponseEntity<TranslationTemplate> get(@PathVariable(value = "title") String title) {

        Optional<TranslationTemplate> translationOpt = repository.findById("TS:test:" + title);
        translationOpt.orElseThrow(() -> new RuntimeException("Cannot find element by title"));
        return ResponseEntity.ok().body(translationOpt.get());
    }

    @RequestMapping(value = "/translation/locale/{locale}", method = RequestMethod.GET)
    public ResponseEntity<List<TranslationTemplate>> getLocale(@PathVariable(value = "locale") String locale) {
        List<TranslationTemplate> translations = repository.findByLocale(locale);
        return ResponseEntity.ok().body(translations);
    }

    @RequestMapping(value = "/translation", method = RequestMethod.POST)
    public ResponseEntity<TranslationTemplate> add(@RequestBody TranslationTemplate translation) {
        translation.setUniverse("test");
        translation.setDomain("TS");
        TranslationTemplate translationTemplate = repository.save(translation);
        String id = couchbaseTemplate.getGeneratedId(translationTemplate);
        log.info("translation id=" + id);
        return ResponseEntity.ok().body(translationTemplate);
    }
}
