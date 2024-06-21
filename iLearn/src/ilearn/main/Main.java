package ilearn.main;

import ilearn.support.classes.AccessingFieldsAndStaticVariablesWithinLambdaExpressions;
import ilearn.support.classes.Person;
import ilearn.support.classes.Something;
import ilearn.support.enums.MenuSupport;
import ilearn.support.interfaces.*;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

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
                listSortInJava7();
                break;
            case OPTION4:
                listSortUsingLambdaInJava8();
                break;
            case OPTION5:
                listSortUsingLambdaInJava8_2nd();
                break;
            case OPTION6:
                listSortUsingLambdaInJava8_3rd();
                break;
            case OPTION7:
                listSortUsingLambdaInJava8_4th();
                break;
            case OPTION8:
                demonstrateFunctionalInterfaceWithLambdaExpression();
                break;
            case OPTION9:
                staticMethodReferences();
                break;
            case OPTION10:
                instanceMethodReferences();
                break;
            case OPTION11:
                constructorReference();
                break;
            case OPTION12:
                lambdaScopes();
                break;
            case OPTION13:
                accessingFieldsAndStaticVariablesWithinLambdaExpressions();
                break;
            case OPTION14:
                predicateTest_builtInFunctionalInterfaces();
                break;
            case OPTION15:
                functionApply_builtInFunctionalInterfaces();
                break;
            case OPTION16:
                suppliers_builtInFunctionalInterfaces();
                break;
            case OPTION17:
                consumers_builtInFunctionalInterfaces();
                break;
            case OPTION18:
                comparators_builtInFunctionalInterfaces();
                break;
            case OPTION19:
                optionals_niftyUtilitiesToPreventNullPointerException();
                break;
            case OPTION20:
                filterStreams();
                break;
            case OPTION21:
                sortedStreams();
                break;
            case OPTION22:
                mapStreams();
                break;
            case OPTION23:
                matchStreams();
                break;
            case OPTION24:
                countStreams();
                break;
            case OPTION25:
                reduceStreams();
                break;
            case OPTION26:
                parallelStreams();
                break;
            case OPTION27:
                mapsStreams();
                break;
            case OPTION28:
                dateAPI();
                break;
            case EXIT:
            default:
                System.out.println("Exiting...");
                System.exit(2002);
                break;
        }
    }

    private static void dateAPI() {
    }

    private static void mapsStreams() {
    }

    private static void parallelStreams() {
    }

    private static void reduceStreams() {
    }

    private static void countStreams() {
    }

    private static void matchStreams() {
    }

    private static void mapStreams() {
    }

    private static void sortedStreams() {
    }

    private static void filterStreams() {
    }

    private static void optionals_niftyUtilitiesToPreventNullPointerException() {
    }

    private static void comparators_builtInFunctionalInterfaces() {
    }

    private static void consumers_builtInFunctionalInterfaces() {
    }

    private static void suppliers_builtInFunctionalInterfaces() {
    }

    /**
     * Functions accept one argument and produce a result.
     * Default methods can be used to chain multiple functions together (compose, andThen).
     */
    private static void functionApply_builtInFunctionalInterfaces() {

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        String apply = backToString.apply("123");// "123"
        System.out.println(apply);

    }

    /**
     * Predicates are boolean-valued functions of one argument.
     * The interface contains various default methods for composing predicates to complex logical terms (and, or, negate)
     */
    private static void predicateTest_builtInFunctionalInterfaces() {

        Predicate<String> predicate1 = (s) -> s.length() > 0;

        System.out.println(predicate1.test("foo"));              // true
        System.out.println(predicate1.negate().test("foo"));     // false


        Predicate<String> predicate2 = (s) -> s.length() < 3;
        System.out.println(predicate2.test("fooo"));              // false
        System.out.println(predicate2.negate().test("fooo"));     // true

        // TODO: need to learn.
//        Predicate<Boolean> nonNull = Objects::nonNull;
//        System.out.println(nonNull);
//
//        Predicate<Boolean> isNull = Objects::isNull;
//        System.out.println(isNull);
//
//        Predicate<String> isEmpty = String::isEmpty;
//        System.out.println(isEmpty);
//
//        Predicate<String> isNotEmpty = isEmpty.negate();
//        System.out.println(isNotEmpty);
    }

    /**
     * Demonstrates the use of the lambda scopes
     * Reading add writing instance and static variables within lambda expressions.
     * The lambda expression can access the instance and static variables.
     * The lambda expression can read and write the instance and static variables.
     */
    private static void accessingFieldsAndStaticVariablesWithinLambdaExpressions() {
        // Accessing fields and static variables within lambda expressions
        AccessingFieldsAndStaticVariablesWithinLambdaExpressions accessingFieldsAndStaticVariablesWithinLambdaExpressions = new AccessingFieldsAndStaticVariablesWithinLambdaExpressions();
        accessingFieldsAndStaticVariablesWithinLambdaExpressions.accessingFieldsAndStaticVariablesWithinLambdaExpressions_();
    }

    private static void lambdaScopes() {
        withFinalVariable();
        withoutFinalVariable();
        // Variable used in lambda expression should be final or effectively final so getting compilation error at below code.
        mustBeImplicitlyFinalForCodeToCompile();


    }

    /**
     * Demonstrates the use of the lambda scopes
     * Variable used in lambda expression should be final or effectively final
     */
    private static void mustBeImplicitlyFinalForCodeToCompile() {
        int num = 1;
        // Variable used in lambda expression should be final or effectively final so getting compilation error at below code.
//        Converter<Integer, String> stringConverter =
//                (from) -> String.valueOf(from + num);
        num = 3;
    }

    /**
     * Demonstrates the use of the lambda scopes
     * num must be implicitly final for the code to compile.
     * The lambda expression can access the implicitly final variable.
     */
    private static void withoutFinalVariable() {
        // num must be implicitly final for the code to compile.
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String convert = stringConverter.convert(2);
        System.out.println(convert);
    }

    /**
     * Demonstrates the use of the lambda scopes
     * The lambda expression can access the final variable.
     */
    private static void withFinalVariable() {
        final int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        String convert = stringConverter.convert(2);// 3
        System.out.println(convert);
    }

    /**
     * Demonstrates the use of the method reference for constructor.
     * The method reference is used to refer to the constructor of the class.
     */
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

    /**
     * Demonstrates the use of the method reference for instance methods.
     * The method reference is used to refer to the instance method of the class.
     */
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

    /**
     * Demonstrates the use of the method reference for static methods.
     * The method reference is used to refer to the static method of the class.
     */
    private static void staticMethodReferences() {
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);   // 123
    }

    /**
     * Demonstrates the use of the functional interface with a lambda expression.
     * The lambda expression is used to provide the implementation of the abstract method of the interface.
     * The lambda expression is used to provide the implementation of the abstract method of the functional interface.
     */
    private static void demonstrateFunctionalInterfaceWithLambdaExpression() {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

    /**
     * Code for sorting the list in Java 8 using instance method reference.
     * This code is equivalent to the code in listSortUsingLambdaInJava8_2nd() method.
     * The only difference is that the instance method reference is used here.
     * The instance method of String class[public int compareTo(String anotherString)]
     * Reference is used to refer the instance method of an object.
     */
    private static void listSortUsingLambdaInJava8_4th() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using instance method reference.
        names.sort(String::compareTo);
        System.out.println("After sorting: " + names);
    }

    /**
     * Code for sorting the list in Java 8 using the lambda expression(without specifying the data types).
     * This code is equivalent to the code in listSortUsingLambdaInJava8() method.
     * The only difference is that the data types are not specified here.
     * The lambda expression does not need to specify the data type of the parameters.
     * The compiler can infer the same from the value of the parameters.
     */
    private static void listSortUsingLambdaInJava8_3rd() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using lambda expression in one line without specifying data types.
        names.sort((a, b) -> a.compareTo(b));
        System.out.println("After sorting: " + names);
    }

    /**
     * Code for sorting the list in Java 8 using the lambda expression(one line lambda expression).
     * This code is equivalent to the code in listSortUsingLambdaInJava8() method.
     * The only difference is that the lambda expression is used in one line.
     * The lambda expression is used to provide the implementation in one line also of the abstract method of the interface.
     */
    private static void listSortUsingLambdaInJava8_2nd() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using lambda expression in one line.
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        System.out.println("After sorting: " + names);
    }

    /**
     * Code for sorting the list in Java 8 using the lambda expression(multi line lambda expression).
     * This code is equivalent to the code in listSortInJava7() method.
     * The only difference is that the lambda expression is used here.
     * The lambda expression is used to provide the implementation of the abstract method of the interface.
     */
    private static void listSortUsingLambdaInJava8() {

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        System.out.println("Before sorting: " + names);
        // Using lambda expression in multiline.
        Collections.sort(names, (String a, String b) -> {
            return a.compareTo(b);
        });
        System.out.println("After sorting: " + names);
    }

    /**
     * Code for sorting the list in Java 7 using the anonymous class.
     * This code is equivalent to the code in listSortUsingLambdaInJava8() method.
     * The only difference is that the anonymous class is used here.
     * The anonymous class is used to provide the implementation of the abstract method of the interface.
     */
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
     * Demonstrates the use of the anonymous class with the interface and the abstract class.
     * The anonymous class is used to provide the implementation of the abstract method of the interface.
     * The anonymous class is used to provide the implementation of the abstract method of the abstract class.
     */
    private static void annonymousClassWithInterfaceAndAbstractClass() {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                System.out.println(Math.sqrt(100));
                System.out.println(Math.sqrt(a));
                // This is the call of default method of the interface.
                return myFormulaSqrt(a * 100);
            }
        };

        System.out.println(formula.calculate(100));     // 100.0
        System.out.println(formula.myFormulaSqrt(16));           // 4.0

        //TO understand the basic difference between the lambda expression and the anonymous class.

        annonymousClassWithInterfaceAndAbstractClass2();
    }

    /**
     * Default methods cannot be accessed from within lambda expressions.
     * Demonstrates the difference between the anonymous class and the lambda expression.
     * Inside the lambda expression you can't call default methods of an interface.
     * But the default method of the interface can be called using the variable of the interface where the lambda expression is assigned.
     */
    private static void annonymousClassWithInterfaceAndAbstractClass2() {
        Formula formula = (int a) -> {
            System.out.println(Math.sqrt(100));
            System.out.println(Math.sqrt(a));
            // Here the default method of interface can't be called.
            // Default methods cannot be accessed from within lambda expressions.
            return Math.sqrt(a * 100);
        };

        System.out.println(formula.calculate(100));     // 100.0
        System.out.println(formula.myFormulaSqrt(16));           // 4.0
    }

    /**
     * Demonstrates the use of the functional interface with default and static methods.
     * The lambda expression is used to provide the implementation of the abstract method.
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

    /**
     * This method is used to display the menu and get the input from the user.
     * The input is used to select the option from the menu.
     * The option selected by the user is returned.
     * If the user selects an invalid option then EXIT is returned.
     * If the user selects the Exit option then the program is terminated.
     * If the user selects a valid option then the selected option is returned.
     * The selected option is used to execute the code for the selected option.
     * The code for the selected option is executed.
     *
     * @return MenuSupport
     */
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

    /**
     * This method is used to display the menu.
     * The menu is displayed using the values of the MenuSupport enum.
     * The user is asked to select an option from the menu.
     * The user is asked to enter the option from the menu.
     */
    private static void printMenu() {
        for (MenuSupport option : MenuSupport.values()) {
            System.out.println(option.getValue());
        }
        System.out.println("Please select an option:");
    }
}


