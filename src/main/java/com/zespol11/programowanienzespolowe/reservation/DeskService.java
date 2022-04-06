package com.zespol11.programowanienzespolowe.reservation;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class DeskService {

    private final DeskRepository deskRepository;

    public DeskService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    public List<Desk> getAllDesks(){
        return deskRepository.findAll();
    }

    public Desk getDeskByNumber(Integer number){

        Desk desk = deskRepository.findById(number)
                .orElseThrow(() -> new IllegalStateException(
                        "Desk with number " + number + "does not exist"
                        ));

        return desk;
    }

    @Transactional
    public void addNewDateTimeToDesk(LocalDateTime dateTime, Integer number){
        Desk desk = deskRepository.findById(number)
                .orElseThrow(() -> new IllegalStateException(
                        "Desk with number " + number + "does not exist"
                ));

        Set<LocalDateTime> avialiable = desk.getAvailable();

        avialiable.add(dateTime);
    }

    @Transactional
    public void deleteDateTimeFromDesk(LocalDateTime dateTime, Integer number){
        Desk desk = deskRepository.findById(number)
                .orElseThrow(() -> new IllegalStateException(
                        "Desk with number " + number + "does not exist"
                ));

        Set<LocalDateTime> avialiable = desk.getAvailable();

        avialiable.remove(dateTime);

        desk.setAvailable(avialiable);
    }

    @Transactional
    public void updateDateTimeFromDesk(LocalDateTime old, LocalDateTime newDate, Integer number){
        Desk desk = deskRepository.findById(number)
                .orElseThrow(() -> new IllegalStateException(
                        "Desk with number " + number + "does not exist"
                ));

        Set<LocalDateTime> avialiable = desk.getAvailable();

        avialiable.remove(old);

        avialiable.add(newDate);

        desk.setAvailable(avialiable);
    }

    public void addNewDesk(Desk desk){
        Optional<Desk> deskOptional = deskRepository.findById(desk.getNumber());

        if(desk.getNumber() == null){
            throw new IllegalStateException("Number must not be null!");
        }

        if(deskOptional.isPresent()){
            throw new IllegalStateException("Desk with number " + desk.getNumber() + " exists");
        }

        deskRepository.save(desk);
    }

    @Transactional
    public void updateDesk(Integer number,
                           Integer size,
                           String localization
                           ){

        Desk desk = deskRepository.findById(number)
                .orElseThrow(() ->
                        new IllegalStateException("Desk with number " + number + "does not exist"
                        ));

        if(size != null &&
                !Objects.equals(size, desk.getCapacity())){
            desk.setCapacity(size);
        }

        if(localization != null &&
                localization.length() > 0 &&
                !Objects.equals(localization, desk.getLocation())){
            desk.setLocation(localization);
        }


    }

    public void deleteDesk(Integer number){
        boolean exist = deskRepository.existsById(number);

        if(!exist){
            throw new IllegalStateException(
                    "Desk with number " + number + "does not exist"
            );
        }

        deskRepository.deleteById(number);
    }


    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        Set<LocalDateTime> set = new TreeSet<>();

        LocalDateTime localDateTime = LocalDateTime.of(2022, 3, 22, 12,00);

        set.add(localDateTime);

        addNewDesk(new Desk(1, 4, "patio",set));
    }
}
