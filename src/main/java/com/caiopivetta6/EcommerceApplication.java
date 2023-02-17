package com.caiopivetta6;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Address;
import com.caiopivetta6.domain.City;
import com.caiopivetta6.domain.Client;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.repositories.AddressRepository;
import com.caiopivetta6.repositories.CityRepository;
import com.caiopivetta6.repositories.ClientRepository;
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
	

	@Override
	public void run(String... args) throws Exception, ParseException {
		
		
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
		
		
		
	}

}
