package model;

public class ItemCategory {
    private static int idCounter = 1;

    private Integer id;
    private String name;
    private String description;

    public ItemCategory(String name, String description) {
        this.id = idCounter++;
        this.name = name;
        this.description = description;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
