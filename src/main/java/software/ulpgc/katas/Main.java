package software.ulpgc.katas;

public class Main {
    static void main(String[] args) {
        String baseUrl = "https://jsonplaceholder.typicode.com";
        UserClient client = new HttpPostAdapter(baseUrl);

        try {
            System.out.println("Fetching user 1...");
            User user = client.getById(1);

            System.out.println("Name: " + user.name());
            System.out.println("Email: " + user.email());

        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }
}
