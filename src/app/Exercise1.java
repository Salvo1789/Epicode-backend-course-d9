package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.classes.Customer;
import app.classes.Order;
import app.classes.Product;

public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Customer> clienti = new ArrayList<>();
		Customer c1 = new Customer(681340, "Salvatore Mercurio", 2);
		Customer c2 = new Customer(180594, "Ermenegildo Paolini", 3);
		Customer c3 = new Customer(921165, "Luigia De Luisi", 1);

		clienti.add(c1);
		clienti.add(c2);
		clienti.add(c3);

//		System.out.println(clienti);
		for (Customer cliente : clienti) {
			System.out.println(cliente);
		}

		List<Product> prodotti = new ArrayList<>();
		Product p1 = new Product(123, "Animali fantastici e dove trovarli", "Books", 14.99);
		Product p2 = new Product(456, "Il Gattopardo", "Books", 9.99);
		Product p3 = new Product(789, "Transformer", "Boys", 24.99);
		Product p4 = new Product(901, "Sonaglino", "Baby", 9.99);

		prodotti.add(p1);
		prodotti.add(p2);
		prodotti.add(p3);
		prodotti.add(p4);

//		System.out.print(prodotti);
		for (Product prodotto : prodotti) {
			System.out.println(prodotto);
		}

		List<Order> ordini = new ArrayList<>();

		LocalDate today = LocalDate.now();
		LocalDate delivery = today.plusDays(3);

		Order o1 = new Order(1, "In corso", today, p1, c1, delivery);
		Order o2 = new Order(2, "In magazzino", today, p2, c2, delivery);
		Order o3 = new Order(3, "Arrivato", today, p3, c3, delivery);
		Order o4 = new Order(1, "In magazzino", today, p4, c1, delivery);

		ordini.add(o4);
		ordini.add(o3);
		ordini.add(o2);
		ordini.add(o1);

		// --------EXERCISE 1-------//
		List<Product> libriMaggioreDi100 = prodotti.stream().filter(n -> n.getCategory().equals("Books"))
				.filter(n -> n.getPrice() > 100).toList();
		System.out.println("I prodotti di categoria 'Books' e che costano meno di 100 sono: " + libriMaggioreDi100);

		List<Order> orders = ordini.stream().filter(n -> n.getProduct().getCategory().equals("Baby")).toList();
		System.out.println(orders);
		// ----------Exercise 3-------//

		List<Product> prodottiScontati = prodotti.stream().filter(n -> n.getCategory().equals("Boys"))
				.forEach(n -> ((n.getPrice() * 10.00) / 100.00));

	}

}