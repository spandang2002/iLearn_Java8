package ilearn.support.enums;

/**
 * MenuSupport enum class to print the menu options.
 */
public enum MenuSupport {
    OPTION1(1, "1. Interface with default and static methods"),
    OPTION2(2, "2. Annonymous class with interface and abstract class"),
    OPTION3(3, "3. List Sort in Java 7"),
    OPTION4(4, "4. List Sort using lambda in Java 8"),
    OPTION5(5, "5. List Sort using lambda in Java 8 - 2nd option"),
    OPTION6(6, "6. List Sort using lambda in Java 8 - 3rd option"),
    OPTION7(7, "7. List Sort using lambda in Java 8 - 4th option"),
    OPTION8(8, "8. Demonstrate Functional Interface with lambda expression"),
    OPTION9(9, "9. Static method references"),
    OPTION10(10, "10. Instance method references"),
    OPTION11(11, "11. Constructor reference"),
    EXIT(100, "100. Exit");

    private final int key;
    private final String value;

    MenuSupport(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static MenuSupport getMenuFromKey(int key) {
        for (MenuSupport option : MenuSupport.values()) {
            if (option.getKey() == key) {
                return option;
            }
        }
        return null;  // or throw an exception
    }
}
