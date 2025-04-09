import java.util.ArrayList;
import java.util.Arrays;

public class ListExample2 {
    public static void removeThirdElement(ArrayList<String> list) {
        if(list.size() >= 3) {
            list.remove(2);
        } else {
            System.out.println("List does not have a third element.");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));
        removeThirdElement(list);
        System.out.println(list);
    }
}
