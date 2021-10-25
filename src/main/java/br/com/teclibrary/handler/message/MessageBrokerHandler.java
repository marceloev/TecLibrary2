package br.com.teclibrary.handler.message;

import br.com.teclibrary.model.exception.BusinessException;

import javax.inject.Singleton;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Objects;

@Singleton
public class MessageBrokerHandler {

    private final Map<Locale, ResourceBundle> resources = new HashMap();

    public String translate(final BusinessException exception) { //TODO: Get user locale
        return translate(Locale.getDefault(), exception);
    }

    public String translate(final Locale locale, final BusinessException exception) {
        ResourceBundle resourceBundle = getResource(locale);
        String key = String.format("%s.%s", exception.getError().getClass().getName(), exception.getError().name());
        MessageFormat messageFormat = new MessageFormat(resourceBundle.getString(key), locale);
        return messageFormat.format(exception.getParams());
    }

    private ResourceBundle getResource(final Locale locale) {
        ResourceBundle resourceBundle = resources.get(locale);
        if (Objects.isNull(resourceBundle)) {
            resourceBundle = ResourceBundle.getBundle("messages", locale);
            resources.put(locale, resourceBundle);
        }

        return resourceBundle;
    }

}
