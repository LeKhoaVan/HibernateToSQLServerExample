package iuh.dhktpm15b.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="book")
public class Book {
	@Id
	@Column(name ="book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name ="author")
	private String author;
	
	@Column(name = "price")
	private float price;
	
	
	public Book() {
		
	}
	
	public Book(int bookId) {
		this.bookId = bookId;
	}

	public Book(String title, String author, float price) {
		
		this.title = title;
		this.author = author;
		this.price = price;
	}

	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	
	
	
	
	
	
}
