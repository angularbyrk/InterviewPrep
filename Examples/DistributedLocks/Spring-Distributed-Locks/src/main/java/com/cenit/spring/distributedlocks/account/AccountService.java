package com.cenit.spring.distributedlocks.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	private LockRegistry lockRegistry;

	@Autowired
	private AccountRepository accountRepository;

	public void updateAccountViaDistributedLocks(Long id) throws InterruptedException {
		var lock = lockRegistry.obtain(String.valueOf(id));
		boolean lockAquired = lock.tryLock();
		if (lockAquired) {
			try {
				updateAccount(id);
			} finally {
				lock.unlock();
			}
		}
		else
		{
			System.out.println("cannot get the lock");
		}
	}

	public void updateAccount(Long id) throws InterruptedException {
		Account account = accountRepository.findById(id).get();
		account.setBalance(account.getBalance() + 100L);
		Thread.sleep(20_000);
		accountRepository.save(account);
	}

}
