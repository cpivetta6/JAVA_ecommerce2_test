package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Address;
import com.caiopivetta6.domain.Category;
import com.caiopivetta6.domain.City;
import com.caiopivetta6.domain.Client;
import com.caiopivetta6.domain.Order;
import com.caiopivetta6.domain.OrderItem;
import com.caiopivetta6.domain.Payment;
import com.caiopivetta6.domain.Product;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.domain.enums.CategoryName;
import com.caiopivetta6.domain.enums.OrderStatus;
import com.caiopivetta6.repositories.AddressRepository;
import com.caiopivetta6.repositories.CategoryRepository;
import com.caiopivetta6.repositories.CityRepository;
import com.caiopivetta6.repositories.ClientRepository;
import com.caiopivetta6.repositories.OrderItemRepository;
import com.caiopivetta6.repositories.OrderRepository;
import com.caiopivetta6.repositories.PaymentRepository;
import com.caiopivetta6.repositories.ProductRepository;
import com.caiopivetta6.repositories.StateRepository;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	

	@Override
	public void run(String... args) throws Exception, ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//STATE, CITY
		State state = new State(null, "Veneto");
		City city = new City(null, "Verona", state);
		
		
		stateRepository.save(state);
		cityRepository.save(city);
		
		
		//CLIENT AND ADDRESS
		Address address = new Address(null, "Verona Centro", "Via Mazini", "78", "465654", city);
		
		Client client = new Client(null, "Carl Better", "carl@gmail.com", "3464565456");
		client.getAddress().add(address);
		address.setClient(client);
		
		clientRepository.save(client);
		addressRepository.save(address);
		
		//CATEGORY AND PRODUCT
		
		Category category = new Category(null, CategoryName.ELETRONIC);
		Product product1 = new Product(null, "Computer", "Core i7", 800.0);
		Product product2 = new Product(null, "Computer", "Core i5", 700.0);
		
		category.getProducts().addAll(Arrays.asList(product1, product2));
		product1.getCategories().add(category);
		product2.getCategories().add(category);
		
		categoryRepository.save(category);
		productRepository.saveAll(Arrays.asList(product1, product2));
		
		//ORDER AND PAYMENT
		Order order = new Order(null, sdf.parse("12/02/2023").toInstant());
		order.setClient(client);
		
		Payment payment = new Payment(null, sdf.parse("12/01/2023").toInstant());
		payment.setOrder(order);
		order.setPayment(payment);
		
		orderRepository.save(order);
		paymentRepository.save(payment);
		
		//ORDER ITEM
		
		OrderItem orderItem = new OrderItem(product1, order, 2, product1.getPrice());
		OrderItem orderItem2 = new OrderItem(product2, order, 1, product2.getPrice());
		
		order.getOrderItems().addAll(Arrays.asList(orderItem, orderItem2));
		
		product1.getOrderItems().add(orderItem);
		product2.getOrderItems().add(orderItem2);
		
		orderItemRepository.saveAll(Arrays.asList(orderItem, orderItem2));
		
		
		
		
	}

}
