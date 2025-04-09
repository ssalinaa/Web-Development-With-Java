import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample {
    public static void insertFirst(ArrayList<String> list, String element) {
        list.add(0, element);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        insertFirst(list, "John");
        System.out.println(list);
    }
}
