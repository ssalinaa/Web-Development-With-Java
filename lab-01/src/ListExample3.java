import java.util.ArrayList;
import java.util.Arrays;

public class ListExample3 {
    public static boolean searchElement(ArrayList<String> list, String element) {
        return list.contains(element);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        boolean found = searchElement(list, "Bob");
        System.out.println(found);
    }
}
