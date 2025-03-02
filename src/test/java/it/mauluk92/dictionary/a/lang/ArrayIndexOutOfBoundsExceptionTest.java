package it.mauluk92.dictionary.a.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArrayIndexOutOfBoundsExceptionTest {

    /**
     * {@link ArrayIndexOutOfBoundsException} is a runtime exception that is thrown when the program attempts to access
     * an element within an array by using an index that is not within the bounds
     * of the array. Because array indices use a zero-based numbering scheme, the index
     * is usually either negative or a number greater than or equal to the array's length.
     * This exception should not be caught or declared in the throws clause of a method.
     */
    @Test
    @DisplayName("Description")
    @SuppressWarnings("all")
    public void ArrayIndexOutOfBoundsExceptionDescription(){
        int[] a = new int[1];
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int value = a[2];
        });
    }
}
