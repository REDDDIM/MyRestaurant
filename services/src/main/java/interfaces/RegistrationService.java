package interfaces;

public interface RegistrationService {
    String getRegistration();
    void setRegistration(String login);
    String getPassword();
    void setPassword(String password);
    boolean check();
    int getUserID();
}
