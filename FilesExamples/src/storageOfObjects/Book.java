package storageOfObjects;

import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4552986478906494066L;

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", numberPages=" + numberPages + ", publishDate="
				+ publishDate + "]";
	}

	String title;
	Author author;
	int numberPages;
	LocalDate publishDate;
	
	public Book(String title, String authorName, int authorAge, int numberPages, LocalDate publishDate) {
		super();
		this.title = title;
		this.author = new Author(authorName, authorAge);
		this.numberPages = numberPages;
		this.publishDate = publishDate;
	}

	public Book() {
		super();
		title = "No title YET";
		author = new Author();
		numberPages = 0;
		publishDate=LocalDate.of(1990, 3, 12);
	}
	
	
	
	}
