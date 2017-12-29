import java.util.*;

public class Library {
	/*
	 * This class represents a Library object
	 */
	private List<Book> Books;
	private int totalNumberofBooks;

	public Library() {
		// Constructor without arguments
		Books = new ArrayList<Book>();
		totalNumberofBooks = 0;

	}

	// GETTERS AND SETTERS

	public List<Book> getBooks() {
		return Books;
	}

	public void setBooks(List<Book> books) {
		Books = books;
	}

	public int getTotalNumberofBooks() {
		return totalNumberofBooks;
	}

	public void setTotalNumberofBooks(int totalNumberofBooks) {
		this.totalNumberofBooks = totalNumberofBooks;
	}

	public boolean addBook(String bookName, String authorName, String ISBN, int numPages, int pubYear,
			String[] keyWords) {
		// This is method to create a book with valid info and add it to library
		if (bookName.length() < 2) {
			System.err.println("Book name is not valid.");
			return false;
		}
		if (authorName.length() < 3) {
			System.err.println("Author name is not valid");
			return false;
		}
		if (ISBN.length() < 13 || ISBN.length() > 14) {
			System.err.println("ISBN is not valid.");
			return false;
		}
		if (numPages < 0) {
			System.err.println("Page number is not valid.");
			return false;
		}
		if (pubYear < 1923 || pubYear > 2016) {
			System.err.println("Publication year is not valid.");
			return false;
		}
		if (keyWords.length < 3 || keyWords.length > 5) {
			System.err.println("Key words are not valid.");
			return false;
		}
		Book book = new Book(bookName, authorName, ISBN, numPages, pubYear, keyWords);
		Books.add(book);
		totalNumberofBooks++;
		return true;
	}

	public Book[] returnBook(String bookName) {
		// This method returns book(s) by Name
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : Books) {
			if (book.getBookName().equals(bookName)) {
				temp.add(book);
			}
		}
		Book[] bookToReturn = new Book[temp.size()];
		for (int i = 0; i < bookToReturn.length; i++) {
			bookToReturn[i] = temp.get(i);
		}
		return bookToReturn;

	}

	public Book[] returnBookByAuthor(String authorName) {
		// This method returns book(s) by Author Name
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : Books) {
			if (book.getAuthorName().contains(authorName)) {
				temp.add(book);
			}
		}
		Book[] bookToReturn = new Book[temp.size()];
		for (int i = 0; i < bookToReturn.length; i++) {
			bookToReturn[i] = temp.get(i);
		}
		return bookToReturn;

	}

	public Book[] returnBookByKeyword(String keyword) {
		// This method returns book(s) by key words.
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : Books) {
			if (book.searchKeyWord(keyword)) {
				temp.add(book);
			}
		}
		Book[] bookToReturn = new Book[temp.size()];
		for (int i = 0; i < bookToReturn.length; i++) {
			bookToReturn[i] = temp.get(i);
		}
		return bookToReturn;

	}

	public void printAllBooks() {
		// Display each books in library
		for (Book book : Books) {
			book.displayBook();
		}
	}

	public boolean deleteBook(String isbn) {
		// Delete a book from library

		for (int i = 0; i < Books.size(); i++) {
			if (Books.get(i).getISBN().trim().equals(isbn)) {
				Books.remove(i);
				totalNumberofBooks--;
				return true;
			}
		}
		return false;
	}

	public static void printBookArray(Book[] bookArray) {
		for (int i = 0; i < bookArray.length; i++) {
			bookArray[i].displayBook();
		}
	}

}
