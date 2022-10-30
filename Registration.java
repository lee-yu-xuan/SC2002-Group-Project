import java.io.*;
import java.nio.file.*;

// Purpose of Registration is to create a account and update particular to CSV in CSV folder.
public class Registration extends constructUser {

    public Registration(String name, String username, String password, userType usertype) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = usertype;
    }

    public void Register() {
        // Hash the password, store the password into CSV pegged to the other
        // particular.
        Hash hashFunction = new Hash();
        long hashPass = hashFunction.HashPassword(password);
        // get current working directory and pointer to CSV
        String cwdStr = Paths.get("").toAbsolutePath().toString();
        // String csvDirect = cwdStr + "\\CSV\\loginParticular.csv";
        // System.out.println(cwdStr);
        // System.out.println(csvDirect);
        String personInfo = name + "," + username + "," + String.valueOf(hashPass) + "," + type + "\r\n";

        // read CSV and add to last line of CSV
        try {
            BufferedReader reader = Files.newBufferedReader(Paths.get(cwdStr + "\\CSV\\loginParticular.csv"));
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(cwdStr + "\\CSV\\temp.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            writer.write(personInfo);
            writer.close();
            reader.close();
        } catch (Exception e) {
            System.out.println("error file!");
        }

        // delete old file rename temp file to loginParticular
        File f = new File(cwdStr + "\\CSV\\loginParticular.csv");
        f.delete();
        File f2 = new File(cwdStr + "\\CSV\\temp.csv");
        f2.renameTo(f);
    }

    public static void main(String[] args) {
        Registration test = new Registration("les", "ter", "pass", userType.MOVEIGOER);
        test.Register();

    }

}
