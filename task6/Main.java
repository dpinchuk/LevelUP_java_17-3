package home.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchFieldException {

        String login = "";
        String pass = "";
        boolean authorization;
        //users in DataBase
        new User("pinchuk.dap@gmail.com", "dmss111278");
        new User("dpin", "123456");
        new User("380971344443", "111111");

        int count = DB.getSize() + 1;

        //try ti create new user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Authorization:" + "\n");

        while(count != DB.getUser().length) {
            authorization = true;
            System.out.println((count + 1) + "/" + DB.getUser().length);
            // enter new login
            System.out.print("Enter [login]: ");
            login = reader.readLine();

            // 1. enter new password
            System.out.print("Enter [password]: ");
            pass = reader.readLine();

            // 2. coding password
            pass = Cryptographer.enCoder(pass.trim());

            // 3. Compare new password with passwords in the database (DB)
            for (User user : DB.getUser()) {
                if (user != null) {
                    if (pass.equals(user.getPassword())) {
                        System.out.println("Incorrect password! User not created." + "\n");
                        authorization = false;
                        break;
                    }
                } else {
                    break;
                }
            }

            if (authorization) { // authorization success with emty filds
                new User(login, Cryptographer.deCoder(pass));
                System.out.println("\n" + "Created new User [" + DB.getUser()[count].getLogin() + "]" + "\n");
                count++;
            }
        }

        for (User users : DB.getUser()) {
            if (users != null) {
                System.out.println("Login: [" + users.getLogin() + "]");
            } else {
                break;
            }
        }
    }

}