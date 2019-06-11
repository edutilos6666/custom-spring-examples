import { Component, OnInit, Input } from '@angular/core';
import { SoccerPlayerResponse } from 'src/app/models/SoccerPlayerResponse';

@Component({
  selector: 'app-top10-soccer-players',
  templateUrl: './top10-soccer-players.component.html',
  styleUrls: ['./top10-soccer-players.component.scss']
})
export class Top10SoccerPlayersComponent implements OnInit {
  @Input() players: SoccerPlayerResponse[];
  constructor() { }

  ngOnInit() {
  }

}
