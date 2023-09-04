package com.cenit.tran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

public class OrderManager {

	@Autowired
	private OrderService orderService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private NotificationService notificationService;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Transactional(rollbackFor = {NullPointerException.class})
	public void completeOrderUsingDeclarative(Object request) {
		orderService.generateOrder(request); // DB call
		orderService.generateInvoice(request); // DB call
		paymentService.paymentApi(request); // external API call
		paymentService.savePaymentInfo(request); // DB call
		notificationService.createSubscription(request); // DB call
		notificationService.sendInvoiceEmail(); // internal API call
	}

	public void completeOrderUsingProgramatic(Object request) {
		transactionTemplate.execute((status)->{
			
			orderService.generateOrder(request); // DB call
			orderService.generateInvoice(request); // DB call
			paymentService.paymentApi(request); // external API call
			paymentService.savePaymentInfo(request); // DB call
			notificationService.createSubscription(request); // DB call
			notificationService.sendInvoiceEmail(); // internal API call	
			
			return request;
		});
		
	}

}
