import javax.management.relation.Role;

/**
 * Created by byteforce on 2017.04.23..
 */
public class User {;
    public String email;
    public String passwords;
    public Role role;

    public String getEmail() {
        return email;
    }

    public String getPasswords() {
        return passwords;
    }

    public User(String username, String passwords) {
        this.email = username;
        this.passwords = passwords;

    }
    public void setRole(Role role){};
    public Role getRole(){
        return this.role;
    }
    public enum Role {

        admin, user;
    }

}
