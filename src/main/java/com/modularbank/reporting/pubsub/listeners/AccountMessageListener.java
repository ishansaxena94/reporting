package com.modularbank.reporting.pubsub.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.modularbank.reporting.configurations.MQConfig;
import com.modularbank.reporting.models.AmqpMessage;
import com.modularbank.reporting.pubsub.messages.AccountMessage;
import com.modularbank.reporting.repository.MessageRepository;

@Component
public class AccountMessageListener {

	@Autowired
	MessageRepository repo;

	@RabbitListener(queues = MQConfig.ACC_QUEUE)
	public void listener(AccountMessage message) {
		System.out.println("Consuming: " + message);

		AmqpMessage amqpMessage = new AmqpMessage();
		amqpMessage.setOperation(message.getOperationType());
		amqpMessage.setClassType("Account");

		String messageStr = null == message.getAccount() ? "" : message.getAccount().toString();
		amqpMessage.setMessage(messageStr);

		repo.save(amqpMessage);

	}
}
