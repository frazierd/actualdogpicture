package com.nashss.se.dogpicture.http;

/**
 * Represents the response returned from calls to the https://dog.ceo/dog-api/
 * API
 */
public class DogImageUrlResponse {
    private String message;
    private String status;

    /**
     * @return The message contains the URL of a dog image
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The URL of a dog image
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return Hopefully this is always the string "success"
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status Hopefully this is always the string "success"
     */
    public void setStatus(String status) {
        this.status = status;
    }
}