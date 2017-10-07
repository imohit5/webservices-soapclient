package com.bottomup.demo;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import com.mi9dev.customerorders.GetOrdersRequest;
import com.mi9dev.customerorders.GetOrdersResponse;
import com.mi9dev.customerorders.Order;
import com.mi9dev.customerorders.Product;

public class PaymentProcessorWSClientTest {

	public static void main(String[] args) throws MalformedURLException, DatatypeConfigurationException {

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

		CCInfo creditCardInfo = new CCInfo();
		creditCardInfo.setCardNumber("123");
		creditCardInfo.setFirstName("Tim");
		creditCardInfo.setLastName("Tom");
		creditCardInfo.setExpirtyDate(date2);
		creditCardInfo.setSecCode("1234");
		creditCardInfo.setAddress("Tim Tom");

		PaymentRequest paymentRequest = new PaymentRequest();
		paymentRequest.setAmount(123);
		paymentRequest.setCreditCardInfo(creditCardInfo);

		PaymentProcessorWSClient paymentProcessorWSClient = new PaymentProcessorWSClient();

		PaymentResponse processPaymentByDetails = paymentProcessorWSClient.processPaymentByDetails(paymentRequest);

		boolean result = processPaymentByDetails.isResult();

		System.out.println(result);

	}

}
