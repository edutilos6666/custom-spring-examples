import { Injectable } from '@angular/core';
import { UserProfile } from '../models/UserProfile';

@Injectable({
  providedIn: 'root'
})
export class ConstantsService {
  BASE_URL: string = "http://localhost:8080/api";
  SIGNUP_URL: string = `${this.BASE_URL}/auth/signup`;
  SIGNIN_URL: string = `${this.BASE_URL}/auth/signin`;
  SOCCER_PLAYERS_URL: string = `${this.BASE_URL}/soccer/players`;
  USERS_URL: string = `${this.BASE_URL}/users`;
  AUTH_TOKEN: string = null;
  CURRENT_USER: UserProfile = null;
  PAGE_SIZE = 13;
  constructor() { }
}
