package com.vg.translations.rest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/22/2019
 */

@RestController
public class AccessDeniedController {
    @RequestMapping("/accessDenied")
    public String home() {
        return "Sorry, you do not have permission to view this page";
    }
}
