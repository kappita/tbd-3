package tbd3.voluntapp.entities.responses;

public class LoginResponse {
    private boolean success;
    private String jwt;

    public LoginResponse(boolean success, String jwt) {
        this.success = success;
        this.jwt = jwt;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}