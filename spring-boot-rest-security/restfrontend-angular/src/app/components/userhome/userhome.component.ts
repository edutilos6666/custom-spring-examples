import { Component, OnInit } from '@angular/core';
import { ConstantsService } from 'src/app/services/constants.service';
import { UserProfile } from 'src/app/models/UserProfile';
import { SoccerPlayerResponse } from 'src/app/models/SoccerPlayerResponse';
import { ApiClientService } from 'src/app/services/api-client.service';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.scss']
})
export class UserhomeComponent implements OnInit {
  currentUser: UserProfile;
  players: SoccerPlayerResponse[];
  constructor(private constants: ConstantsService, 
              private apiClient: ApiClientService) { }

  ngOnInit() {
    this.currentUser = this.constants.CURRENT_USER;
    this.apiClient.findFirst10Players().subscribe(players=> {
      this.players = players;
    })
  }

}
