import java.util.*;

// Purpose of Registration is to create a account and update particular to CSV in CSV folder.
public class Registration extends constructUser {

    public List<String[]> loginParticularCSV;

    public Registration(String name, String username, String password, userType usertype) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = usertype;
    }

    public void Register() {
        // Hash the password, store the password into CSV pegged to the other
        // particulars
        Hash hashFunction = new Hash();
        long hashPass = hashFunction.HashPassword(password);

        // read CSV and add to last line of CSV
        try {
            loginParticularCSV = File_IO.readFile("loginParticular");
            String[] temp = { name, username, String.valueOf(hashPass), type.toString() };
            loginParticularCSV.add(temp);
            File_IO.writeFile(loginParticularCSV, "loginParticular");
        } catch (Exception e) {
            System.out.println("registration fail, please try again!");
        }
        System.out.println("Registration completed! Welcome.");

    }

    public static void main(String[] args) {
        // Registration test = new Registration("ben", "tang", "BenTang", userType.MOVIEGOER);
        // Registration test = new Registration("staff1", "staff1", "staffpass", userType.STAFF);
        Registration test = new Registration("les", "ter", "password", userType.MOVIEGOER);
        test.Register();
    }

}
