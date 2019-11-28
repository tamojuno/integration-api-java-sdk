package br.com.juno.integration.api.utils;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import br.com.juno.integration.api.base.exception.JunoApiException;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestParsingException;

public final class ResponseUtils {

    private ResponseUtils() {
        // NTD
    }

    public static void validateSuccess(HttpResponse<?> response) {
        if (!response.isSuccess()) {
            UnirestParsingException parsingException = response.getParsingError().orElse(null);
            if (parsingException != null) {
                throw new JunoApiException(parsingException);
            }

            throw new JunoApiException(response.getStatusText());
        }
    }

    public static Link getLink(ResourceSupport resource, String rel) {
        return resource.getLink(rel);
    }

    public static String getHrefLink(ResourceSupport resource, String rel) {
        Link link = getLink(resource, rel);
        return link == null ? null : link.getHref();
    }

}