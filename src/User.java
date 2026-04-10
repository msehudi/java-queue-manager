import java.time.LocalDate;

public class User implements UserInterface {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private String userType;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        String[] parts = name.split(" ", 2);
        return parts[0];
    }

    @Override
    public void setFirstName(String firstName) {
        String[] parts = name.split(" ", 2);
        this.name = parts.length > 1 ? firstName + " " + parts[1] : firstName;
    }

    @Override
    public String getLastName() {
        String[] parts = name.split(" ", 2);
        return parts.length > 1 ? parts[1] : "";
    }

    @Override
    public void setLastName(String lastName) {
        String[] parts = name.split(" ", 2);
        this.name = parts[0] + " " + lastName;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String getUserType() {
        return userType;
    }
}
