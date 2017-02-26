package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A java.util.Stream represents a sequence of elements on which one or more operations can be performed. 
 * Stream operations are either intermediate or terminal. While terminal operations return a result 
 * of a certain type, intermediate operations return the stream itself so you can chain multiple method calls in a row.
 * 
 * Streams are created on a source, e.g. a java.util.Collection like lists or sets (maps are not supported). 
 * Stream operations can either be executed sequential or parallel.
 */
public class Streams {

	public static void main(String[] args) {

		List<String> stringCollection = createStringCollection();

		/*
		 * Collections in Java 8 are extended so you can simply create streams
		 * either by calling Collection.stream() or Collection.parallelStream().
		 * The following sections explain the most common stream operations.
		 */

		filter(stringCollection);

		sort(stringCollection);

		map(stringCollection);

		match(stringCollection);
		
		count(stringCollection);
		
		reduce(stringCollection);
		
		backToCollection();
	}

	private static List<String> createStringCollection() {
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");
		return stringCollection;
	}

	/**
	 * Filter accepts a predicate to filter all elements of the stream. 
	 * This operation is intermediate which enables us to call another stream operation (forEach) on the result. 
	 * ForEach accepts a consumer to be executed for each element in the filtered stream. 
	 * ForEach is a terminal operation. It's void, so we cannot call another stream operation.
	 */
	private static void filter(Collection<String> stringCollection) {

		stringCollection
		.stream()
		.filter((s) -> s.startsWith("a"))
		.forEach(System.out::println);

		// "aaa2", "aaa1"

	}

	/**
	 * Sorted is an intermediate operation which returns a sorted view of the stream. 
	 * The elements are sorted in natural order unless you pass a custom Comparator.
	 *
	 * Keep in mind that sorted does only create a sorted view of the stream 
	 * without manipulating the ordering of the backed collection. 
	 * The ordering of stringCollection is untouched
	 */
	private static void sort(List<String> stringCollection) {

		stringCollection
		.stream()
		.sorted()
		.filter((s) -> s.startsWith("a"))
		.forEach(System.out::println);

		// "aaa1", "aaa2"


		System.out.println(stringCollection);
		// ddd2, aaa2, bbb1, aaa1, bbb3, ccc, bbb2, ddd1
	}

	/**
	 * The intermediate operation map converts each element into another object via the given function. 
	 * The following example converts each string into an upper-cased string. 
	 * But you can also use map to transform each object into another type. 
	 * The generic type of the resulting stream depends on the generic type of the function you pass to map.
	 */
	private static void map(List<String> stringCollection) {

		stringCollection
		.stream()
		.map(String::toUpperCase)
		.sorted((a, b) -> b.compareTo(a))
		.forEach(System.out::println);

		// "DDD2", "DDD1", "CCC", "BBB3", "BBB2", "AAA2", "AAA1"
	}

	/**
	 * Various matching operations can be used to check whether a certain predicate matches the stream. 
	 * All of those operations are terminal and return a boolean result.
	 */
	private static void match(List<String> stringCollection) {

		boolean anyStartsWithA = stringCollection.stream()
				.anyMatch((s) -> s.startsWith("a"));

		System.out.println(anyStartsWithA);      // true

		boolean allStartsWithA = stringCollection.stream()
				.allMatch((s) -> s.startsWith("a"));

		System.out.println(allStartsWithA);      // false

		boolean noneStartsWithZ = stringCollection.stream()
				.noneMatch((s) -> s.startsWith("z"));

		System.out.println(noneStartsWithZ);      // true
	}
	
	/**
	 * Count is a terminal operation returning the number of elements in the stream as a long.
	 */
	private static void count(List<String> stringCollection) {

		long startsWithB =
		    stringCollection
		        .stream()
		        .filter((s) -> s.startsWith("b"))
		        .count();

		System.out.println(startsWithB);    // 3
	}
	
	/**
	 * This terminal operation performs a reduction on the elements of the stream with the given function. 
	 * The result is an Optional holding the reduced value.
	 */
	private static void reduce(List<String> stringCollection) {

		Optional<String> reduced =
		    stringCollection
		        .stream()
		        .sorted()
		        .reduce((s1, s2) -> s1 + "#" + s2);

		reduced.ifPresent(System.out::println);
		
		// "aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2"
	}
	
	private static void backToCollection() {
		
		List<Long> sourceLongList = Arrays.asList(1L, 10L, 50L, 80L, 100L, 120L, 133L, 333L);
		Stream<Long> filteredStream = sourceLongList.stream().filter(l -> l > 100);
		
		List<Long> targetLongList = new ArrayList<>();
		filteredStream.forEach(targetLongList::add);		

		List<Long> targetLongList2 = filteredStream.collect(Collectors.toList());
		
		List<Long> targetLongList3 = filteredStream.collect(Collectors.toCollection(ArrayList::new));
	}
}
