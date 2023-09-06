package com.cenit.spring.distributedlocks.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AccountController {
	@Autowired
	AccountService accountService;

	@GetMapping("/updateAccount/{id}")
	public void updateAccount(@PathVariable("id") Long id) throws InterruptedException {
		accountService.updateAccount(id);
	}

	@GetMapping("/updateAccountViaDistributedLocks/{id}")
	public void updateAccountViaDistributedLocks(@PathVariable("id") Long id) throws InterruptedException {
		accountService.updateAccountViaDistributedLocks(id);
	}
}
