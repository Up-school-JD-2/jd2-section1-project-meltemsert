package user;

import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final String password;
    private String email;

    public User(String fullName, String password, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = fullName;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
