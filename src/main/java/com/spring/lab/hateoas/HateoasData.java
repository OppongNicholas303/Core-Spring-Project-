package com.spring.lab.hateoas;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HateoasData<T> {
    private T content;
    private List<Link> links;

    public HateoasData() {
        this.links = new ArrayList<>();
    }

    public HateoasData(T content) {
        this.content = content;
        this.links = new ArrayList<>();
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void addLink(Link link) {
        this.links.add(link);
    }
}