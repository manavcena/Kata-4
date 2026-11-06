package software.ulpgc.katas;

public class Main {
    static void main(String[] args) {
        String baseUrl = "https://jsonplaceholder.typicode.com";
        PostClient client = new HttpPostAdapter(baseUrl);

        try {
            Post post = client.getById(1);

            System.out.println("Title: " + post.title());
            System.out.println("Body: " + post.body());

        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }
}
