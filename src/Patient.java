public class Patient extends AbstractUser implements PatientInterface {
    private String name;
    private int age;
    private String dateOfBirth;
    private String medicalCondition;
    private String status;
    private int queuePosition;

    public Patient(String name, int age, String dateOfBirth, String medicalCondition) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.medicalCondition = medicalCondition;
        this.status = "WAITING";
        this.queuePosition = -1;
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
    public String getUserType() {
        return "PATIENT";
    }

    @Override
    public int getQueuePosition() {
        return queuePosition;
    }

    public void setQueuePosition(int position) {
        this.queuePosition = position;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void updateStatus(String status) {
        this.status = status;
        System.out.println("Patient " + name + " status updated to: " + status);
    }

    @Override
    public String getMedicalCondition() {
        return medicalCondition;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(String dob) {
        this.dateOfBirth = dob;
    }

    @Override
    public String toString() {
        return name + " (DOB: " + dateOfBirth + ", Age: " + age + ", Condition: " + medicalCondition + ", Status: " + status + ")";
    }
}
