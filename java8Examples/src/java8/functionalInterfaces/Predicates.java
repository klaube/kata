package java8.functionalInterfaces;

import java.util.Objects;
import java.util.function.Predicate;

/** 
 * Predicates are boolean-valued functions of one argument. 
 * The interface contains various default methods for 
 * composing predicates to complex logical terms (and, or, negate)
 */
public class Predicates {

	public static void main(String[] args) {

		Predicate<String> predicate = (s) -> s.length() > 0;

		predicate.test("foo");              // true
		predicate.negate().test("foo");     // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		Predicate<Boolean> isNull = Objects::isNull;

		Predicate<String> isEmpty = String::isEmpty;
		Predicate<String> isNotEmpty = isEmpty.negate();

	}
}
