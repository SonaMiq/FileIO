import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
        BufferedWriter bufferedWriter;
        BufferedReader bufferedReader;

    {
        try {
            bufferedReader = new BufferedReader(new FileReader("user.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("user.txt", true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(User user) {
        try {
            bufferedWriter.write(user.getName() + " " + user.getSurname() + " " + user.getAge() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {

        try {

            String s = "";
            while (true) {

                s = bufferedReader.readLine();
                if (s == null)
                    break;
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void remove(String name) {

        try {

            List<User> users = new ArrayList<>();
            String s = "";
            String[] arr;
            while (true) {
                s = bufferedReader.readLine();
                if (s == null)
                    break;
                arr = s.split(" ");
                if (!arr[0].equals(name)) {
                    users.add(new User(arr[0], arr[1], Integer.parseInt(arr[2])));
                }
            }
            bufferedWriter = new BufferedWriter(new FileWriter("user.txt"));
            bufferedWriter.write("");
            bufferedWriter = new BufferedWriter(new FileWriter("user.txt", true));
            for (User user:users) {
                add(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void exit() {

        try {
            bufferedReader.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
