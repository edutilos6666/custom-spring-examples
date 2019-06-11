import { Component, OnInit } from '@angular/core';
import { ConstantsService } from 'src/app/services/constants.service';
import { UserProfile } from 'src/app/models/UserProfile';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  currentUser: UserProfile;

  constructor(private constants: ConstantsService, 
              private router: Router) { }

  ngOnInit() {
    this.currentUser = this.constants.CURRENT_USER;
  }

  signOut() {
    this.constants.AUTH_TOKEN = null;
    this.constants.CURRENT_USER = null;
    this.router.navigateByUrl("/login");
  }

}
