package dat.startcode.model.entities;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private String role;
    private int balance;

    public User(int userId, String username,String password, String email, String role, int balance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.balance = balance;
    }

    public User(int maxUsers, String username, String password, String email) {

    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public int getBalance() {
        return balance;
    }
}