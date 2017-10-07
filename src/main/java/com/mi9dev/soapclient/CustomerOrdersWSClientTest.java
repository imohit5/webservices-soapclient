package com.mi9dev.soapclient;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.List;

import com.mi9dev.customerorders.GetOrdersRequest;
import com.mi9dev.customerorders.GetOrdersResponse;
import com.mi9dev.customerorders.Order;
import com.mi9dev.customerorders.Product;

public class CustomerOrdersWSClientTest {

	public static void main(String[] args) throws MalformedURLException {

		GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
		getOrdersRequest.setCustomerId(BigInteger.valueOf(1));

		CustomerOrdersWSClient customerOrdersWSClient = new CustomerOrdersWSClient();

		GetOrdersResponse ordersResponse = customerOrdersWSClient.getOrdersByCustomerId(getOrdersRequest);

		List<Order> orders = ordersResponse.getOrder();

		for (Order order : orders) {
			System.out.println(order.getId());
			List<Product> products = order.getProduct();
			for (Product product : products) {
				System.out.println(product.getId());
				System.out.println(product.getDescription());
				System.out.println(product.getQuantity());
			}

		}

	}

}
