package masterService.domain.fromTo;

/**
 * Created by Nik on 03.08.2017.
 */
public class User {
    String name;
    String email;
    String password;

    public User() {
    }

    public User(User user) {
        name = user.getName();
        email = user.getEmail();
        password = user.getPassword();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
