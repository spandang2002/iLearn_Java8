package ilearn.support.interfaces;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
