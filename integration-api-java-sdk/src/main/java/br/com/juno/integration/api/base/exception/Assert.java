package br.com.juno.integration.api.base.exception;

import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/** Helper class for assertions. */
public final class Assert {

    private Assert() {
        // Utility class
    }

    public static void isNull(Object obj, String errorMessage, Object... messageParameters) {
        isTrue(obj == null, errorMessage, messageParameters);
    }

    public static void notNull(Object obj, String errorMessage, Object... messageParameters) {
        isTrue(obj != null, errorMessage, messageParameters);
    }

    public static void notEmpty(Collection<?> col, String errorMessage, Object... messageParameters) {
        isTrue(CollectionUtils.isNotEmpty(col), errorMessage, messageParameters);
    }

    public static void notBlank(CharSequence str, String errorMessage, Object... messageParameters) {
        isTrue(StringUtils.isNotBlank(str), errorMessage, messageParameters);
    }

    public static void isTrue(boolean condition, String errorMessage, Object... messageParameters) {
        if (!condition) {
            throw new JunoApiException(String.format(errorMessage, messageParameters));
        }
    }
}