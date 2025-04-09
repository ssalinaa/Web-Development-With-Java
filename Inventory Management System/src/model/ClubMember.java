package model;

public class ClubMember {
    private static int idCounter = 1;

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public ClubMember(String firstName, String lastName, String email) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Integer getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }

    public void setId(int id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Club Member: " + "\nId: " + id + "\nFirst name: " + firstName +
                "\nLast name: " + lastName + "\nEmail: " + email;
    }
}
