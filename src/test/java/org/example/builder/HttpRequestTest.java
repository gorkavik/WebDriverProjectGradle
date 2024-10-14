package org.example.builder;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.helpers.Issues.ERROR_MESSAGE_GENERAL;
import static org.example.helpers.Issues.ERROR_MESSAGE_RESPONSE;

public class HttpRequestTest {

    private String response = null;
    private HttpRequest request;

    @Test
    public void sendRequest() {
        request = new HttpRequest.Builder("https://petstore3.swagger.io/api/v3/pet/findByStatus?status=available")
                .method("GET")
                .contentType("application/json")
                .build();
        try {
            response = request.send();
        } catch (IOException e) {
            System.out.println(ERROR_MESSAGE_GENERAL);
            e.getMessage();
            e.printStackTrace();
        }
        System.out.println("Response: " + response);

        Assert.assertNotNull(response, ERROR_MESSAGE_RESPONSE);
    }
}
