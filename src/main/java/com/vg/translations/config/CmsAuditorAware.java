package com.vg.translations.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/17/2019
 */


public class CmsAuditorAware implements AuditorAware<String> {

    private String auditor = "auditor";

    @Override
    public Optional<String> getCurrentAuditor() {
//        return ((UserAwareUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser(); // this aproach reqyures mplementation of spring security with UserDetails
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.of(user.getUsername());
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }
}
