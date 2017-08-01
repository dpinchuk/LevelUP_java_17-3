package home.task8;

public class User {

    private String fistname;
    private String secondname;
    private String phoneNumber;

    public User(String fistname, String secondname, String phoneNumber) {
        this.fistname = fistname;
        this.secondname = secondname;
        this.phoneNumber = phoneNumber;
    }

    public String getFistname() {
        return fistname;
    }

    public void setFistname(String fistname) {
        this.fistname = fistname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (!fistname.equals(user.fistname)) return false;
        if (!secondname.equals(user.secondname)) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 11;
        int result = fistname.hashCode();
        result = prime * result + secondname.hashCode();
        result = prime * result + phoneNumber.hashCode();
        return result;
    }

}