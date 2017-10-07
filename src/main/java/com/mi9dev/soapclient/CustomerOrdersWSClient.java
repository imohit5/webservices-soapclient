package com.mi9dev.soapclient;

import java.net.MalformedURLException;
import java.net.URL;

import com.mi9dev.customerorders.CustomerOrders;
import com.mi9dev.customerorders.CustomerOrdersService;
import com.mi9dev.customerorders.GetOrdersRequest;
import com.mi9dev.customerorders.GetOrdersResponse;

public class CustomerOrdersWSClient {

	public GetOrdersResponse getOrdersByCustomerId(GetOrdersRequest getOrdersRequest) throws MalformedURLException {

		CustomerOrdersService customerOrdersService = new CustomerOrdersService(
				new URL("http://localhost:8080/webservices-approach-topdown/services/customerOrders?wsdl"));
		CustomerOrders customerOrdersSOAP = customerOrdersService.getCustomerOrdersSOAP();
		GetOrdersResponse ordersResponse = customerOrdersSOAP.getOrders(getOrdersRequest);
		return ordersResponse;
	}

}
