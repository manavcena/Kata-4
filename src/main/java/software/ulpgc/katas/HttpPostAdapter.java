package software.ulpgc.katas;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPostAdapter implements UserClient{
    private final String baseUrl;
    private final HttpClient httpClient;
    private final Gson gson;

    public HttpPostAdapter(String baseUrl) {
        this.baseUrl = baseUrl;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    @Override
    public User getById(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/users/" + id))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Service returned status code: " + response.statusCode());
            }

            return gson.fromJson(response.body(), User.class);

        } catch (Exception e) {
            throw new RuntimeException("Network or parsing error: " + e.getMessage());
        }
    }
}
