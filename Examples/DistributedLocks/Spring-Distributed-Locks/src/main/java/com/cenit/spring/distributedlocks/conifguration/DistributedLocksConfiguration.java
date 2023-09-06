package com.cenit.spring.distributedlocks.conifguration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.jdbc.lock.DefaultLockRepository;
import org.springframework.integration.jdbc.lock.JdbcLockRegistry;
import org.springframework.integration.jdbc.lock.LockRepository;

@Configuration
public class DistributedLocksConfiguration {

	@Bean
	public DefaultLockRepository DefaultLockRepository(DataSource dataSource) {
		return new DefaultLockRepository(dataSource);
	}

	@Bean
	public JdbcLockRegistry jdbcLockRegistry(LockRepository lockRepository) {
		return new JdbcLockRegistry(lockRepository);
	}

}
