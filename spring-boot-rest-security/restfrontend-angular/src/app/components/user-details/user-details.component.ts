import { Component, OnInit } from '@angular/core';
import { ConstantsService } from 'src/app/services/constants.service';
import { UserProfile } from 'src/app/models/UserProfile';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.scss']
})
export class UserDetailsComponent implements OnInit {
  currentUser: UserProfile;
  constructor(private constants: ConstantsService) { }

  ngOnInit() {
    this.currentUser = this.constants.CURRENT_USER;
  }

}
