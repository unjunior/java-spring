package com.junior.desafio1;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.junior.desafio1.entities.Order;
import com.junior.desafio1.services.OrderService;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {

	@Autowired
	private OrderService orderService;


	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		
		int code = s.nextInt();
		double basic = s.nextDouble();
		double discount = s.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		double total = orderService.total(order);
		
		System.out.println("Pedido codigo " + code);
		System.out.printf("Valor total: R$ %.2f", total);
		
		
		s.close();
	}

}
