package ilearn.support.interfaces;

@FunctionalInterface
public interface Formula {

    public abstract double calculate(int a);

    default double myFormulaSqrt(int a) {
        return Math.sqrt(a);
    }
}
