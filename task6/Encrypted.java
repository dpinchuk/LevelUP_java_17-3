package home.task6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//[RUNTIME] -> reading annotations, so it may be read reflectively (see also [SOURCE], [CLASS])
@Retention(RetentionPolicy.RUNTIME)
@interface Encrypted {
    String crypt(); //add String field for explanation
}