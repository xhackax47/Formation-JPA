package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Book;
import model.Client;

public class ServiceJPA {

	public static void displayBooksByCustomer(EntityManager em, Client c) {

		for (Book b : em.find(Client.class, c.getId()).getBooks()) {
			System.out.println("Livres achetés par " + c.getFirstname() + " " + c.getLastname() + " :");
			System.out.println(b.getTitle() + " écrit par " + b.getAuthor());
		}

	}

	public static void displayCustomersByBook(EntityManager em, Book b) {

		for (Client c : em.find(Book.class, b.getId()).getClients()) {
			System.out.println("Acheteurs pour le livre " + b.getTitle() + " :");
			System.out.println(c.getFirstname() + " / " + c.getLastname());
		}

	}

	public static void displayPurchasedBook(EntityManager em) {

		TypedQuery<Book> query = em.createQuery("SELECT b" + " FROM Book b" + " INNER JOIN b.clients",
				Book.class);
		List<Book> lb = query.getResultList();
		System.out.println("Livres achetés : ");
		System.out.println("");
		for (Book b : lb) {
			System.out.println(b.getTitle() + " écrit par " + b.getAuthor());
		}

	}

	public static void buyBook(EntityManager em, Client c, Book b) {

		System.out.println(
				"Achat du livre " + b.getTitle() + " par le client " + c.getFirstname() + " / " + c.getLastname());
		List<Book> lb = c.getBooks();
		lb.add(b);
	}

}
