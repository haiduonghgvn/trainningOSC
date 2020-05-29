package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * demoCache
 *
 * @author duongnch
 * @created_at 27/05/2020 - 3:37 PM
 * @created_by duongnch
 * @since 27/05/2020
 */
@Component
public class Translator {
    private static ResourceBundleMessageSource resourceBundleMessageSource;
    @Autowired
    Translator(ResourceBundleMessageSource messageSource){
        Translator.resourceBundleMessageSource = messageSource;
    }

    public static String toLocale(String messageCode,String... param){
        Locale locale = LocaleContextHolder.getLocale();
        return resourceBundleMessageSource.getMessage(messageCode,param,locale);
    }
}
