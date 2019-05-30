package com.example.utils;

import com.example.payload.*;
import com.example.wrapper.SoccerPlayerList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.example.utils.UrlStrings.*;
/**
 * Created by Nijat Aghayev on 30.05.19.
 */
@Slf4j
@Service
public class ApiClient {
    @Autowired
    private RestTemplate restTemplate;

    public void displayRestTemplate() {
        log.info(restTemplate.toString());
    }

    public ApiResponse singupAction(SignUpRequest signUpRequest) {
        return restTemplate.postForObject(SIGNUP_URL, signUpRequest, ApiResponse.class);
    }

    public JwtAuthenticationResponse loginAction(LoginRequest loginRequest) {
        return restTemplate.postForObject(SIGNIN_URL, loginRequest, JwtAuthenticationResponse.class);
    }

    public UserProfile findUserByUsername(String username) {
        return restTemplate.getForObject(String.format("%s/%s", USERS_URL, username), UserProfile.class);
    }

    public List<SoccerPlayer> findAllSoccerPlayers() {
        ResponseEntity<List<SoccerPlayer>> response = restTemplate.exchange(SOCCER_PLAYERS_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SoccerPlayer>>() {
                });
//        SoccerPlayerList response = restTemplate.getForObject(SOCCER_PLAYERS_URL, SoccerPlayerList.class);
        log.info(response.getBody().size()+"");
        return response.getBody();
    }
}
