package java8.lambda;

/**
 * Each lambda corresponds to a given type, specified by an interface. 
 * A so called functional interface must contain exactly one abstract method declaration. 
 * Each lambda expression of that type will be matched to this abstract method. 
 * Since default methods are not abstract you're free to add default methods to your functional interface.
 * We can use arbitrary interfaces as lambda expressions as long as the interface only contains one abstract method. 
 * To ensure that your interface meet the requirements, you should add the @FunctionalInterface annotation. 
 * The compiler is aware of this annotation and throws a compiler error as soon as you try to add 
 * a second abstract method declaration to the interface.
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}