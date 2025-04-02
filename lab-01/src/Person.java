public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "No name";
        this.age = -1;
    }

    public Person(String name) {
        this.name = name;
        this.age = -1;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        if(this.name.equals("No name") && this.age == -1) {
            return "I am John Doe.";
        } else if(this.age == -1) {
            return "Hello, I am " + this.name + ".";
        } else if(this.name.equals("No name")) {
            return "Hello, I am " + this.age + " years old.";
        } else {
            return "Hello, I am " + this.name + ". I am " + this.age + " years old.";
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        System.out.println(person1);

        Person person2 = new Person("Alice");
        System.out.println(person2);

        Person person3 = new Person("Bob", 25);
        System.out.println(person3);
    }
}
