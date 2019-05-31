package com.example.utils;

import com.example.payload.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public List<SoccerPlayerResponse> findAllSoccerPlayers() {
        ResponseEntity<List<SoccerPlayerResponse>> response = restTemplate.exchange(SOCCER_PLAYERS_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SoccerPlayerResponse>>() {
                });
//        SoccerPlayerList response = restTemplate.getForObject(SOCCER_PLAYERS_URL, SoccerPlayerList.class);
        log.info(response.getBody().size()+"");
        return response.getBody();
    }

    public List<SoccerPlayerResponse> firdFirst10Players() {
        String url = String.format("%s/0/%d", SOCCER_PLAYERS_URL, Constants.SOCCER_PLAYERS_PAGE_SIZE);
        ResponseEntity<List<SoccerPlayerResponse>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SoccerPlayerResponse>>() {
                });
//        SoccerPlayerList response = restTemplate.getForObject(SOCCER_PLAYERS_URL, SoccerPlayerList.class);
        log.info(response.getBody().size()+"");
        return response.getBody();
    }

    public Long getTotalSoccerPlayersCount() {
        String url = String.format("%s/totalElementsCount/%d", SOCCER_PLAYERS_URL, Constants.SOCCER_PLAYERS_PAGE_SIZE);
        Long totalCount = restTemplate.getForObject(url, Long.class);
        return totalCount;
    }

    public Integer getTotalSoccerPlayersPageCount() {
        String url = String.format("%s/totalPagesCount/%d", SOCCER_PLAYERS_URL, Constants.SOCCER_PLAYERS_PAGE_SIZE);
        Integer totalPageCount = restTemplate.getForObject(url, Integer.class);
        return totalPageCount;
    }

    public List<SoccerPlayerResponse> findPlayersByPage(int pageNumber) {
        String url = String.format("%s/%d/%d", SOCCER_PLAYERS_URL, pageNumber, Constants.SOCCER_PLAYERS_PAGE_SIZE);
        ResponseEntity<List<SoccerPlayerResponse>> response = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<SoccerPlayerResponse>>() {
                });
        return response.getBody();
    }
}
