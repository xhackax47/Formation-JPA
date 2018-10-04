import javax.persistence.EntityManager;

import DAO.DatabaseHelper;
import DAO.ServiceJPA;
import model.Book;
import model.Client;
import model.Gender;

public class MainJPA {

	public static void start() {

        EntityManager em = DatabaseHelper.createEntityManager();       
        DatabaseHelper.beginTx(em);

        Client c = new Client("Uzumaki", "Naruto", Gender.M);
        Client c2 = new Client("Haruno", "Sakura", Gender.F);
        Client c3 = new Client("Uchiha", "Madara", Gender.M);
        Book b =  new Book("L'art de la guerre", "Sun Tzu") ;
        Book b2 = new Book("Le vieil homme et la mer", "Ernest Hemingway");
        Book b3 = new Book("Le Seigneur des Anneaux","JRR Tolkien");
        
        em.persist(b);
        em.persist(b2);
        em.persist(b3);
        em.persist(c);
        em.persist(c2);
        em.persist(c3);

        ServiceJPA.buyBook(em, c, b);
        System.out.println("");
        ServiceJPA.buyBook(em, c2, b2);
        System.out.println("");
//        ServiceJPA.buyBook(em, c3, b3);
        c.setBookPref(b);
        c2.setBookPref(b2);
        c3.setBookPref(b3);
   
        DatabaseHelper.commitTxAndClose(em);
        
        em = DatabaseHelper.createEntityManager();
        DatabaseHelper.beginTx(em);
        
        System.out.println("");
        ServiceJPA.displayBooksByCustomer(em, c);
        System.out.println("");
        ServiceJPA.displayBooksByCustomer(em, c2);
        System.out.println("");
        ServiceJPA.displayBooksByCustomer(em, c3);
        System.out.println("");
        ServiceJPA.displayCustomersByBook(em, b);
        System.out.println("");
        ServiceJPA.displayCustomersByBook(em, b2);
        System.out.println("");
        ServiceJPA.displayCustomersByBook(em, b3);
        System.out.println("");
        ServiceJPA.displayPurchasedBook(em);
        System.out.println("");
        
        DatabaseHelper.commitTxAndClose(em);
        em.close();
	}

}
