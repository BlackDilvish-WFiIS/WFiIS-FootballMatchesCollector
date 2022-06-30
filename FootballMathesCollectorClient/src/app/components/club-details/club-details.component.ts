import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Club } from 'src/app/models/club.model';
import { ClubService } from 'src/app/services/club.service';

@Component({
  selector: 'app-club-details',
  templateUrl: './club-details.component.html',
  styleUrls: ['./club-details.component.css']
})
export class ClubDetailsComponent implements OnInit {

  @Input() viewMode = false;
  @Input() currentClub: Club = {
    name: '',
    country: '',
    league: ''
  };
  
  message = '';
  constructor(
    private clubService: ClubService,
    private route: ActivatedRoute,
    private router: Router) { }
  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getClub(this.route.snapshot.params["id"]);
    }
  }
  getClub(id: string): void {
    this.clubService.get(id)
      .subscribe({
        next: (data) => {
          this.currentClub = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  updateClub(): void {
    this.message = '';
    this.clubService.update(this.currentClub.id, this.currentClub)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'Dane klubu zostały pomyślnie zaktualizowane!';
        },
        error: (e) => console.error(e)
      });
  }
  deleteClub(): void {
    this.clubService.delete(this.currentClub.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/clubs']);
        },
        error: (e) => console.error(e)
      });
  }

}
