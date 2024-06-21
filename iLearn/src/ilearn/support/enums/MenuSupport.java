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
    OPTION12(12, "12. Lambda Scopes"),
    OPTION13(13, "13. Accessing fields and static variables within lambda expressions"),
    OPTION14(14, "14. Predicate->test(Built-in Functional Interfaces)"),
    OPTION15(15, "15. Functions->apply(Built-in Functional Interfaces)"),
    OPTION16(16, "16. Suppliers(Built-in Functional Interfaces)"),
    OPTION17(17, "17. Consumers(Built-in Functional Interfaces)"),
    OPTION18(18, "18. Comparators(Built-in Functional Interfaces)"),
    OPTION19(19, "19. Optionals(nifty utilities to prevent NullPointerException)"),
    OPTION20(20, "20. Filter(Streams)"),
    OPTION21(21, "21. Sorted(Streams)"),
    OPTION22(22, "22. Map(Streams)"),
    OPTION23(23, "23. Match(Streams)"),
    OPTION24(24, "24. Count(Streams)"),
    OPTION25(25, "25. Reduce(Streams)"),
    OPTION26(26, "26. ParallelStreams(Sequential and Parallel Sort)"),
    OPTION27(27, "27. Maps(Streams)"),
    OPTION28(28, "28. DateAPI"),

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
