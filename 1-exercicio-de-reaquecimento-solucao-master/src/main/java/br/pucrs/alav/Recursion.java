package br.pucrs.alav;

public class Recursion {

	public static void main(String[] args) {
		System.out.println("6 * 4 = " + multiplyNaturalNumbers(6, 4));

		System.out.println("3 + 2 = " + sumNaturalNumbers(3, 2));

		System.out.println("1 + 1/2 + 1/3 + 1/4 = " + sumFractions(4));

		System.out.println("Recursao = " + reverseString("recursao"));

		System.out.println("F(4) = " + generateSequence(4));

		System.out.println("A(3,2) = " + ackermanSequence(3, 2));
	}

	public static int multiplyNaturalNumbers(int times, int number) {
		if (times < 0) {
			throw new IllegalArgumentException("Negative number");
		} else if (times == 1) {
			return number;
		} else if (times == 0) {
			return 1;
		}
		return multiplyNaturalNumbers(times - 1, number) + number;
	}

	public static int sumNaturalNumbers(int firstNumber, int secondNumber) {
		if (firstNumber < 0 || secondNumber < 0) {
			throw new IllegalArgumentException("Negative number");
		} else if (firstNumber == 0 && secondNumber == 0) {
			return 0;
		} else if (firstNumber == 0) {
			return sumNaturalNumbers(firstNumber, secondNumber - 1) + 1;
		} else if (secondNumber == 0) {
			return sumNaturalNumbers(firstNumber - 1, secondNumber) + 1;
		}
		return sumNaturalNumbers(firstNumber - 1, secondNumber - 1) + 1 + 1; // Estou adicionando 1 duas vezes para
																																					// compensar os dois que estão sendo
																																					// descrescidos dos números!
	}

	public static double sumFractions(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("Zero or negative number");
		} else if (max == 1) {
			return 1;
		} else {
			return sumFractions(max - 1) + 1 / ((double) max); // Chamada recursiva somando 1/n ao resultado anterior
		}

	}

	public static String reverseString(String str) {
		StringBuilder res = new StringBuilder(str.length());

		for (int i = str.length() - 1; i >= 0; i--)
			res.append(str.charAt(i));

		return res.toString();

	}

	public static int generateSequence(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Invalid number");
		} else if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else {
			return 2 * generateSequence(n - 1) + 3 * generateSequence(n - 2);
		}
	}

	public static int ackermanSequence(int m, int n) {
		if (n < 0 || m < 0) {
			throw new IllegalArgumentException("Invalide numbers");
		} else if (m == 0) {
			return n + 1;
		} else if (n == 0 && m != 0) {
			return ackermanSequence(m - 1, 1);
		} else {
			return ackermanSequence(m - 1, ackermanSequence(m, n - 1));
		}
	}
}
