import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Match } from 'src/app/models/match.model';
import { MatchService } from 'src/app/services/match.service';

@Component({
  selector: 'app-match-details',
  templateUrl: './match-details.component.html',
  styleUrls: ['./match-details.component.css']
})
export class MatchDetailsComponent implements OnInit {

  @Input() viewMode = false;
  @Input() currentMatch: Match = {
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
  
  message = '';
  constructor(
    private matchService: MatchService,
    private route: ActivatedRoute,
    private router: Router) { }
  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getMatch(this.route.snapshot.params["id"]);
    }
  }
  getMatch(id: string): void {
    this.matchService.get(id)
      .subscribe({
        next: (data) => {
          this.currentMatch = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }
  updateMatch(): void {
    this.message = '';
    this.matchService.update(this.currentMatch.id, this.currentMatch)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'Mecz został pomyślnie zaktualizowany!';
        },
        error: (e) => console.error(e)
      });
  }
  deleteMatch(): void {
    this.matchService.delete(this.currentMatch.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/matches']);
        },
        error: (e) => console.error(e)
      });
  }

}
