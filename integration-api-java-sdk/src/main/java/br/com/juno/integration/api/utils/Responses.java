package br.com.juno.integration.api.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

public final class Responses<T> {

    private final Resources<Resource<T>> resources;

    public Responses(Resources<Resource<T>> resources) {
        this.resources = resources;
    }

    public List<Response<T>> getContent() {
        return resources.getContent().stream().map(Response::new).collect(Collectors.toList());
    }

    public List<T> getAbsoluteContent() {
        return resources.getContent().stream().map(Resource::getContent).collect(Collectors.toList());
    }

    public String getHrefSelf() {
        return ResponseUtils.getHrefLink(resources, "self");
    }

    public String getHrefNext() {
        return ResponseUtils.getHrefLink(resources, "next");
    }

    public String getHrefPrevious() {
        return ResponseUtils.getHrefLink(resources, "previous");
    }
}