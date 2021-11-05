/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.repository;

import com.user.api.model.Client;
import com.user.api.model.Reservation;
import com.user.api.model.custom.CountClient;
import com.user.api.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRespository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRespository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRespository.findById(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationCrudRespository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservationCrudRespository.delete(reservation);
    }

    public List<CountClient> getTopClients() {

        List<CountClient> res = new ArrayList<>();

        List<Object[]> report = reservationCrudRespository.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationByPeriod(Date dateOne, Date dateTwo) {
        return reservationCrudRespository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<Reservation> getReservationsByStatus(String status) {
        return reservationCrudRespository.findAllByStatus(status);
    }

}
