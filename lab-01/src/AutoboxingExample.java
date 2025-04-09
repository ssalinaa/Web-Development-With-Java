public class AutoboxingExample {
    public static void main(String[] args) {
        int primitiveInt = 10;
        Integer wrappedInt1 = primitiveInt;
        System.out.println("Autoboxing: " + primitiveInt + " -> " + wrappedInt1);

        Integer wrappedInt2 = 100;
        int unboxedInt = wrappedInt2;
        System.out.println("Unboxing: " + wrappedInt2 + " -> " + unboxedInt);

        double primitiveDouble = 3.14;
        Double wrappedDouble1 = primitiveDouble;
        System.out.println("Autoboxing: " + primitiveDouble + " -> " + wrappedDouble1);

        Double wrappedDouble2 = 9.99;
        double unboxedDouble = wrappedDouble2;
        System.out.println("Unboxing: " + wrappedDouble2 + " -> " + unboxedDouble);
    }
}
