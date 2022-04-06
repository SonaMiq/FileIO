import java.util.InputMismatchException;
import java.util.Scanner;

public class GUI {

    Validator validator = new Validator();
    UserService userService = new UserService();
    Scanner sc = new Scanner(System.in);

    public void start() {
        boolean cont = true;
        while (cont) {
            System.out.println("1: Add User \n" +
                    "2: Remove User \n" +
                    "3: View all Users \n" +
                    "4: Exit");

            boolean correctAnswer = true;
            int choose = 0;
            do {
                System.out.println("Choose action");
                try {
                    choose = sc.nextInt();
                } catch (InputMismatchException e) {
                    choose = 0;
                    sc.next();
                }
                switch (choose) {
                    case 1:
                        add();
                        break;
                    case 2:
                        remove();
                        break;
                    case 3:
                        getAll();
                        break;
                    case 4:
                        exit();
                        cont = false;
                        break;
                    default:
                        System.out.println("Choose correct");
                        correctAnswer = false;
                }
            }
            while (!correctAnswer);
        }
    }

    private void add() {

        System.out.println("User name: ");
        String name = sc.next();
        while (!validator.isValid(name)) {
            System.out.println("Insert correct name");
            name = sc.next();
        }
        System.out.println("Surname: ");
        String surname = sc.next();
        System.out.println("Age: ");
        int age = sc.nextInt();
        while (!validator.isValid(age)) {
            System.out.println("Insert correct age");
            age = sc.nextInt();
        }
        userService.add(new User(name, surname, age));
    }


    private void remove() {
        System.out.println("User name, that you want remove: ");
        String name = sc.next();
        userService.remove(name);
    }

    private void getAll() {
        userService.read();
    }

    private void exit() {
        userService.exit();
    }
}
