package home.task8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

    private List<User> userList;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public AddressBook(List userList) {
        this.userList = userList;
    }

    // sort method selecter
    public List<String> selectSort(String param) throws IOException {
        switch (param) {
            case "1":
                return this.getAllUsers(); // return collection without sort
            case "2":
                return this.sortByFirstname();
            case "3":
                return this.sortBySecondname();
            case "4":
                return this.sortByFirstnameAndSecondname();
            case "5":
                return this.sortBySecondnameAndFirstname();
            case "6":
                return this.getUserGilterByFirstnameAndSecondname();
            case "7":
                return this.sortByPhoneNumber();
            default:
                return this.getAllUsers();
        }
    }

    //1 - By Firstname
    private List<String> getAllUsers() {
        return this.userList.stream()
                .map(user -> user.getFistname() + " " + user.getSecondname() + " | " + user.getPhoneNumber())
                .collect(Collectors.toList());
    }

    //2 - By Firstname
    private List<String> sortByFirstname() {
        return this.userList.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getFistname().compareTo(o2.getFistname()))
                .map(user -> user.getFistname() + " " + user.getSecondname() + " | " + user.getPhoneNumber())
                .collect(Collectors.toList());
    }

    // 3 - By Secondname
    private List<String> sortBySecondname() {
        return this.userList.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getSecondname().compareTo(o2.getSecondname()))
                .map(user -> user.getSecondname() + " " + user.getFistname() + " | " + user.getPhoneNumber())
                .collect(Collectors.toList());
    }

    // 4 - By Firstname And Secondname
    private List<String> sortByFirstnameAndSecondname() {
        return this.userList.stream()
                .distinct()
                .sorted((o1, o2) -> !o1.getFistname().equals(o2.getFistname())
                        ? o1.getFistname().compareTo(o2.getFistname())
                        : o1.getSecondname().compareTo(o2.getSecondname()))
                .map(user -> user.getFistname() + " " + user.getSecondname() + " | " + user.getPhoneNumber())
                .collect(Collectors.toList());
    }

    // 5 - By Secondname And Firstname
    private List<String> sortBySecondnameAndFirstname() {
        return this.userList.stream()
                .distinct()
                .sorted((o1, o2) -> !o1.getSecondname().equals(o2.getSecondname())
                        ? o1.getSecondname().compareTo(o2.getSecondname())
                        : o1.getFistname().compareTo(o2.getFistname()))
                .map(user -> user.getSecondname() + " " + user.getFistname() + " | " + user.getPhoneNumber())
                .collect(Collectors.toList());
    }

    //6 - Filter By Firstname And Secondname
    public List<String> getUserGilterByFirstnameAndSecondname() throws IOException {
        System.out.print("\n" + "Enter Firstname: ");
        String firstname = reader.readLine();
        System.out.print("Enter Secondname: ");
        String secondname = reader.readLine();
        return this.userList.stream()
                .filter(user -> (user.getFistname().toLowerCase().contains(firstname.toLowerCase())) &&
                        (user.getSecondname().toLowerCase().contains(secondname.toLowerCase())))
                .map(user -> user.getFistname() + " " + user.getSecondname() + " | " + user.getPhoneNumber())
                .collect(Collectors.toList());
    }

    // 7 -By Phone Number
    private List sortByPhoneNumber() {
        return this.userList.stream()
                .distinct()
                .sorted((o1, o2) -> o1.getPhoneNumber().compareTo(o2.getPhoneNumber()))
                .map(user -> user.getPhoneNumber() + " | " + user.getFistname() + " " + user.getSecondname())
                .collect(Collectors.toList());
    }

    public void getUserList(List list) {
        list.forEach(user -> System.out.println(user));
    }

}