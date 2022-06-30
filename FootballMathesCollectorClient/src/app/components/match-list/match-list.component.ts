import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/models/match.model';
import { MatchService } from 'src/app/services/match.service';

@Component({
  selector: 'app-match-list',
  templateUrl: './match-list.component.html',
  styleUrls: ['./match-list.component.css']
})
export class MatchListComponent implements OnInit {

  matchs?: Match[];
  currentMatch: Match = {};
  currentIndex = -1;
  club = '';
  constructor(private matchService: MatchService) { }
  ngOnInit(): void {
    this.retrieveMatchs();
  }
  retrieveMatchs(): void {
    this.matchService.getAll()
      .subscribe({
        next: (data) => {
          this.matchs = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    
  }
  refreshList(): void {
    this.retrieveMatchs();
    this.currentMatch = {};
    this.currentIndex = -1;
  }
  setActiveMatch(match: Match, index: number): void {
    this.currentMatch = match;
    this.currentIndex = index;
  }
  removeAllMatchs(): void {
    this.matchService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }
  searchclub(): void {
    this.currentMatch = {};
    this.currentIndex = -1;
    this.matchService.findByClub(this.club)
      .subscribe({
        next: (data) => {
          this.matchs = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

}
