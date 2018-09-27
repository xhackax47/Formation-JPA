package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue
	private Long id;
	private String lastname;
	private String firstname;
	
	@ManyToOne
	Book bookPref;

	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@ManyToMany	
	List<Book> books = new LinkedList<Book>();;
	
	public Client() {
		
	}

	public Client(String lastname, String firstname, Gender gender) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Book getBookPref() {
		return bookPref;
	}

	public void setBookPref(Book bookPref) {
		this.bookPref = bookPref;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", bookPref=" + bookPref
				+ ", gender=" + gender + "]";
	}
	
}
