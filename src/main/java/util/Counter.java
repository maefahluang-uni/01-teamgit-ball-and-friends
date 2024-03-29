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
        if (_ctr % 2 == 0) {
            // If the current value is already even, increment by 2 to stay even
            _ctr += 2;
        } else {
            // If the current value is odd, increment by 1 to reach the next even number
            _ctr += 1;
        }
	}

	// TODO: dev1- method for decrement to closest even number
    public void decrementToEven() {
        if (_ctr % 2 == 0) {
            // If the current value is even, decrement by 2 to stay even
            _ctr -= 2;
        } else {
            // If the current value is odd, decrement by 1 to reach the previous even number
            _ctr -= 1;
        }
    }

	private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Method for increment to closest prime number
    public void incrementToPrime() {
        if (_ctr < 0) {
            // Handle negative numbers (if needed)
            _ctr = 2;
            return;
        }

        int nextPrime = _ctr + 1;

        while (!isPrime(nextPrime)) {
            nextPrime++;
        }

        _ctr = nextPrime;
    }

	public void decrementToPrime() {
        if (_ctr < 2) {
            // Handle cases where _ctr is less than 2
            _ctr = -99; // Adjust as needed
            return;
        }

        int prevPrime = _ctr - 1;

        while (!isPrime(prevPrime)) {
            prevPrime--;
            if (prevPrime < 2) {
                // Handle cases where no prime number is found (if needed)
                _ctr = -99; // Adjust as needed
                return;
            }
        }

        _ctr = prevPrime;
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
