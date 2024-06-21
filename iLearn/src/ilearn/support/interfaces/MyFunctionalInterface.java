package ilearn.support.interfaces;

@FunctionalInterface
public interface MyFunctionalInterface {
    // Single abstract method
    void abstractMethod(String s);

    // Default method
    default void defaultMethod() {
        System.out.println("This is a default method in the functional interface.");
    }

    // Static method
    static void staticMethod() {
        System.out.println("This is a static method in the functional interface.");
    }
}
