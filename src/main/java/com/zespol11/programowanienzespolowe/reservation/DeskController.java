package com.zespol11.programowanienzespolowe.reservation;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/desks")
public class DeskController {

    private final DeskService deskService;

    public DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @GetMapping
    public List<Desk> getAll(){
        return deskService.getAllDesks();
    }

    @GetMapping(path = "/{number}")
    public Desk getDeskByNumber(@PathVariable Integer number){
        return deskService.getDeskByNumber(number);
    }

    @PostMapping
    public void addNewDesk(@RequestBody Desk desk){
        deskService.addNewDesk(desk);
    }

    @PutMapping(path = "/{number}")
    public void updateDesk(@PathVariable Integer number,
                           @RequestParam(required = false) Integer capacity,
                           @RequestParam(required = false) String location){
        deskService.updateDesk(number, capacity, location);
    }

    @PutMapping(path = "/available/{number}")
    public void updateAvaiable(@PathVariable Integer number,
                               @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")LocalDateTime old,
                               @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")LocalDateTime newD){
        deskService.updateDateTimeFromDesk(old, newD, number);
    }

    @PutMapping(path = "/new-avaiable/{number}")
    public void addAvaiable(@PathVariable Integer number, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")LocalDateTime dateTime){
        deskService.addNewDateTimeToDesk(dateTime, number);
    }

    @DeleteMapping(path = "/avaiable/{number}")
    public void deleteAvaiable(@PathVariable Integer number, @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm")LocalDateTime dateTime){
        deskService.deleteDateTimeFromDesk(dateTime, number);
    }

    @DeleteMapping(path = "/{number}")
    public void deleteDesk(@PathVariable Integer number){
        deskService.deleteDesk(number);
    }





}
