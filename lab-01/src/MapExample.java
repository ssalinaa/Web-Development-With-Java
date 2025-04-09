import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static <K, V> int countMappings(Map<K, V> map) {
        return map.size();
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        int mappingsCount = countMappings(map);
        System.out.println("The size of the map is: " + mappingsCount);
    }
}
