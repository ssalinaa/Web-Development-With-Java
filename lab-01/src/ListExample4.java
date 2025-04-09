import java.util.ArrayList;
import java.util.Arrays;

public class ListExample4 {
    public static <T> void replaceSecondElement(ArrayList<T> list, T element) {
        if(list != null && list.size() >= 2) {
            list.set(1, element);
        } else {
            System.out.println("The list is too small to replace the second element.");
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Orange"));
        System.out.println("Before: " + list);
        replaceSecondElement(list, "Grapes");
        System.out.println("After: " + list);
    }
}
