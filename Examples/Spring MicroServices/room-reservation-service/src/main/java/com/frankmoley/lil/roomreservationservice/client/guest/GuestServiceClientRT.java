package com.frankmoley.lil.roomreservationservice.client.guest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GuestServiceClientRT {

	private final RestTemplate restTemplate;

	@Value("${GUEST_SERVICE_URL}")
	private String guestServiceUrl = "http://reservation-server";

	private final static String GUESTS_URL_PART = "/guests";
	private final static String SLASH = "/";

	public GuestServiceClientRT(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Guest> getAll() {
		String url = guestServiceUrl + GUESTS_URL_PART;
		ResponseEntity<Guest[]> response = this.restTemplate.getForEntity(url, Guest[].class);
		return Arrays.asList(response.getBody());
	}

	public Guest addGuest(Guest guest) {
		String url = guestServiceUrl + GUESTS_URL_PART;
		ResponseEntity<Guest> response = this.restTemplate.postForEntity(url, guest, Guest.class);
		return response.getBody();
	}

	public Guest getGuest(long id) {
		String url = guestServiceUrl + GUESTS_URL_PART + SLASH + id;
		ResponseEntity<Guest> response = this.restTemplate.getForEntity(url, Guest.class);
		return response.getBody();
	}

	public void updateGuest(Guest guest) {
		String url = guestServiceUrl + GUESTS_URL_PART + SLASH + guest.getGuestId();
		this.restTemplate.put(url, guest);
	}

	public void deleteGuest(long id) {
		String url = guestServiceUrl + GUESTS_URL_PART + SLASH + id;
		this.restTemplate.delete(url);
	}

}
