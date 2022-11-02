package iuh.dhktpm15b.management;

import java.util.List;

import iuh.dhktpm15b.dao.BookDAO;
import iuh.dhktpm15b.entity.Book;

public class BookManager {
	BookDAO dao = new BookDAO();
	public void addBooks() {
		Book book = new Book("Harry Poter và hội tam hoàng","J. K. Rowling",500);
		if(dao.addBook(book)) {
			System.out.println("Insert successful");
		} else {
			System.err.println("Insert fail");
		}
	}
	
	public void getAll() {
		List<Book> books = dao.getBook();
		
		for(Book book : books) {
			System.out.println(book.toString());
		}
	}
	
	public void findById(int bookID) {
		dao.read(bookID);
	}
	
	public void update(int bookID) {
		if(dao.update(bookID)) {
			System.out.println("update successful");
		} else {
			System.err.println("update fail");
		}
		
	}
	
	public void deleteById(int bookID) {
		if(dao.delete(bookID)) {
			System.out.format("delete bookID: %d successful", bookID);
		} else {
			System.err.println("delete fail");
		}
	
	}
}
