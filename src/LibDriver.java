import java.util.Scanner;

public class LibDriver {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Library library = new Library();

		while (true) {
			System.out.println("Press A to insert a book");
			System.out.println("Press D to delete a book");
			System.out.println("Press X to display all books");
			System.out.println("Press Q to exit");
			String input = scan.nextLine();

			if (input.trim().charAt(0) == 'A') {

			} else if (input.trim().charAt(0) == 'D') {
				String bookIsbn = input.substring(1).trim();
				if (library.deleteBook(bookIsbn)) {
					System.out.println("Deleted!");
				} else {
					System.err.println("Cannot delete");
				}
			} else if (input.trim().charAt(0) == 'X') {
				library.printAllBooks();
			} else if (input.trim().charAt(0) == 'Q') {
				System.out.println("Good Bye...");
				break;
			} else {
				System.err.println("Wrong input");
			}

		}
		scan.close();
	}

}
