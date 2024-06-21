package ilearn.support.interfaces;

import ilearn.support.classes.Person;

/**
 * PersonFactory is a functional interface that creates a person object.
 * @param <P> the type of person object to create
 */
@FunctionalInterface
public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
