package exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exercise.order.domain.Customer;
import exercise.order.repository.CustomerRepository;
import exercise.order.repository.CustomerRepositoryImpl;
import exercise.order.service.CustomerService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("exercise/beans.xml");

		Customer customer = (Customer) ctx.getBean("customer");
		
		System.out.println(customer.getId());
		System.out.println(customer.getAddress());
		System.out.println(customer.getEmail());
		System.out.println(customer.getName());

		
		CustomerService customerService = (CustomerService) ctx.getBean("customerServiceImpl");
		
		
		customerService.saveCustomer(customer);
		customerService.deleteCustomer(1);
		
	}

}
