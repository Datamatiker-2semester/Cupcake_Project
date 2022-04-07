package dat.startcode.model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User
{
    private List<User>userlist=new ArrayList<>();
    private int user_id;
    private String username;
    private String password;
    private String role;
    private String email;
    private int balance;


    public User(String username, String password, String role, String email, int balance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.balance = balance;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User(String username, String password, String email,String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public int getBalance() {
        return balance;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getUsername(), getPassword(), getRole());
    }
}
