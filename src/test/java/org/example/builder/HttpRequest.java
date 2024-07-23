package org.example.builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequest {

    private String url;
    private String method;
    private String body;
    private String contentType;

    private HttpRequest(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.body = builder.body;
        this.contentType = builder.contentType;
    }

    public String send() throws IOException {
        URL url = new URL(this.url);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(this.method);
        connection.setRequestProperty("Content-Type", this.contentType);

        if (this.body != null && (this.method.equals("POST") || this.method.equals("PUT"))) {
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                os.write(this.body.getBytes());
                os.flush();
            }
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        }

        connection.disconnect();
        return response.toString();
    }

    public static class Builder {

        private String url;
        private String method = "GET"; // Метод по умолчанию
        private String body;
        private String contentType = "application/json"; // Тип контента по умолчанию

        public Builder(String url) {
            this.url = url;
        }

        public Builder method(String method) {
            this.method = method;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder contentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}
