import java.util.Scanner;

public class LibDriver {
	// Class with main method.
	public static void main(String[] args) {
		// Driver method
		Scanner scan = new Scanner(System.in);
		Library library = new Library();

		while (true) {
			System.out.println("Press A to insert a book");
			System.out.println("Press D to delete a book");
			System.out.println("Press X to display all books");
			System.out.println("Press Q to exit");
			String input = scan.nextLine();

			if (input.trim().charAt(0) == 'A') {
				String[] splited = input.substring(1).trim().split(",");
				String[] keys = new String[splited.length - 5];
				int j = 0;
				for (int i = 5; i < splited.length; i++) {
					keys[j] = splited[i];
				}
				try {
					if (library.addBook(splited[0], splited[1], splited[2], Integer.parseInt(splited[3].trim()),
							Integer.parseInt(splited[4].trim()), keys)) {
						System.out.println("Added.");
					} else {
						System.err.println("Could not added.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Some exception happened, cannot add book.");
				}
			} else if (input.trim().charAt(0) == 'D') {
				String bookIsbn = input.substring(1).trim();
				if (library.deleteBook(bookIsbn)) {
					System.out.println("Deleted!");
				} else {
					System.err.println("Cannot delete");
				}
			} else if (input.trim().charAt(0) == 'X') {
				System.out.println(library.getTotalNumberofBooks());
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
