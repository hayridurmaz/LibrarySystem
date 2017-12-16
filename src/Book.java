
public class Book {
	/*
	 * This class represents a Book object
	 */

	// Attributes
	private String bookName;
	private String authorName;
	private String ISBN;
	private int numberOfPages;
	private int publicationYear;
	private String[] keyWords;

	public Book() {
		// Do nothing
	}

	public Book(String bookName, String authorName, String ISBN, int numPages, int pubYear, String[] keyWords) {
		// Constructor to initialize fields.
		this.bookName = bookName;
		this.authorName = authorName;
		this.ISBN = ISBN;
		this.numberOfPages = numPages;
		this.publicationYear = pubYear;
		this.keyWords = keyWords;
	}

	// GETTERS and SETTERS
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String[] getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String[] keyWords) {
		this.keyWords = keyWords;
	}

	public boolean searchKeyWord(String aWord) {
		// Method for looking if a keyword exists for a book
		for (int i = 0; i < keyWords.length; i++) {
			if (aWord.equalsIgnoreCase(keyWords[i]))
				return true;
		}
		return false;
	}

	public void displayBook() {
		// Method for outputting a book's info.
		String toWrite = bookName + ", " + authorName + ", " + ISBN + ", " + numberOfPages + ", " + publicationYear
				+ ",";
		for (String string : keyWords) {
			if (string == null) {
				continue;
			} else {
				toWrite += string + ", ";
			}
		}
		toWrite = toWrite.substring(0, toWrite.length() - 2);
		System.out.println(toWrite);
	}

}
