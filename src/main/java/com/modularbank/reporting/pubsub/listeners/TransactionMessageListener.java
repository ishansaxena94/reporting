package com.modularbank.reporting.pubsub.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.modularbank.reporting.configurations.TxnMQConfig;
import com.modularbank.reporting.models.AmqpMessage;
import com.modularbank.reporting.pubsub.messages.TransactionMessage;
import com.modularbank.reporting.repository.MessageRepository;

@Component
public class TransactionMessageListener {

	@Autowired
	MessageRepository repo;

	@RabbitListener(queues = TxnMQConfig.TXN_QUEUE)
	public void listener(TransactionMessage message) {

		System.out.println("Consuming: " + message);

		AmqpMessage amqpMessage = new AmqpMessage();
		amqpMessage.setOperation(message.getOperationType());
		amqpMessage.setClassType("Transaction");

		String messageStr = null == message.getTransaction() ? "" : message.getTransaction().toString();
		amqpMessage.setMessage(message.getTransaction().toString());

		repo.save(amqpMessage);
	}
}
