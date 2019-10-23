package com.vg.translations.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/21/2019
 */


@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        return "CMS Home";
    }
}
