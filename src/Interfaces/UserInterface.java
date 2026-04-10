
package src.Interfaces;
import java.time.LocalDate;


public interface UserInterface {
    void setId(int id);
    int getId();

    String getFirstName();
    void setFirstName(String firstName);

    String getLastName();
    void setLastName(String lastName);

    void setDateOfBirth(LocalDate dateOfBirth);
    LocalDate getDateOfBirth();

    void setUserType(String userType);
    String getUserType();
}
