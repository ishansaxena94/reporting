package com.modularbank.reporting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.modularbank.reporting.models.AmqpMessage;

@Repository
public interface MessageRepository extends JpaRepository<AmqpMessage, Long> {

	List<AmqpMessage> findByClassType(String classType);

	List<AmqpMessage> findByOperation(String operation);

}
