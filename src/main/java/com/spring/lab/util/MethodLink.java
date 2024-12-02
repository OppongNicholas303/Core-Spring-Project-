package com.spring.lab.util;

import com.spring.lab.hateoas.Link;
import org.springframework.stereotype.Component;

@Component
public class MethodLink {
    private final String baseUrl = "http://localhost:8080/api/customers/";

    public Link get(int id) {
        return new Link(
                baseUrl + id,
                "self",
                "GET"
        );
    }

    public Link put(int id) {
        return new Link(
                baseUrl + id,
                "update",
                "PUT"
        );
    }

    public Link delete(int id) {
        return new Link(
                baseUrl + id,
                "delete",
                "DELETE"
        );
    }
}