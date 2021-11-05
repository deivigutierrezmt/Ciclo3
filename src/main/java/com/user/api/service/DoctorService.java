/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.user.api.service;

import com.user.api.model.Doctor;
import com.user.api.repository.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return doctorRepository.getAll();
    }

    public Optional<Doctor> getDoctor(int id) {
        return doctorRepository.getDoctor(id);
    }

    public Doctor doctorSave(Doctor doctor) {
        if (doctor.getId()== null) {
            return doctorRepository.save(doctor);
        } else {
            Optional<Doctor> doctorAux = doctorRepository.getDoctor(doctor.getId());
            if (doctorAux.isEmpty()) {
                return doctorRepository.save(doctor);
            } else {
                return doctor;
            }
        }
    }

    public Doctor doctorUpdate(Doctor doctor) {
        if (doctor.getId() != null) {
            Optional<Doctor> doctorAux = doctorRepository.getDoctor(doctor.getId());
            if (!doctorAux.isEmpty()) {
                if (doctor.getName() != null) {
                    doctorAux.get().setName(doctor.getName());
                }
                if (doctor.getDepartment() != null) {
                    doctorAux.get().setDepartment(doctor.getDepartment());
                }
                if (doctor.getYear() != null) {
                    doctorAux.get().setYear(doctor.getYear());
                }
                if (doctor.getDescription() != null) {
                    doctorAux.get().setDescription(doctor.getDescription());
                }
                return doctorRepository.save(doctor);
            }
        }
        return doctor;
    }

    public boolean doctorDelete(int id) {
        Optional<Doctor> doctorAux = doctorRepository.getDoctor(id);
        if (!doctorAux.isEmpty()) {
            doctorRepository.delete(doctorAux.get());
            return true;
        }
        return false;
    }
}
