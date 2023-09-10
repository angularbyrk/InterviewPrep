package com.frankmoley.lil.guestservice.api;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.lil.guestservice.data.Guest;
import com.frankmoley.lil.guestservice.data.GuestRepository;
import com.frankmoley.lil.guestservice.error.BadReqeustException;
import com.frankmoley.lil.guestservice.error.NotFoundException;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final GuestRepository guestRepository;
    private Logger log = LoggerFactory.getLogger(GuestController.class);

    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }


    @GetMapping
    public Iterable<Guest> getGuests(@RequestParam(value = "emailAddress", required = false) String emailAddress) {
    	log.debug("get all guests metod execution started");
        if (StringUtils.hasLength(emailAddress)) {
            return this.guestRepository.findGuestsByEmailAddress(emailAddress);
        }
        log.debug("get all guests metod execution completed");
        return this.guestRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Guest addGuest(@RequestBody Guest guest) {
        return this.guestRepository.save(guest);
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id") Long id) {
        Optional<Guest> guest = this.guestRepository.findById(id);
        if (guest.isEmpty()) {
            throw new NotFoundException("id not found: " + id);
        }
        return guest.get();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateGuest(@PathVariable("id") Long id, @RequestBody Guest guest) {
        if (id != guest.getGuestId()) {
            throw new BadReqeustException("incoming id in body doesn't match path");
        }
        this.guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable("id") Long id) {
        this.guestRepository.deleteById(id);
    }
}
