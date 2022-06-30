import { Component, OnInit } from '@angular/core';
import { Match } from 'src/app/models/match.model';
import { MatchService } from 'src/app/services/match.service';

@Component({
  selector: 'app-add-match',
  templateUrl: './add-match.component.html',
  styleUrls: ['./add-match.component.css']
})
export class AddMatchComponent implements OnInit {

  match: Match = {
    date: '',
    result: '',
    homeClub: '',
    awayClub: '',
    awayGoalkeeper: '',
    awayLeftBack: '',
    awayLeftCenterBack: '',
    awayRightCenterBack: '',
    awayRightBack: '',
    awayLeftMidfielder: '',
    awayLeftCenterMidfielder: '',
    awayRightCenterMidfielder: '',
    awayRightMidfielder: '',
    awayLeftStriker: '',
    awayRightStriker: '',
    homeGoalkeeper: '',
    homeLeftBack: '',
    homeLeftCenterBack: '',
    homeRightCenterBack: '',
    homeRightBack: '',
    homeLeftMidfielder: '',
    homeLeftCenterMidfielder: '',
    homeRightCenterMidfielder: '',
    homeRightMidfielder: '',
    homeLeftStriker: '',
    homeRightStriker: ''
  };
  submitted = false;
  constructor(private matchService: MatchService) { }
  ngOnInit(): void {
  }
  saveMatch(): void {
    const data = {
      date: this.match.date,
      result: this.match.result,
      homeClub: this.match.homeClub,
      awayClub: this.match.awayClub,
      awayGoalkeeper: this.match.awayGoalkeeper,
      awayLeftBack: this.match.awayLeftBack,
      awayLeftCenterBack: this.match.awayLeftCenterBack,
      awayRightCenterBack: this.match.awayRightCenterBack,
      awayRightBack: this.match.awayRightBack,
      awayLeftMidfielder: this.match.awayLeftMidfielder,
      awayLeftCenterMidfielder: this.match.awayLeftCenterMidfielder,
      awayRightCenterMidfielder: this.match.awayRightCenterMidfielder,
      awayRightMidfielder: this.match.awayRightMidfielder,
      awayLeftStriker: this.match.awayLeftStriker,
      awayRightStriker: this.match.awayRightStriker,
      homeGoalkeeper: this.match.homeGoalkeeper,
      homeLeftBack: this.match.homeLeftBack,
      homeLeftCenterBack: this.match.homeLeftCenterBack,
      homeRightCenterBack: this.match.homeRightCenterBack,
      homeRightBack: this.match.homeRightBack,
      homeLeftMidfielder: this.match.homeLeftMidfielder,
      homeLeftCenterMidfielder: this.match.homeLeftCenterMidfielder,
      homeRightCenterMidfielder: this.match.homeRightCenterMidfielder,
      homeRightMidfielder: this.match.homeRightMidfielder,
      homeLeftStriker: this.match.homeLeftStriker,
      homeRightStriker: this.match.homeRightStriker
    };
    this.matchService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }
  newMatch(): void {
    this.submitted = false;
    this.match = {
      date: '',
      result: '',
      homeClub: '',
      awayClub: '',
      awayGoalkeeper: '',
      awayLeftBack: '',
      awayLeftCenterBack: '',
      awayRightCenterBack: '',
      awayRightBack: '',
      awayLeftMidfielder: '',
      awayLeftCenterMidfielder: '',
      awayRightCenterMidfielder: '',
      awayRightMidfielder: '',
      awayLeftStriker: '',
      awayRightStriker: '',
      homeGoalkeeper: '',
      homeLeftBack: '',
      homeLeftCenterBack: '',
      homeRightCenterBack: '',
      homeRightBack: '',
      homeLeftMidfielder: '',
      homeLeftCenterMidfielder: '',
      homeRightCenterMidfielder: '',
      homeRightMidfielder: '',
      homeLeftStriker: '',
      homeRightStriker: ''
    };
  }

}
