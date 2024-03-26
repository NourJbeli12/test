import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { RegisterRequest } from '../model/register-request';
import { AuthenticationResponse } from '../model/authentication-response';
import { VerificationRequest } from '../model/verification-request';
import { AuthenticationRequest } from '../model/authentication-request';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private baseUrl = 'http://localhost:8080/api/v1/auth'

  constructor(
    private http: HttpClient
  ) { }

  register(
    registerRequest: RegisterRequest
  ) {
    console.log("jjjjjj", registerRequest)
    return this.http.post<AuthenticationResponse>
    (`${this.baseUrl}/register`, registerRequest);
  }

  login(
    authRequest: AuthenticationRequest
  ) {
    console.log("jjjjjj", authRequest)
    return this.http.post<AuthenticationResponse>
    (`${this.baseUrl}/authenticate`, authRequest);
  }

  verifyCode(verificationRequest: VerificationRequest) {
    return this.http.post<AuthenticationResponse>
    (`${this.baseUrl}/verify`, verificationRequest);
  }
}