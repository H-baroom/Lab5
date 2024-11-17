package com.example.lab53.eventSystem;

import com.example.lab53.ApiResponse.ApiResponse;
import com.example.lab53.event.Event;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class eventSystem {
    ArrayList<Event> events = new ArrayList();

    @GetMapping("/displayEvent")
    public ArrayList<Event> getEvents() {
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added");
    }

    @PutMapping ("/update/{index}")
    public ApiResponse updateEvent(@RequestBody Event event, @PathVariable int index) {
        events.set(index,event);
        return new ApiResponse("Event updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index) {
        events.remove(index);
        return new ApiResponse("Event deleted");
    }

    @PutMapping("/changeCapacity/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index ,@PathVariable int capacity) {
        events.get(index).setCapacity(capacity);
        return new ApiResponse("Event capacity changed");
    }

    @GetMapping("/searchEventByGivenID/{id}")
    public Event searchEventByGivenID(@PathVariable String id){
        for (Event event : events) {
            if (event.getID().equals(id)) {
                return event;
            }
        }
        return null;
    }
}
