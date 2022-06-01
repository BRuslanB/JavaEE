package Chapter7.model;

public class User {
    Long id;
    String login;
    String password;
    String full_name;

    public User() {
    }

    public User(Long id, String login, String password, String full_name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.full_name = full_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
         return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}