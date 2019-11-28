package br.com.juno.integration.api.services.response;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;

import br.com.juno.integration.api.utils.ResponseUtils;

public final class Responses<T> {

    private final Resources<Resource<T>> resources;
    private String resourceToken;

    public Responses(Resources<Resource<T>> resources) {
        this.resources = resources;
    }

    public Responses(Resources<Resource<T>> resources, String resourceToken) {
        this(resources);
        this.resourceToken = resourceToken;
    }

    public Responses(List<Responses<T>> pagedResponses, String resourceToken) {
        List<Resource<T>> flattenResources = pagedResponses.stream() //
                .flatMap(responses -> responses.getContent().stream()) //
                .map(Response::getResource) //
                .collect(Collectors.toList()); //

        if (CollectionUtils.isNotEmpty(pagedResponses)) {
            Responses<T> lastResponse = pagedResponses.get(!pagedResponses.isEmpty() ? pagedResponses.size() - 1 : pagedResponses.size());
            this.resources = new Resources<>(flattenResources, lastResponse.getLinks());
        } else {
            this.resources = new Resources<>(new LinkedList<>());
        }

        this.resourceToken = resourceToken;
    }

    public List<Response<T>> getContent() {
        return resources.getContent().stream().map(Response::new).collect(Collectors.toList());
    }

    public List<T> getAbsoluteContent() {
        return resources.getContent().stream().map(Resource::getContent).collect(Collectors.toList());
    }

    public void setResourceToken(String resourceToken) {
        this.resourceToken = resourceToken;
    }

    public String getResourceToken() {
        return resourceToken;
    }

    private List<Link> getLinks() {
        return Arrays.asList(getSelfLink(), getPreviousLink(), getNextLink()).stream().filter(Objects::nonNull).collect(Collectors.toList());
    }

    public boolean hasNext() {
        return hasResources() && getNextLink() != null;
    }

    public boolean hasResources() {
        return resources != null && CollectionUtils.isNotEmpty(resources.getContent());
    }

    private Link getSelfLink() {
        return ResponseUtils.getLink(resources, "self");
    }

    private Link getNextLink() {
        return ResponseUtils.getLink(resources, "next");
    }

    private Link getPreviousLink() {
        return ResponseUtils.getLink(resources, "previous");
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