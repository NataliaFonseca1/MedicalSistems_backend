/*package com.example.Clinica.Security;


import com.example.Clinica.User.Doctor;
import com.example.Clinica.User.DoctorRepository;
import com.example.Clinica.User.Nurse;
import com.example.Clinica.User.NurseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Getter
@Setter
@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/clients").hasAuthority("ROLE_MEDICO")
                        .requestMatchers("/api/enfermeiro/**").hasAuthority("ROLE_ENFERMEIRO")
                        .anyRequest().authenticated()
                );
                return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(DoctorRepository doctorRepository, NurseRepository nurseRepository) {
        return name -> {
            Doctor doctor = doctorRepository.findByName(name);
            if (doctor != null) {
                return org.springframework.security.core.userdetails.User
                        .withUsername(doctor.getName())
                        .password(doctor.getPassword())
                        .authorities(doctor.getRole())
                        .build();
            }

            Nurse nurse = nurseRepository.findByName(name);
            if (nurse != null) {
                return org.springframework.security.core.userdetails.User
                        .withUsername(nurse.getName())
                        .password(nurse.getPassword())
                        .authorities(nurse.getRole())
                        .build();
            }

            throw new EntityNotFoundException("Usuário não encontrado");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
*/
