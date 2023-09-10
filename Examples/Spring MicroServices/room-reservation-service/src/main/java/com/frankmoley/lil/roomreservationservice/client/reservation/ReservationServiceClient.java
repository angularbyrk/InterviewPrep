package com.frankmoley.lil.roomreservationservice.client.reservation;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("reservation-service")
public interface ReservationServiceClient {

	@GetMapping("/reservations")
	public List<Reservation> getAll(@RequestParam(name = "dateString", required = false) String dateString,
			@RequestParam(name = "guestId", required = false) Long guestId);

	@PostMapping("/reservations")
	public Reservation addReservation(@RequestBody Reservation reservation);

	@GetMapping("/reservations/{id}")
	public Reservation getReservation(@PathVariable("id") long id);

	@PutMapping("/reservations/{id}")
	public void updateReservation(@PathVariable("id") long id, @RequestBody Reservation reservation);

	@DeleteMapping("/reservations/{id}")
	public void deleteReservation(@PathVariable("id") long id);

}
