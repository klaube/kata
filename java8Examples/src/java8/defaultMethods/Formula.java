package java8.defaultMethods;

/**
 * Java 8 enables us to add non-abstract method implementations to interfaces by
 * utilizing the default keyword. This feature is also known as Extension
 * Methods. 
 * 
 * Besides the abstract method calculate the interface Formula also
 * defines the default method sqrt. Concrete classes only have to implement the
 * abstract method calculate. The default method sqrt can be used out of the box. 
 * 
 * Default methods cannot be accessed from within lambda expressions. The
 * following code does NOT compile: Formula formula = (a) -> sqrt( a * 100);
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
