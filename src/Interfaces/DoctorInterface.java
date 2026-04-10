public interface DoctorInterface extends User {
    void checkSchedule();
    void updateAvailability(boolean isAvailable);
    String getSpecialization();
    boolean isAvailable();
}
