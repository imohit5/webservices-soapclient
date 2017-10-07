package com.bottomup.demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.mi9dev.customerorders.CustomerOrders;
import com.mi9dev.customerorders.CustomerOrdersService;
import com.mi9dev.customerorders.GetOrdersRequest;
import com.mi9dev.customerorders.GetOrdersResponse;

public class PaymentProcessorWSClient {

	public PaymentResponse processPaymentByDetails(PaymentRequest paymentRequest) throws MalformedURLException {

		PaymentProcessorService paymentProcessorService = new PaymentProcessorService(
				new URL("http://localhost:8080/webservices-approach-bottomup/services/paymentProcessor?wsdl"));
		PaymentProcessor paymentProcessorPort = paymentProcessorService.getPaymentProcessorPort();
		
		Client client = ClientProxy.getClient(paymentProcessorPort);
		Endpoint endpoint = client.getEndpoint();
		
		Map<String, Object> props= new HashMap<>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.USER, "Tim");
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UserTokenPwdCallback.class.getName());
		
		WSS4JOutInterceptor wss4jOutInterceptor = new WSS4JOutInterceptor(props);
		
		endpoint.getOutInterceptors().add(wss4jOutInterceptor);
		
		PaymentResponse processPayment = paymentProcessorPort.processPayment(paymentRequest);
		return processPayment;
	}

}
