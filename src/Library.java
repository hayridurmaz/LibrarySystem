import java.util.*;

public class Library {
	private List<Book> Books;
	private int totalNumberofBooks;

	public Library() {
		// Constructor without arguments
		Books = new ArrayList<Book>();
		totalNumberofBooks = 0;

	}

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
		if (bookName.length() < 2) {
			System.err.println(bookName.length());
			return false;
		}
		if (authorName.length() < 3) {
			System.err.println(authorName.length());
			return false;
		}
		if (ISBN.length() != 13) {
			System.err.println(ISBN.length());
			return false;
		}
		if (numPages < 0) {
			System.err.println(numPages);
			return false;
		}
		if (pubYear < 1923 || pubYear > 2016) {
			System.err.println(pubYear);
			return false;
		}
		if (keyWords.length < 3 || keyWords.length > 5) {
			System.err.println(keyWords.length);
			return false;
		}
		Book book = new Book(bookName, authorName, ISBN, numPages, pubYear, keyWords);
		Books.add(book);
		totalNumberofBooks++;
		return true;
	}

	public Book[] returnBook(String bookName) {
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
		ArrayList<Book> temp = new ArrayList<>();
		for (Book book : Books) {
			if (book.getAuthorName().equals(authorName)) {
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
		for (Book book : Books) {
			book.displayBook();
		}
	}

	public boolean deleteBook(String isbn) {
		for (int i = 0; i < Books.size(); i++) {
			if (Books.get(i).getISBN().equals(isbn)) {
				Books.remove(i);
				return true;
			}
		}
		return false;
	}

}
