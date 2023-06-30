package com.example.demo.config.impl;

import com.example.demo.config.MessageConfig;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageConfigImpl implements MessageConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setDefaultEncoding("windows-1251");
        return messageSource;
    }


    @Override
    public String getMessage(String code, Object... objects) {
        try {
            return messageSource().getMessage(code, objects, Locale.getDefault());
        } catch (NoSuchMessageException e) {
            throw new RuntimeException(getMessage("message.source.generate.error", e));
        }
    }
}
