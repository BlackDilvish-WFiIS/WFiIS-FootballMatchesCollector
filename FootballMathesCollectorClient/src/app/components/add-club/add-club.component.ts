import { Component, OnInit } from '@angular/core';
import { Club } from 'src/app/models/club.model';
import { ClubService } from 'src/app/services/club.service';

@Component({
  selector: 'app-add-club',
  templateUrl: './add-club.component.html',
  styleUrls: ['./add-club.component.css']
})
export class AddClubComponent implements OnInit {

  club: Club = {
    name: '',
    country: '',
    league: ''
  };
  submitted = false;
  constructor(private clubService: ClubService) { }
  ngOnInit(): void {
  }
  saveClub(): void {
    const data = {
      name: this.club.name,
      country: this.club.country,
      league: this.club.league
    };
    this.clubService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }
  newClub(): void {
    this.submitted = false;
    this.club = {
      name: '',
      country: '',
      league: ''
    };
  }

}
