package com.modularbank.reporting.pubsub.messages;

import java.util.Date;

import com.modularbank.reporting.models.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountMessage {

	private String messageId;
	private Date messageDate;
	private String operationType;
	private Account account;
}
