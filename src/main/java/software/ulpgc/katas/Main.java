package software.ulpgc.katas;

public class Main {
    static void main(String[] args) {
        String baseUrl = "https://jsonplaceholder.typicode.com";
        TaskClient client = new HttpTaskAdapter(baseUrl);

        try {
            System.out.println("Fetching task 1...");
            Task task = client.getById(1);

            System.out.println("Task title: " + task.title());
            System.out.println("Completed: " + (task.completed() ? "Yes" : "No"));

        } catch (Exception e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }
}
