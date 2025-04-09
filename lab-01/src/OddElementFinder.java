import java.util.ArrayList;
import java.util.List;

public class OddElementFinder {
    public static int getNthOddElement(int[] array, int n) {
        List<Integer> oddNumbers = new ArrayList<>();

        for(int num : array) {
            if(num % 2 != 0) {
                oddNumbers.add(num);
            }
        }
        if(n > oddNumbers.size() || n <= 0) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return oddNumbers.get(n - 1);
    }

    public static void main(String[] args) {
        int[] numbers = {12, 15, 7, 8, 9, 10, 3, 5, 11, 19};

        try {
            System.out.println(getNthOddElement(numbers, 3));
            System.out.println(getNthOddElement(numbers, 5));
            System.out.println(getNthOddElement(numbers, 7));
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
