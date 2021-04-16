package exercise.order.service;

import exercise.order.domain.Customer;
import exercise.order.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService {

	// save()
	// delete()
	private CustomerRepository repository;

	public CustomerServiceImpl() {
	}

	
	
	public CustomerRepository getRepository() {
		return repository;
	}



	public void setRepository(CustomerRepository repository) {
		this.repository = repository;
	}



	// repository에 Customer 객체 저장
	// 저장 성공시, "customer + "가 저장되었습니다." 출력
	@Override
	public void saveCustomer(Customer customer) {
		repository.save(customer);
	}

	// repository로부터 id 삭제
	// 삭제 성공시, id + "번 고객이 삭제되었습니다." 출력
	@Override
	public void deleteCustomer(long id) {
		repository.delete(id);
	}
}
