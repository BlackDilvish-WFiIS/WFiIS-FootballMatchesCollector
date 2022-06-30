import { Component, OnInit } from '@angular/core';
import { Club } from 'src/app/models/club.model';
import { ClubService } from 'src/app/services/club.service';

@Component({
  selector: 'app-club-list',
  templateUrl: './club-list.component.html',
  styleUrls: ['./club-list.component.css']
})
export class ClubListComponent implements OnInit {

  clubs?: Club[];
  currentClub: Club = {};
  currentIndex = -1;
  name = '';
  constructor(private clubService: ClubService) { }
  ngOnInit(): void {
    this.retrieveClubs();
  }
  retrieveClubs(): void {
    this.clubService.getAll()
      .subscribe({
        next: (data) => {
          this.clubs = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    
  }
  refreshList(): void {
    this.retrieveClubs();
    this.currentClub = {};
    this.currentIndex = -1;
  }
  setActiveClub(club: Club, index: number): void {
    this.currentClub = club;
    this.currentIndex = index;
  }
  removeAllClubs(): void {
    this.clubService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }
  searchname(): void {
    this.currentClub = {};
    this.currentIndex = -1;
    this.clubService.findByName(this.name)
      .subscribe({
        next: (data) => {
          this.clubs = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

}
