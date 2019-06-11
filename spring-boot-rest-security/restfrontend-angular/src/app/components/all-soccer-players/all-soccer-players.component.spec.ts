import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllSoccerPlayersComponent } from './all-soccer-players.component';

describe('AllSoccerPlayersComponent', () => {
  let component: AllSoccerPlayersComponent;
  let fixture: ComponentFixture<AllSoccerPlayersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllSoccerPlayersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllSoccerPlayersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
