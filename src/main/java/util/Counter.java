package util;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//This is an example (faulty) class to be used for A4 Task1 and Task2
public class Counter {
	public int _ctr;
	public int _multiplier;

	// method increments _ctr
	public void increment() {
		_ctr++; // faulty increment
	}

	// method decrements _ctr
	public void decrement() {
		_ctr--; // faulty decrement
	}

	// method resets _ctr
	public void reset() {
		_ctr = 0; // faulty reset, _ctr should rather be 0
	}

	// method multiplies _ctr by n
	public void multiplyBy(int multiplier) {
		_multiplier = multiplier; // no fault here
		_ctr = _ctr * _multiplier; // no fault here
	}

	// TODO: dev1- method for increment to closest even number
	public void incrementToEven() {
		_ctr = -99;
	}

	// TODO: dev1- method for decrement to closest even number
	public void decrementToEven() {
		_ctr = -99;
	}

	// TODO: dev2- method for increment to closest prime number
	public void incrementToPrime() {
		_ctr = -99;
	}

	// TODO: dev2- method for decrement to closest prime number
	public void decrementToPrime() {
		_ctr = -99;
	}

	// TODO: dev3- count the frequency of word in sentence,
	// refactor source code from dev1 and dev2
	 public void countFrequency(String word, String sentence) {
        if (word == null || sentence == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }

        // Clear previous count
        _ctr = 0;

        // Escape special characters in the word
        String escapedWord = Pattern.quote(word);

        // Create a pattern to match the word
        Pattern pattern = Pattern.compile("\\b" + escapedWord + "\\b", Pattern.CASE_INSENSITIVE);

        // Create a matcher for the sentence
        Matcher matcher = pattern.matcher(sentence);

        // Count the occurrences of the word
        while (matcher.find()) {
            _ctr++;
		}
	 }
}
