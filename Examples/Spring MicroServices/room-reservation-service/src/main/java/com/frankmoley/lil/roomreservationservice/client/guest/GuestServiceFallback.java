package com.frankmoley.lil.roomreservationservice.client.guest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GuestServiceFallback implements GuestServiceClient{

	public List<Guest> getAll(){
		return new ArrayList();
	}

	public Guest addGuest(Guest guest) {
		return new Guest();
	}

	public Guest getGuest(long id) {
		return new Guest();
	}

	public void updateGuest(long id, Guest guest) {
		
	}

	public void deleteGuest(long id) {
		
	}

}
