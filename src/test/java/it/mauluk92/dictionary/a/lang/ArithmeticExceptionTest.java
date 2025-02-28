package it.mauluk92.dictionary.a.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArithmeticExceptionTest {

    /**
     * {@link ArithmeticException} is a runtime exception that is thrown
     * when the program attempts to perform an illegal arithmetic operation. It should
     * not be caught or declared in the throws clause of a method
     */
    @Test
    @DisplayName("Description")
    public void description(){
        ArithmeticException exception = new ArithmeticException();
        Assertions.assertInstanceOf(ArithmeticException.class, exception);
    }

    /**
     * The following code attempt division by 0, triggering
     * an {@link ArithmeticException}
     */
    @Test
    @DisplayName("Example")
    @SuppressWarnings("all")
    public void example(){
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int a = 100;
            a /= 0;
        });
    }


}
