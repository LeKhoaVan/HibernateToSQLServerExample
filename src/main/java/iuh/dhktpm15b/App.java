package iuh.dhktpm15b;

import iuh.dhktpm15b.management.BookManager;

public class App {
	public static void main(String[] args) {
		BookManager bookManager = new BookManager();
		bookManager.addBooks();
	}
}
