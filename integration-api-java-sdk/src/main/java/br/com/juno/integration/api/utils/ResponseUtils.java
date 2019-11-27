package br.com.juno.integration.api.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public final class ResponseUtils {

    private ResponseUtils() {
        // NTD
    }

    public static ObjectMapper getObjectMapper() {
        if (mapper == null) {
            mapper = Jackson2ObjectMapperBuilder.json().modules(new Jackson2HalModule()).build();
        }

        return mapper;
    }

    public static Link getLink(ResourceSupport resource, String rel) {
        return resource.getLink(rel);
    }

    public static String getHrefLink(ResourceSupport resource, String rel) {
        Link link = getLink(resource, rel);
        return link == null ? null : link.getHref();
    }

    private static ObjectMapper mapper;
}