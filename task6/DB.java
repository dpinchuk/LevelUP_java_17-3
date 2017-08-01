package home.task6;

public class DB {

    private static int size = -1;
    private static User[] users = new User[5];

    private DB() {}

    public static User[] getUser() {
        return users;
    }

    public static void setUser(User user) {
        users[++size] = user;
    }

    public static int getSize() {
        return size;
    }

}