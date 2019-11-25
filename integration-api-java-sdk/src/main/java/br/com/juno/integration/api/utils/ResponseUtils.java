package br.com.juno.integration.api.utils;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public final class ResponseUtils {

    private ResponseUtils() {
        // NTD
    }

    public static String getHrefLink(ResourceSupport resource, String rel) {
        Link link = resource.getLink(rel);
        return link == null ? null : link.getHref();
    }
}