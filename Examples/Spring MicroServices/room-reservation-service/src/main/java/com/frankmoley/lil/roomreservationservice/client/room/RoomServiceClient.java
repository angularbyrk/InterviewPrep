package com.frankmoley.lil.roomreservationservice.client.room;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("room-service")
public interface RoomServiceClient {

	@GetMapping("/rooms")
	public List<Room> getAll();

	@PostMapping("/rooms")
	public Room addRoom(@RequestBody Room room);

	@GetMapping("/rooms/{id}")
	public Room getRoom(@PathVariable("id") long id);

	@PutMapping("/rooms/{id}")
	public void updateRoom(@PathVariable("id") long id, @RequestBody Room room);

	@DeleteMapping("/rooms/{id}")
	public void deleteRoom(@PathVariable("id") long id);
}
