package it.mauluk92.dictionary.a.lang.reflect;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

public class ArrayTest {

    /**
     * This class is used to dynamically create, access, and modify
     * Java arrays. It is most often used when dealing with arrays
     * whose component type is unknown. For example, with this class you
     * could implement a method that takes any arbitrary array and return
     * a copy of the array that is twice the original's size.
     */
    @Test
    @DisplayName("Description")
    public void arrayDescription(){}

    /**
     * The {@link Array} class is a collection of static methods. It cannot
     * be instantiated. To use a method, you need to supply a reference
     * to an array object. For example, to get the length of an unknown
     * array object ar, you can write the following code
     */
    @Test
    @DisplayName("Usage")
    public void arrayUsage(){
        int[] ar = new int[3];
        Assertions.assertEquals(3, Array.getLength(ar));
    }

    /**
     * All arrays are objects, so they can be cast into the type Object at any time.
     * To determine if an object is an array, use Class.isArray() on its class!
     */
    @Test
    @DisplayName("Arrays as Objects")
    public void arraysAsObjects(){
        int[] ar = new int[3];
        String notArray = "Not an array";

        Assertions.assertFalse(notArray.getClass().isArray());
        Assertions.assertTrue(ar.getClass().isArray());
    }

    /**
     * The type of array's element is called the component type.
     * For example, the component type of colors in the following line is
     * Color. Component types can also be arrays. We can get the component type
     * of array by calling Class.getComponentType() on its class
     */
    @Test
    @DisplayName("The component type")
    public void componentType(){
        Color[] colors = new Color[3];
        int[][] maps = new int[3][3];
        Assertions.assertEquals(Color.class, colors.getClass().componentType());
    }

    /**
     * The various array element get and set methods will automatically perform
     * widening conversions on its primitive type if necessary. For example,
     * if getLong() is invoked on a byte array, the method will automatically widen the
     * byte value to a long value. If setByte() is invoked on a long array, the same widening
     * conversion will take place.
     * Narrowing conversions are not permitted. Also, even if two primitive types are
     * the same size, a conversion may not be permitted. For example, getChar() on a short
     * array. TO achieve this conversion, you need to use the Java language's casting
     * operators before the calling methods in this class.
     * The automatic conversions that are allowed exactly match the automatic widening
     * conversions as defined in the Java Language Specifications
     */
    @Test
    @DisplayName("Widening primitive conversions")
    public void wideningPrimitiveConversions(){
        int[] a = new int[3];
        Array.set(a, 0, 1); // Valid
        Assertions.assertDoesNotThrow( ()-> Array.get(a, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            long value = 1L;
            Array.set(a, 0, value);
        });
    }

    private static class Color{}
}
