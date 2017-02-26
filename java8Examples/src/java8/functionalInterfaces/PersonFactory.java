package java8.functionalInterfaces;

/** Next we specify a person factory interface to be used for creating new persons. */
interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}

