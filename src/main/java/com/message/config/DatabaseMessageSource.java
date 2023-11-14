package com.message.config;

import com.message.repository.LanguageRepository;
import com.message.repository.Languages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * 스프링에 messageSource 등록.
 * @Configuration @bean 으로 등록 가능
 */
@Component("messageSource")
public class DatabaseMessageSource extends AbstractMessageSource {

    private final LanguageRepository languageRepository;
    private static final String DEFAULT_LOCALE_CODE = "ko";

    @Autowired
    public DatabaseMessageSource(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {
        Languages message = languageRepository.findByMessageKeyAndLocale(key, locale.getLanguage());
        if (message == null) {
            message = languageRepository.findByMessageKeyAndLocale(key, DEFAULT_LOCALE_CODE);
        }
        return new MessageFormat(message.getMessageContent(), locale);
    }
}