package com.frankmoley.lil.roomservice.api;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.frankmoley.lil.roomservice.data.Room;
import com.frankmoley.lil.roomservice.data.RoomRepository;
import com.frankmoley.lil.roomservice.error.BadReqeustException;
import com.frankmoley.lil.roomservice.error.NotFoundException;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository roomRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(RoomController.class);
    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public Iterable<Room> getAll() {
    	LOGGER.debug("get all rooms metod execution started");
    	Iterable<Room> rooms =  this.roomRepository.findAll();
    	LOGGER.debug("get all rooms metod execution completed");    	
    	return rooms;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room addRoom(@RequestBody Room room) {
        return this.roomRepository.save(room);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id") long id) {
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new NotFoundException("id not found " + id);
        }
        return room.get();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoom(@PathVariable("id") long id, @RequestBody Room room) {
        if (id != room.getRoomId()) {
            throw new BadReqeustException("id in body doesn't match path");
        }
        this.roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable("id") long id) {
        this.roomRepository.deleteById(id);
    }
}
