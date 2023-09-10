package com.frankmoley.lil.roomreservationservice.client.guest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "guest-service", fallback = GuestServiceFallback.class)
public interface GuestServiceClient {

	@GetMapping("/guests")
	public List<Guest> getAll();

	@PostMapping
	public Guest addGuest(@RequestBody Guest guest);

	@GetMapping("/guests/{id}")
	public Guest getGuest(@PathVariable("id") long id);

	@PutMapping("/guests/{id}")
	public void updateGuest(@PathVariable("id") long id, @RequestBody Guest guest);

	@DeleteMapping("/guests/{id}")
	public void deleteGuest(@PathVariable("id") long id);

}
