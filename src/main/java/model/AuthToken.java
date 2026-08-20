package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthToken {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("token")
    private String token;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthToken authToken = (AuthToken) o;
        return Objects.equals(username, authToken.username) &&
                Objects.equals(password, authToken.password) &&
                Objects.equals(token, authToken.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, token);
    }

    @Override
    public String toString() {
        return "AuthToken{" +
                "username='" + username + '\'' +
                ", password='" + (password != null ? "***" : null) + '\'' +
                ", token='" + (token != null ? "***" : null) + '\'' +
                '}';
    }
}