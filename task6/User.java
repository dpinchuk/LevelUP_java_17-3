package home.task6;

public class User {

    private String login;
    @Encrypted(crypt = "[Encode password]")
    private String password;

    public User(String login, String password) throws IllegalAccessException, NoSuchFieldException {
        this.login = login;
        this.password = password;
        Cryptographer.enCrypt(this); // variant 1
        //Cryptographer.enCryptOneField(this); // variant 2
        DB.setUser(this);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}