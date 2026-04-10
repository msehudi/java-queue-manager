public class Doctor implements DoctorInterface {
    private String name;
    private String specialization;
    private boolean available;
    private String username;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public boolean login(String username, String password) {
        this.username = username;
        System.out.println("Doctor " + name + " logged in.");
        return true;
    }

    @Override
    public String getUserType() {
        return "DOCTOR";
    }

    public boolean login(String username, String password) {
        this.username = username;
        System.out.println("Doctor " + name + " logged in.");
        return true;
    }

    @Override
    public void checkSchedule() {
        System.out.println("Checking schedule for Dr. " + name);
        // Implementation for checking schedule
    }

    @Override
    public void updateAvailability(boolean isAvailable) {
        this.available = isAvailable;
        System.out.println("Dr. " + name + " is now " + (isAvailable ? "available" : "unavailable"));
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Dr. " + name + " (" + specialization + ") - " + (available ? "Available" : "Busy");
    }
}
