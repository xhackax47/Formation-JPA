package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue
	private Long id;

	private String title;
	private String author;
	
	@OneToMany(mappedBy= "bookPref")
	List<Client> clientsHavePref;
	
	@ManyToMany(mappedBy= "books")	
	List<Client> clients;

	public Book() {

	}

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Client> getClientsHavePref() {
		return clientsHavePref;
	}

	public void setClientsHavePref(List<Client> clientsHavePref) {
		this.clientsHavePref = clientsHavePref;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
}
