import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, NgForm, FormControl } from '@angular/forms';
import { LoginRequest } from 'src/app/models/LoginRequest';
import { ApiClientService } from 'src/app/services/api-client.service';
import { ConstantsService } from 'src/app/services/constants.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loginRequest: LoginRequest = new LoginRequest();

  constructor(private apiClient: ApiClientService,
              private constants: ConstantsService,
              private router: Router) {
    this.loginForm = this.createFormGroup();
   }

  createFormGroup() {
    return new FormGroup({
      usernameOrEmail: new FormControl(this.loginRequest.usernameOrEmail,
        [Validators.required]),
      password: new FormControl(this.loginRequest.password,
        [Validators.required])
    });
  }

  ngOnInit() {
  }

  onSubmit(form: NgForm) {
    console.log(form, " and ", this.loginRequest); // loginRequest is empty, why?
    this.apiClient.loginAction({usernameOrEmail: form.usernameOrEmail,
    password: form.password}).subscribe(tokenHolder=> {
      if(tokenHolder !== null && tokenHolder.accessToken !== null) {
        this.constants.AUTH_TOKEN = tokenHolder.accessToken;
        this.apiClient.findByUsername(form.usernameOrEmail).subscribe(user=> {
          this.constants.CURRENT_USER = Object.create(user);
          this.router.navigateByUrl("/home");
        });
      }
    });
  }

  clearFields() {
    this.loginForm.reset({ loginRequest: new LoginRequest() });
  }


  allFieldsEmpty() {
    const usernameOrEmailValue = this.usernameOrEmail.value;
    const passwordValue = this.password.value;
    return (usernameOrEmailValue === null || usernameOrEmailValue.length === 0) &&
           (passwordValue === null || passwordValue.length === 0);
  }



  // getters
  get usernameOrEmail() {
    return this.loginForm.get("usernameOrEmail");
  }

  get password() {
    return this.loginForm.get("password");
  }
}
