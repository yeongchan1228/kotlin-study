package advanced;

import java.io.FileWriter;

public class TryWithResources {
    public static void main(String[] args) {
        // 자동으로 close 호출
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Hello Java!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
