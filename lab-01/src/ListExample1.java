import java.util.ArrayList;
import java.util.Arrays;

public class ListExample1 {
    public static String retrieveElement(ArrayList<String> list, int index) {
        if(index >= 0 && index < list.size()) {
            return list.get(index);
        } else {
            return "Index out of bounds";
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        String element = retrieveElement(list, 1);
        System.out.println(element);
    }
}
