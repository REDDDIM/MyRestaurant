package interfaces;

public interface LoginService {
    String getLogin();
    void setLogin(String login);
    String getPassword();
    void setPassword(String password);
    boolean check();
    int getUserID();
}
