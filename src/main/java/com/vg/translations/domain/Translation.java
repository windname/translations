package com.vg.translations.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 10/4/2019
 */


@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Translation {
    String locale;
    String text;
}
