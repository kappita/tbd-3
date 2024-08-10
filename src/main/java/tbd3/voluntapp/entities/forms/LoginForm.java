package tbd3.voluntapp.entities.forms;

public class LoginForm {
    private String email;
    private String password;

    public LoginForm(String username, String password) {
        this.email = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String username) {
        this.email = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
