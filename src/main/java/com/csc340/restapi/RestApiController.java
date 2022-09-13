package com.csc340.restapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author senih
 */
@RestController
public class RestApiController {

    @GetMapping("/")
    public String Index() {
        return "Welcome to the REST API!";
    }

    /**
     * Make a request to the kanye.rest API and return reponse to the user
     * @return
     */
    @GetMapping("/quote")
    public String Quote() {
        String url = "https://api.kanye.rest";
        RestTemplate restTemplate = new RestTemplate();

        // Make the request and save data in a variable
        String quote = restTemplate.getForObject(url, String.class);
        
        // Parse the quote from the response.
        JSONObject jo = new JSONObject(quote);
        System.out.println(jo.toString());
        String quoteContent = jo.getString("quote");

        // Print the quote
        System.out.println("Random Quote by Kanye: " + quoteContent);

        return quote;
    }
}
