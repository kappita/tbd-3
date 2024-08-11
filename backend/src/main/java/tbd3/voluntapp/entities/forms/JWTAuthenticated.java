package tbd3.voluntapp.entities.forms;

public class JWTAuthenticated<T> {
    private String token;
    private T data;

    public JWTAuthenticated(String token, T data) {
        this.token = token;
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
