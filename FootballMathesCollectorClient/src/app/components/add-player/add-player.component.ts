import { Component, OnInit } from '@angular/core';
import { Player } from 'src/app/models/player.model';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-add-player',
  templateUrl: './add-player.component.html',
  styleUrls: ['./add-player.component.css']
})
export class AddPlayerComponent implements OnInit {
  player: Player = {
    firstName: '',
    lastName: '',
    age: 0,
    club: ''
  };
  submitted = false;
  constructor(private playerService: PlayerService) { }
  ngOnInit(): void {
  }
  savePlayer(): void {
    const data = {
      firstName: this.player.firstName,
      lastName: this.player.lastName,
      age: this.player.age,
      club: this.player.club
    };
    this.playerService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }
  newPlayer(): void {
    this.submitted = false;
    this.player = {
      firstName: '',
      lastName: '',
      age: 0,
      club: ''
    };
  }

}
