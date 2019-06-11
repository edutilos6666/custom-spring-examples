import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Top10SoccerPlayersComponent } from './top10-soccer-players.component';

describe('Top10SoccerPlayersComponent', () => {
  let component: Top10SoccerPlayersComponent;
  let fixture: ComponentFixture<Top10SoccerPlayersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Top10SoccerPlayersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Top10SoccerPlayersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
