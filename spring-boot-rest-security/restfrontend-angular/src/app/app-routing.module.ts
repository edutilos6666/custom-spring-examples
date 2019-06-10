import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { UserhomeComponent } from './components/userhome/userhome.component';

const routes: Routes = [
  {path: "", component: SignupComponent},
  {path: "login", component: LoginComponent},
  {path: "home", component: UserhomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
