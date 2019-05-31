package com.example.restbackend.config;

import com.example.restbackend.model.Role;
import com.example.restbackend.model.RoleName;
import com.example.restbackend.model.SoccerPlayer;
import com.example.restbackend.model.User;
import com.example.restbackend.repository.RoleRepository;
import com.example.restbackend.repository.SoccerRepository;
import com.example.restbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Configuration
public class CustomConfig {
    @Autowired
    private SoccerRepository soccerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner populate() {
        return strings -> {
            User user = new User("foobar", "foobar", "foobar@gmail.com", passwordEncoder.encode("foobar"));
            Role roleUser = roleRepository.findByName(RoleName.ROLE_USER).orElse(null);
            user.setRoles(Collections.singleton(roleUser));
            userRepository.save(user);
            List<SoccerPlayer> baseList = Arrays.asList(
                    new SoccerPlayer("messi", 30, 3000.0, "Argentina", "Barcelona"),
                    new SoccerPlayer("ronaldo", 32, 3200.0, "Portugal", "Juventus"),
                    new SoccerPlayer("Ibrahimovic", 35, 3500.0, "Sweden", "Galaxy"));

            List<SoccerPlayer> soccerPlayerList = new ArrayList<>();
            for(int i=0; i< 51; ++i) {
                soccerPlayerList.addAll(baseList.stream()
                        .map(one -> new SoccerPlayer(one.getName(), one.getAge(), one.getWage(), one.getCountry(), one.getTeam()))
                        .collect(Collectors.toList()));
            }

            soccerRepository.saveAll(soccerPlayerList);
        };
    }
}
