package ilearn.support.classes;

import ilearn.support.interfaces.Converter;

public class AccessingFieldsAndStaticVariablesWithinLambdaExpressions {

    static int outerStaticNum;
    int outerNum;

    public void accessingFieldsAndStaticVariablesWithinLambdaExpressions_() {

        System.out.println("Initial value of static variable(outerStaticNum): " + outerStaticNum);
        System.out.println("Initial value of instance variable (outerNum):: " + outerNum);
        Converter<Integer, String> stringConverter1 = (from) -> {
            System.out.println("In Lambda-Expression Initial value of instance variable (outerNum): " + outerNum);
            outerNum = 23;
            System.out.println(outerNum);
            return String.valueOf(from);
        };


        Converter<Integer, String> stringConverter2 = (from) -> {
            System.out.println("In lambda-expression accessing the value of static variable(outerStaticNum): " + outerStaticNum);
            outerStaticNum = 72;
            System.out.println(outerStaticNum);
            return String.valueOf(from);
        };

        System.out.println("Before lambda-expression execution the value of instance variable (outerNum):: " + outerNum);
        System.out.println("Before lambda-expression execution the value of static variable(outerStaticNum): " + outerStaticNum);
        stringConverter1.convert(10);
        stringConverter2.convert(10);

        System.out.println("After lambda-expression overwrite the value of instance variable (outerNum):: " + outerNum);
        System.out.println("After lambda-expression overwrite the value of static variable(outerStaticNum): " + outerStaticNum);
    }
}
