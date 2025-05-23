package com.younes.hospital2;

import com.younes.hospital2.entities.Patient;
import com.younes.hospital2.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class Hospital2Application implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(Hospital2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        patientRepository.save(new Patient(null,"Mohamed",LocalDate.now(),false,90));
        patientRepository.save(new Patient(null,"Rachid",LocalDate.now(),true,100));
        patientRepository.save(new Patient(null,"Imran",LocalDate.now(),false,140));
    }

}
