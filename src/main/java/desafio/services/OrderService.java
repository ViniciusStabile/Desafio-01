package desafio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import desafio.entities.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;
	
	
	public double total(Order order) {
		double discount = order.getDiscount() * order.getBasic() / 100;
		return order.getBasic() - discount + shippingService.shipment(order);
	}
	
}
