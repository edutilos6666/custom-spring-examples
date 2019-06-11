import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators,NgForm, FormControl } from '@angular/forms';
import { SignUpRequest } from '../../models/SignUpRequest';
import { PasswordValidator } from '../../validators/PasswordValidator';
import { ApiClientService } from 'src/app/services/api-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  signupRequest: SignUpRequest = new SignUpRequest();
  // name: string = "";
  // username: string = "";
  // email: string = "";
  // password: string = "";
  constructor(private formBuilder: FormBuilder, 
              private apiClient: ApiClientService, 
              private router: Router) {
    // this.signupForm = formBuilder.group({
    //   "name": [null, Validators.required],
    //   "username": [null , Validators.required],
    //   "email": [null, Validators.required],
    //   "password": [null, Validators.required]
    // });
    this.signupForm = this.createFormGroup();
   }

  createFormGroup() {
    return new FormGroup({
      name: new FormControl(this.signupRequest.name,
            [Validators.required, Validators.minLength(4), Validators.maxLength(40)]),
      username: new FormControl(this.signupRequest.username,
                [Validators.required, Validators.minLength(3), Validators.maxLength(15)]),
      email: new FormControl(this.signupRequest.email,
              [Validators.required, Validators.email, Validators.maxLength(40)]),
      password: new FormControl(this.signupRequest.password,
                [Validators.required, Validators.minLength(6), Validators.maxLength(20)]),
      passwordRepeat: new FormControl("", 
                [Validators.required, Validators.minLength(6), Validators.maxLength(20)])
    }, {
      validators: [PasswordValidator.validate.bind(this)]
    });
  }

  ngOnInit() {
  }

  onSubmit(form:NgForm) {
    console.log(form);
    const signupRequest = new SignUpRequest();
    signupRequest.name = form.name;
    signupRequest.username = form.username;
    signupRequest.email = form.email;
    signupRequest.password = form.password;
    this.apiClient.signupAction(signupRequest).subscribe(one=> this.router.navigateByUrl("/login"));
  }

  clearFields() {
    this.signupForm.reset({ signupRequest:  new SignUpRequest(),
      passwordRepeat: ""});
  }

  allFieldsEmpty(): boolean {
    const nameValue = this.name.value;
    const usernameValue = this.username.value;
    const emailValue = this.email.value;
    const passwordValue = this.password.value;
    const passwordRepeatValue = this.passwordRepeat.value;
    return (nameValue === null || nameValue.length === 0) &&
           (usernameValue === null || usernameValue.length === 0) &&
           (emailValue === null || emailValue.length === 0) &&
           (passwordValue === null || passwordValue.length === 0) &&
           (passwordRepeatValue === null || passwordRepeatValue.length === 0);
  }


  // getters for simplying access in template file
  get name() {
    return this.signupForm.get("name");
  }
  get username() {
    return this.signupForm.get("username");
  }
  get email() {
    return this.signupForm.get("email");
  }
  get password() {
    return this.signupForm.get("password");
  }

  get passwordRepeat() {
    return this.signupForm.get("passwordRepeat");
  }


}
