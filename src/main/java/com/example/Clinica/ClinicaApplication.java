package com.example.Clinica;

import com.example.Clinica.User.Doctor;
import com.example.Clinica.User.DoctorRepository;
import com.example.Clinica.User.Nurse;
import com.example.Clinica.User.NurseRepository;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Setter
@SpringBootApplication
public class ClinicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}
	/*@Bean
		public CommandLineRunner loadData(DoctorRepository doctorRepository, NurseRepository nurseRepository){
return(args) ->{

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Doctor doctor = new Doctor();
		doctor.setName("Jose");
		doctor.setCpf("00000000000");
		doctor.setPassword(encoder.encode("12345"));
		doctor.setRole("ROLE_MEDICO");
		doctorRepository.save(doctor);

		Nurse nurse = new Nurse();
		nurse.setName("Paulo");
		nurse.setCpf("11111111111");
		nurse.setPassword(encoder.encode("12345"));
		nurse.setRole("ROLE_ENFERMEIRO");
		nurseRepository.save(nurse);

	};
	}
*/
}
