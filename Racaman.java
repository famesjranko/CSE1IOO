import java.util.Scanner;
import java.util.ArrayList;

public class Racaman {
	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		// user set sequence limit and printout width
		int limit = userInput("Enter the limit for Racaman sequence: ");
		int lineWidth = userInput("Set the line print width: ");

		// run Racaman sequence
		racaman(limit, lineWidth);
	}

	public static int userInput(String msg) {
		System.out.print(msg);

		Integer output = null;

		while (true) {
			String input = kb.nextLine();
			if (input.length() < 1) {
				System.out.println("Cannot be empty.");
				System.out.print(msg);
			} else {
				try {
					output = Integer.parseInt(input);
					break;
				} catch (NumberFormatException e) {
					System.out.println(e.toString());
					System.out.print(msg);
				}
			}
		}

		return output;
	}

	public static void racaman(int limit, int lineWidth) {
		// create list to store Racaman moves
		ArrayList<Integer> racamanList = new ArrayList<Integer>();

		// set first move of the sequence, is always 0
		racamanList.add(0);

		System.out.println("\nThe Racaman Sequence:\n");
		int count = 0;
		for (int i = 1; i < limit; i++) {
			count++;

			// set current to i number of moves back
			int current = racamanList.get(i - 1) - i;

			// if i number of moves back exists in arrayList
			// or if i is less than zero,
			// set current to i number of moves forward
			if ((racamanList.contains(current) || current < 0)) {
				current = racamanList.get(i - 1) + i;
			}

			// add current as next move to list
			racamanList.add(current);

			// print starting number, once only
			if (i == 1) {
				System.out.printf("%s%-4d%s", "  ", racamanList.get(0), " | ");
				count++;
			}

			// print current number
			System.out.printf("%s%-4d", "  ", racamanList.get(i));

			// print new line when width limit is met
			if (count % lineWidth == 0) {
				System.out.println();
			} else
				System.out.print(" | ");
		}

		// sequence finished
		if (count % lineWidth == 0) {
			System.out.println("\nSequence finished.");
		} else
			System.out.println("\n\nSequence finished.");
	}
}
