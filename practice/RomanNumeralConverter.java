

// function that convers from Arabic to numerals
// I = 1, V = 5
// X = 10, L = 50
// C = 100, D = 500
// M = 1,000

public class RomanNumeralConverter {

	public static void main(String[] args) {
		System.out.println(convertToRoman(14));
		System.out.println(convertToRoman(835));
		System.out.println(convertToRoman(57));
		System.out.println(convertToRoman(42));
		System.out.println(convertToRoman(999));
		System.out.println(convertToRoman(29482));
	}

	public static String convertToRoman(int number) {
		String result = "";
		int place = -1;
		while (number > 0) {

			place++;

			// process one digit
			String digitString = "";
			switch (place) {
			case 0:
				digitString += convertLastPlace(number, 'I', 'V', 'X');
				break;
			case 1:
				digitString += convertLastPlace(number, 'X', 'L', 'C');
				break;
			case 2:
				digitString += convertLastPlace(number, 'C', 'D', 'M');
				break;
			default:
				for (int i = 0; i < number; i++)
					digitString += 'M';
				number = 0;
				break;
			}

			number /= 10;
			result = digitString + result;

		}
		return result;
	}

	// works
	private static String convertLastPlace(int digit, char one, char five, char nextOne) {
		digit %= 10;
		String result = "";
		if (digit < 4) {
			for (int i = 0; i < digit; i++) {
				result += one;
			}
		} else if (digit == 4) {
			result += one;
			result += five;
		} else if (digit < 9) {
			result += five;
			result += convertLastPlace(digit - 5, one, five, nextOne);
		} else {
			result += one;
			result += nextOne;
		}
		return result;
	}

}
