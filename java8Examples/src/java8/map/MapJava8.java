package java8.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Maps don't support streams. Instead maps now support various new 
 * and useful methods for doing common tasks.
 */
public class MapJava8 {

	public static void main(String[] args) {

		putIfAbsent();
		
		computeIfPresent();
		
		remove();
		
		Map<Integer, String> map = new HashMap<>();
		map.getOrDefault(42, "not found");  // not found
		
		merge();
	}






	private static void putIfAbsent() {
		
		System.out.println("\n putIfAbsent");
		
		Map<Integer, String> map = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			// putIfAbsent prevents us from writing additional if null checks
		    map.putIfAbsent(i, "val" + i);
		}

		// forEach accepts a consumer to perform operations for each value of the map.
		map.forEach((id, val) -> System.out.println(val));
	}

	/**
	 * This example shows how to compute code on the map by utilizing functions:
	 */
	private static void computeIfPresent() {
		
		System.out.println("\n computeIfPresent");

		Map<Integer, String> map = new HashMap<>();
		
		map.computeIfAbsent(3, num -> "bam");
		System.out.println(map.get(3));             // bam
		
		System.out.println(map.computeIfPresent(3, (num, val) -> val + num));// bam3
		System.out.println(map.get(3));             // bam3

		map.computeIfPresent(9, (num, val) -> null);
		System.out.println(map.containsKey(9));     // false

		map.computeIfAbsent(23, num -> "val" + num);
		System.out.println(map.containsKey(23));    // true
		
	}
	
	/**
	 * remove entries for a a given key, only if it's currently mapped to a given value
	 */
	private static void remove() {
		
		System.out.println("\n remove");
		
		Map<Integer, String> map = new HashMap<>();

		System.out.println(map.computeIfAbsent(3, (num) -> "val" + num + num)); //val33
		map.remove(3, "val3");
		System.out.println(map.get(3));             // val33

		map.remove(3, "val33");
		System.out.println(map.get(3));             // null
	}
	
	
	/**
	 * Merge either put the key/value into the map if no entry for the key exists, 
	 * or the merging function will be called to change the existing value.
	 */
	private static void merge() {
		
		System.out.println("\n merge");
		
		Map<Integer, String> map = new HashMap<>();

		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9

		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9concat
	}
}
