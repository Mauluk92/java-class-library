package it.mauluk92.dictionary.a.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AbstractMethodErrorTest {

    /**
     * {@link AbstractMethodError} is a runtime linkage error that is thrown
     * when the Java virtual machine detects that the program is trying to
     * invoke an abstract method. Normally, when you compile a program
     * that attempts to invoke an abstract method, you get a compilation
     * error pinpointing the problem so that a linkage error at runtime
     * will not occur. However, the problem could be
     * introduced when classes used by the program become inconsistent,
     * for example by making incompatible changes and then recompiling only some
     * of its classes
     */
    @Test
    @DisplayName("Description")
    public void description(){
        AbstractMethodError error = new AbstractMethodError();
        Assertions.assertInstanceOf(AbstractMethodError.class, error);
    }
}
