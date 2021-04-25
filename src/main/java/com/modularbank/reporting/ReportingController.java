package com.modularbank.reporting;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modularbank.reporting.models.AmqpMessage;
import com.modularbank.reporting.repository.MessageRepository;

@RestController
public class ReportingController {

	@Autowired
	MessageRepository repo;

	@GetMapping("/all")
	public List<AmqpMessage> getAllEntries() {
		return repo.findAll();
	}

	@GetMapping("/operation")
	public List<AmqpMessage> getByOperationType(@RequestParam(name = "type") String operationType) {

		if ("CREATE".contentEquals(operationType) || ("UPDATE".contentEquals(operationType)))
			return repo.findByOperation(operationType);

		return Collections.emptyList();
	}

	@GetMapping("/class")
	public List<AmqpMessage> getByClassType(@RequestParam(name = "type") String classType) {

		if ("Account".contentEquals(classType) || ("Transaction".contentEquals(classType)))
			return repo.findByClassType(classType);

		return Collections.emptyList();
	}
}
