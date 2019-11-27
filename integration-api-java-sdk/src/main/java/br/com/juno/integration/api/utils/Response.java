package br.com.juno.integration.api.utils;

import org.springframework.hateoas.Resource;

public final class Response<T> {

    private final Resource<T> resource;

    public Response(Resource<T> resource) {
        this.resource = resource;
    }

    public T getContent() {
        return resource.getContent();
    }

    public Resource<T> getResource() {
        return resource;
    }

    public String getHrefSelf() {
        return ResponseUtils.getHrefLink(resource, "self");
    }
}