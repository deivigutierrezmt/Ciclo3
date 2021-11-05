/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.service;

import com.user.api.model.Reservation;
import com.user.api.model.custom.CountClient;
import com.user.api.model.custom.StatusAmount;
import com.user.api.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRespository;

    public List<Reservation> getAll() {
        return reservationRespository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRespository.getReservation(id);
    }

    public Reservation reservationSave(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRespository.save(reservation);
        } else {
            Optional<Reservation> reservationAux = reservationRespository.getReservation(reservation.getIdReservation());
            if (reservationAux.isEmpty()) {
                return reservationRespository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation reservationUpdate(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationAux = reservationRespository.getReservation(reservation.getIdReservation());
            if (!reservationAux.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    reservationAux.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    reservationAux.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    reservationAux.get().setStatus(reservation.getStatus());
                }
                return reservationRespository.save(reservation);
            }//fin del reservatione aux
        }
        return reservation;
    }

    public boolean reservationDelete(int id) {
        Optional<Reservation> reservationAux = reservationRespository.getReservation(id);
        if (!reservationAux.isEmpty()) {
            reservationRespository.delete(reservationAux.get());
            return true;
        }
        return false;
    }

    public List<CountClient> getTopClient() {
        return reservationRespository.getTopClients();
    }

    public List<Reservation> getReservationPeriod(String date1, String date2) {

        // yyyy-mm-dd
        SimpleDateFormat parseDate = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();

        try {
            dateOne = parseDate.parse(date1);
            dateTwo = parseDate.parse(date2);
        } catch (ParseException e) {
        }

        if (dateOne.before(dateTwo)) {
            return reservationRespository.getReservationByPeriod(dateOne, dateTwo);
        } else {
            return new ArrayList<>();
        }
    }
    
    public StatusAmount getStatusReport() {
        List<Reservation> completed = reservationRespository.getReservationsByStatus("completed");
        List<Reservation> cancelled = reservationRespository.getReservationsByStatus("cancelled");
        
        StatusAmount statusAmount = new StatusAmount(completed.size(), cancelled.size());
        
        return statusAmount;
    }
}
