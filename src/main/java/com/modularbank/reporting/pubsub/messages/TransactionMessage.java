package com.modularbank.reporting.pubsub.messages;

import java.util.Date;

import com.modularbank.reporting.models.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionMessage {

	private String messageId;
	private Date messageDate;
	private String operationType;
	private Transaction transaction;
}
