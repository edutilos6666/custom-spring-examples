import { Injectable } from '@angular/core';
import { ConstantsService } from './constants.service';
import { SignUpRequest } from '../models/SignUpRequest';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/ApiResponse';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LoginRequest } from '../models/LoginRequest';
import { JwtAuthenticationResponse } from '../models/JwtAuthenticationResponse';
import { UserProfile } from '../models/UserProfile';
import { SoccerPlayerResponse } from '../models/SoccerPlayerResponse';

@Injectable({
  providedIn: 'root'
})
export class ApiClientService {
  httpOptions: object = {
    headers: new HttpHeaders({
      "Content-Type": "application/json"
    })
 };

  constructor(private constants:ConstantsService,
              private httpClient: HttpClient) { }

  signupAction(signupRequest: SignUpRequest): Observable<ApiResponse> {
    return this.httpClient.post<ApiResponse>(this.constants.SIGNUP_URL, signupRequest);
  }

  loginAction(loginRequest: LoginRequest): Observable<JwtAuthenticationResponse> {
    console.log(loginRequest);
    return this.httpClient.post<JwtAuthenticationResponse>(this.constants.SIGNIN_URL, loginRequest, this.httpOptions);
  }

  findByUsername(username: string): Observable<UserProfile> {
    const url = `${this.constants.USERS_URL}/${username}`;
    return this.httpClient.get<UserProfile>(url);
  }

  findFirst10Players(): Observable<SoccerPlayerResponse[]> {
    const url = `${this.constants.SOCCER_PLAYERS_URL}/0/10`;
    return this.httpClient.get<SoccerPlayerResponse[]>(url);
  }

  findAllSoccerPlayers(): Observable<SoccerPlayerResponse[]> {
    return this.httpClient.get<SoccerPlayerResponse[]>(this.constants.SOCCER_PLAYERS_URL);
  }
}
