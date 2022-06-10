package com.nashss.se.dogpicture.http;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class provides a mechanism for downloading the URL to a random dog image
 * It uses a free dog picture api described here: https://dog.ceo/dog-api/
 */
public class DogImageUrlFetcher {
    // This the url we access that will provide another URL that points to a dog
    // picture.
    private static final String API_URL = "https://dog.ceo/api/breeds/image/random";

    /**
     * Fetch the URL for the random dog image
     * NOTE: Internally this method uses the Jackson library to convert the
     * API's JSON response into an instance of DogUrlResponse
     * 
     * @return A URL that points to a random dog image
     * @throws IOException
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public URL fetch() throws IOException, InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        DogImageUrlResponse response = client.sendAsync(request, BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(json -> {
                    try {
                        ObjectMapper mapper = new ObjectMapper();
                        return mapper.readValue(json, DogImageUrlResponse.class);
                    } catch (JsonProcessingException e) {
                        return null;
                    }
                }).get();

        return new URL(response.getMessage());
    }
}