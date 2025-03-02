package it.mauluk92.dictionary.a.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayStoreExceptionTest {

    /**
     * {@link ArrayStoreException} is a runtime exception that is thrown when the program
     * attempts to store an object of the wrong type into an array. It should not
     * be caught or declared in the throws clause of a method.
     */
    @Test
    @DisplayName("Description")
    @SuppressWarnings("all")
    public void arrayStoreExceptionDescription(){
        Object[] a = new Integer[2];
        Assertions.assertThrows(ArrayStoreException.class, () -> {
            a[1] = "Wrong type";
        });
    }
}
