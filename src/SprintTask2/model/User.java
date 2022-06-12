package SprintTask2.model;

public class User {
    Long id;
    String email;
    String password;
    String full_name;
    Role role;

    public User() {

    }

    public User(Long id, String email, String password, String full_name, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.full_name = full_name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}