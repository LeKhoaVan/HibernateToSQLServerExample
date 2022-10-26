package iuh.dhktpm15b.management;

import iuh.dhktpm15b.dao.BookDAO;
import iuh.dhktpm15b.entity.Book;

public class BookManager {
	BookDAO dao = new BookDAO();
	public void addBooks() {
		Book book = new Book(1,"Harry Poter","J. K. Rowling",250);
		if(dao.addBook(book)) {
			System.out.println("Insert successful");
		} else {
			System.err.println("Insert fail");
		}
	}
}
