package home.task6;

import javax.xml.bind.DatatypeConverter;
import java.lang.reflect.Field;

public class Cryptographer {

    public static void enCrypt(User user) throws IllegalAccessException {
        // variant 1
        /// -> [Reflection] Class Field(), because using fields of the class User()
        Field[] field = user.getClass().getDeclaredFields();
        for (Field f : field) { // seek fields with Annoations
            if (f.isAnnotationPresent(Encrypted.class)) {
                f.setAccessible(true); //access
                f.set(user, enCoder(f.get(user).toString())); // set coding password in the field
            }
        }
    }

    // variant 2
    public static void enCryptOneField(User user) throws IllegalAccessException, NoSuchFieldException {
        // -> [Reflection] Class Field(), because using field of the class User()
        Field field = user.getClass().getDeclaredField("password");
        if (field.isAnnotationPresent(Encrypted.class)) {
            field.setAccessible(true); // access
            field.set(user, enCoder(field.get(user).toString())); // set coding password in the field
        }
    }

    // encoder
    public static String enCoder(String encodePassword) {
        return DatatypeConverter.printBase64Binary(encodePassword.getBytes());
    }

    // decoder
    public static String deCoder(String deCodePassword) {
        return new String(DatatypeConverter.parseBase64Binary(deCodePassword));
    }

}