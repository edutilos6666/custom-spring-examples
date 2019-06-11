import {HttpClient} from '@angular/common/http';
import {Component, OnInit, ViewChild, AfterViewInit} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {merge, Observable, of as observableOf} from 'rxjs';
import {catchError, map, startWith, switchMap} from 'rxjs/operators';
import { SoccerPlayerResponse } from 'src/app/models/SoccerPlayerResponse';
import { ConstantsService } from 'src/app/services/constants.service';
import { ApiClientService } from 'src/app/services/api-client.service';

@Component({
  selector: 'app-all-soccer-players',
  templateUrl: './all-soccer-players.component.html',
  styleUrls: ['./all-soccer-players.component.scss']
})
export class AllSoccerPlayersComponent implements OnInit, AfterViewInit {

  displayedColumns: string[] = ['name', 'age', 'wage', 'country', 'team'];
  data: SoccerPlayerResponse[] = [];

  resultsLength = 0;
  isLoadingResults = true;
  isRateLimitReached = false;

  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;

  constructor(private _httpClient: HttpClient, 
              private apiClient: ApiClientService) {}

  ngOnInit() {
  }

  ngAfterViewInit() {
 

    // If the user changes the sort order, reset back to the first page.
    // this.sort.sortChange.subscribe(() => this.paginator.pageIndex = 0);

    merge(this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.apiClient.findPlayersbyPage(this.paginator.pageIndex);
        }),
        map(data => {
          // Flip flag to show that loading has finished.
          this.apiClient.getTotalSoccerPlayersCount().subscribe(totalCount => {
          this.isLoadingResults = false;
          this.isRateLimitReached = false;
          this.resultsLength = totalCount;
          });
          return data;
        }),
        catchError(() => {
          this.isLoadingResults = false;
          // Catch if the GitHub API has reached its rate limit. Return empty data.
          this.isRateLimitReached = true;
          return observableOf([]);
        })
      ).subscribe(data => this.data = data);
  }
}

