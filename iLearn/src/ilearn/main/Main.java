package ilearn.main;

import ilearn.support.classes.Person;
import ilearn.support.classes.Something;
import ilearn.support.enums.MenuSupport;
import ilearn.support.interfaces.*;

import java.util.*;

public class Main {
    //    private static final String;
    public static void main(String[] args) {

        MenuSupport ms = menu();
        switch (ms) {
            case OPTION1:
                demonstrateInterfaceWithDefaultAndStaticMethod();
                break;
            case OPTION2:
                annonymousClassWithInterfaceAndAbstractClass();
                break;
            case OPTION3:
                // Using anonymous class.
                listSortInJava7();
                break;
            case OPTION4:
                // Using lambda expression.
                listSortUsingLambdaInJava8();
                break;
            case OPTION5:
                // Using lambda expression in one line.
                listSortUsingLambdaInJava8_2nd();
                break;
            case OPTION6:
                // Using lambda expression in one line without specifying data types.
                listSortUsingLambdaInJava8_3rd();
                break;
            case OPTION7:
                // Using instance method reference.
                listSortUsingLambdaInJava8_4th();
                break;
            case OPTION8:
                // Using the functional interface with a lambda expression
                demonstrateFunctionalInterfaceWithLambdaExpression();
                break;
            case OPTION9:
                // Using static method references
                staticMethodReferences();
                break;
            case OPTION10:
                // Using static method references
                instanceMethodReferences();
                break;
            case OPTION11:
                constructorReference();
                break;
            case EXIT:
            default:
                System.out.println("You selected Exit");
                System.exit(2002);
                break;
        }
        // Using the functional interface with a lambda expression

    }

    private static void constructorReference() {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter1", "Parker1");
        System.out.println(person);

        // This code is equivalent to the above code.
        PersonFactory<Person> personFactory2 = (firstName, lastName) -> new Person(firstName, lastName);
        Person person2 = personFactory2.create("Peter2", "Parker2");
        System.out.println(person2);

        // This code is equivalent to the above code.
        PersonFactory<Person> personFactory3 = new PersonFactory<Person>() {
            @Override
            public Person create(String firstName, String lastName) {
                return new Person(firstName, lastName);
            }
        };
        Person person3 = personFactory3.create("Peter3", "Parker3");
        System.out.println(person3);
    }

    private static void instanceMethodReferences() {
        Something something = new Something();
        Converter<String, String> converter = something::startsWith;
        String converted = converter.convert("1Java");
        System.out.println(converted);    // "J"

        // This code is equivalent to the above code.
        Converter<String, String> converter2 = (x) -> String.valueOf(x.charAt(0));
        String converted2 = converter2.convert("2Java");
        System.out.println(converted2);    // "J

        // This code is equivalent to the above code.
        Converter<String, String> converter3 = new Something()::startsWith;
        String converted3 = converter3.convert("3Java");
        System.out.println(converted3);    // "J


        // This code is equivalent to the above code.
        TwoParameterOneReturn<String, Integer, String> test1 = (a, b) -> something.myConcatenate(a, b);
        String converted4 = test1.apply("Java", 8);
        System.out.println(converted4);    // "J


        // This code is equivalent to the above code.
        TwoParameterOneReturn<String, Integer, String> test2 = something::myConcatenate;
        String converted5 = test2.apply("Java", 9);
        System.out.println(converted5);    // "J

        // This code is equivalent to the above code.
        TwoParameterOneReturn<String, String, String> test3 = something::myConcatenate;
        String converted6 = test3.apply("Java", "Coding");
        System.out.println(converted6);    // "J

        // This code is equivalent to the above code.
        TwoParameterOneReturn<String, Float, String> test4 = something::myConcatenate;
        String converted7 = test4.apply("Java", 11.0f);
        System.out.println(converted7);    // "J

        Converter<Integer, String> converterTWO = something::convertStringFromInt;
        String convertedTWO = converterTWO.convert(123);
        System.out.println(convertedTWO);    // "123"
    }

    private static void staticMethodReferences() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }

    private static void demonstrateFunctionalInterfaceWithLambdaExpression() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    private static void listSortUsingLambdaInJava8_4th() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using instance method reference.
        names.sort(String::compareTo);
        System.out.println("After sorting: " + names);
    }

    private static void listSortUsingLambdaInJava8_3rd() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using lambda expression in one line without specifying data types.
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("After sorting: " + names);
    }

    private static void listSortUsingLambdaInJava8_2nd() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using lambda expression in one line.
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        System.out.println("After sorting: " + names);
    }

    private static void listSortUsingLambdaInJava8() {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using lambda expression in multiline.
        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });
        System.out.println("After sorting: " + names);
    }

    private static void listSortInJava7() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using anonymous class.
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println("After sorting: " + names);
    }

    /**
     * Demonstrates the difference between the anonymous class and the lambda expression.
     * Inside the lambda expression you can't call default methods of an interface.
     * But the data method of the interface can be called using the variable of the interface where we have assigned the lambda expression.
     */
    private static void annonymousClassWithInterfaceAndAbstractClass2() {
        Formula formula = (int a) -> {
            System.out.println(Math.sqrt(100));
            System.out.println(Math.sqrt(a));
            // This is the default method implementation of Formula interface.
            return Math.sqrt(a * 100);
        };

        System.out.println(formula.calculate(100));     // 100.0
        System.out.println(formula.myFormulaSqrt(16));           // 4.0
    }

    private static void annonymousClassWithInterfaceAndAbstractClass() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                System.out.println(Math.sqrt(100));
                System.out.println(Math.sqrt(a));
                // This is the default method implementation of Formula interface.
                return myFormulaSqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));     // 100.0
        System.out.println(formula.myFormulaSqrt(16));           // 4.0
    }

    /**
     * Demonstrates the use of the functional interface with default and static methods.
     */
    private static void demonstrateInterfaceWithDefaultAndStaticMethod() {

        // Writing a definition for the abstract method of the functional interface and assigining it to myInterface variable .
        MyFunctionalInterface myInterface = (s) -> System.out.println("Abstract method implementation: " + s);

        // Calling the abstract method using myInterface variable.
        myInterface.abstractMethod("Hello, world!");

        // Calling the default method using myInterface variable.
        myInterface.defaultMethod();

        // Calling the static method using the interface name.
        MyFunctionalInterface.staticMethod();
    }

    private static MenuSupport menu() {
        MenuSupport menuFromKey;
        printMenu();
        //Get input from user
        Scanner scanner = new Scanner(System.in);
        // Check if the input is not an integer
        if (scanner.hasNextInt() == false) {
            System.out.println("Invalid Option selected: " + scanner.next() + "...");
            return MenuSupport.EXIT;
        }
        int choice = scanner.nextInt();
        menuFromKey = MenuSupport.getMenuFromKey(choice);
        if (menuFromKey == null) {
            System.out.println("Invalid Option selected...");
            return MenuSupport.EXIT;
        }
        return menuFromKey;
    }

    private static void printMenu() {
        for (MenuSupport option : MenuSupport.values()) {
            System.out.println(option.getValue());
        }
        System.out.println("Please select an option:");
    }
}


