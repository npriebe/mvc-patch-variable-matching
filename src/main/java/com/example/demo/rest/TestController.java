package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.SecurityConfiguration;

@RestController
public class TestController
{
    /**
     * Secured endpoint by {@link SecurityConfiguration}
     */
    @GetMapping("{username}/secured")
    public String getSecuredEndpoint(@PathVariable String username)
    {
        return username;
    }

    /**
     * Open endpoint by {@link SecurityConfiguration}
     */
    @GetMapping("{firstname}/{lastname}")
    public String getOpenEndpoints(@PathVariable String firstname, @PathVariable String lastname)
    {
        return firstname + " " + lastname;
    }
}
