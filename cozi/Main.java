// Class name must be "Main"
// Libraries included:
// json simple, guava, apache commons lang3, junit, jmock

// function/method that receives collection of strings
// returns new collection of strings where members of the
// new collection are all anagrams of each other from the
// input collection

// input: ["Cat", "Tac", "Act", "Hello", "World", "Car", "Rac"]
// output: ["Cat", "Tac", "Act", "Car", "Rac"]

// assume case insensitive (not at first, or control)
// none -> empty collection

import java.util.*;

public class Main {

	public static void main(String[] args) {
		String[] input = { "Cat", "Tac", "Act", "Hello", "World", "Car", "Rac" };
		Set<String> actualInput = new HashSet<>();
		for (String s : input) {
			actualInput.add(s);
		}
		System.out.println(findAnagrams(actualInput));
	}

	public static Set<String> findAnagrams(Set<String> strings) {

		// id storage
		Map<String, Set<Character>> ids = new HashMap<>();

		// populate map by decomposing strings
		Map<Set<Character>, Integer> map = new HashMap<>();
		for (String str : strings) {
			Set<Character> id = charactersWithin(str);
			ids.put(str, id);
			if (!map.containsKey(id)) {
				map.put(id, 0);
			}
			map.put(id, map.get(id) + 1);
		}

		// prune map (remove single entries)
		Set<Set<Character>> deadKeys = new HashSet<>();
		for (Set<Character> key : map.keySet()) {
			if (map.get(key) == 1) {
				deadKeys.add(key);
			}
		}
		for (Set<Character> key : deadKeys) {
			map.remove(key);
		}

		// go through original input again, compile output
		Set<String> output = new HashSet<>();
		for (String str : strings) {
			Set<Character> id = ids.get(str);
			if (map.containsKey(id)) {
				output.add(str);
			}
		}

		return output;
	}

	// good!
	private static Set<Character> charactersWithin(String str) {
		Set<Character> result = new HashSet<>();
		str = str.toLowerCase();
		for (char ch : str.toCharArray()) {
			result.add(ch);
		}
		return result;
	}

}
