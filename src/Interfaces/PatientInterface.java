public interface PatientInterface extends User {
    int getQueuePosition();
    String getStatus();
    void updateStatus(String status);
    String getMedicalCondition();
}
