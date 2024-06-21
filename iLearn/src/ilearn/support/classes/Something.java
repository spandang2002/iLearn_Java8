package ilearn.support.classes;

public class Something {

    public String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    public String convertStringFromInt(int i) {
        return String.valueOf(i);
    }

    public String myConcatenate(String a, Integer b) {
        return a + b;
    }

    public String myConcatenate(String a, String b) {
        return a + b;
    }

    public String myConcatenate(String a, Float b) {
        return a + b;
    }
}
